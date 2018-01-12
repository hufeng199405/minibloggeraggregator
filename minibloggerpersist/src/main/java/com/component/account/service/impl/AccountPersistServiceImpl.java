package com.component.account.service.impl;


import com.component.account.model.Account;
import com.component.account.service.AccountPersistService;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

/**
 * 账户服务层实现
 *
 * @author Administrator
 * @version 1.0
 * @date 2017-12-16 11:29
 * @desc
 * @since 1.8
 */
public class AccountPersistServiceImpl implements AccountPersistService {

    public static final String ACCOUNT_ROOT = "account-persist";

    public static final String ACCOUNTS = "accounts";

    public static final String ACCOUNT = "account";

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String EMAIL = "email";

    public static final String PASSWORD = "password";

    public static final String ACTIVATED = "activated";

    public static final String SUCCESS = "success";

    // 文件路径
    private String file;

    // dom4j操作流
    private SAXReader saxReader = new SAXReader();

    /**
     * 生成document对象
     */
    private Document readDocument() throws Exception {

        File dateFile = new File(file);

        if (!dateFile.exists()) {

            dateFile.getParentFile().mkdirs();

            Document document = DocumentFactory.getInstance().createDocument();

            Element element = document.addElement(ACCOUNT_ROOT);

            element.addElement(ACCOUNTS);

            writeDocument(document);
        }

        return saxReader.read(dateFile);
    }

    /**
     * 读取document对象
     */
    private void writeDocument(Document document) throws Exception {

        Writer out = null;

        try {

            out = new OutputStreamWriter(new FileOutputStream(file), "utf-8");

            XMLWriter xmlWriter = new XMLWriter(out, OutputFormat.createPrettyPrint());

            xmlWriter.write(document);
        } catch (Exception e) {

            throw e;
        } finally {

            if (out != null) {

                out.close();
            }
        }
    }

    /**
     * 创建账户
     */
    @Override
    public String createAccount(Account account) throws Exception {

        // 创建document元素
        Document document = this.readDocument();

        Element element = document.getRootElement().element(ACCOUNTS);

        element = element.addElement(ACCOUNT);

        element.addElement(ID);
        element.element(ID).addText(account.getId());

        element.addElement(NAME);
        element.element(NAME).addText(account.getName());

        element.addElement(PASSWORD);
        element.element(PASSWORD).addText(account.getPassword());

        element.addElement(EMAIL);
        element.element(EMAIL).addText(account.getEmail());

        element.addElement(ACTIVATED);
        element.element(ACTIVATED).addText(account.isActivated() ? "true" : "false");

        // 写入xml文件
        this.writeDocument(document);

        return SUCCESS;
    }

    /**
     * 查询账户
     */
    @Override
    public Account selectAccount(String id) throws Exception {

        Document document = readDocument();

        List<Element> accounts = document.getRootElement().element(ACCOUNTS).elements();

        for (Element accountEle : accounts) {

            if (accountEle.element(ID).getText().equals(id)) {

                return buildAccount(accountEle);
            }
        }

        return null;
    }

    /**
     * 封装账户信息
     */
    private Account buildAccount(Element element) throws Exception {

        Account account = new Account();

        account.setId(element.elementText(ID));

        account.setName(element.elementText(NAME));

        account.setEmail(element.elementText(EMAIL));

        account.setPassword(element.elementText(PASSWORD));

        account.setActivated("true".equals(element.elementText(ACTIVATED)));

        return account;
    }

    @Override
    public String updateAccount(Account account) throws Exception {

        Document document = readDocument();

        List<Element> accountsEle = document.getRootElement().element(ACCOUNTS).elements();

        for (Element accountEle : accountsEle) {

            if (accountEle.element(ID).getText().equals(account.getId())) {

                updateAccount(accountEle, account);

                // 写入xml文件
                this.writeDocument(document);

                return SUCCESS;
            }
        }

        return null;
    }

    /**
     * 修改账户信息
     */
    private String updateAccount(Element oldAccount, Account newOldAccount) throws Exception {

        oldAccount.element(ID).setText(newOldAccount.getId());
        oldAccount.element(NAME).setText(newOldAccount.getName());
        oldAccount.element(PASSWORD).setText(newOldAccount.getPassword());
        oldAccount.element(EMAIL).setText(newOldAccount.getEmail());
        oldAccount.element(ACTIVATED).setText(newOldAccount.isActivated() ? "true" : "false");

        return SUCCESS;
    }

    @Override
    public String deleteAccount(String id) throws Exception {

        Document document = readDocument();

        List<Element> accountsEle = document.getRootElement().element(ACCOUNTS).elements();

        for (Element accountEle : accountsEle) {

            if (accountEle.elementText(ID).equals(id)) {

                accountsEle.remove(accountEle);

                break;
            }
        }

        // 写入xml文件
        this.writeDocument(document);

        return SUCCESS;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
