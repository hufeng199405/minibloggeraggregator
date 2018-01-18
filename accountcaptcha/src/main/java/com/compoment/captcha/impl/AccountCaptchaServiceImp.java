package com.compoment.captcha.impl;

import com.compoment.util.RandomGenerator;
import com.compoment.captcha.AccountCaptchaService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class AccountCaptchaServiceImp implements AccountCaptchaService, InitializingBean {

    private Logger logger = Logger.getLogger(this.getClass());

    private DefaultKaptcha producer;

    private Map<String, String> captchaMap = new HashMap<String, String>();

    private List<String> preDefinedTexts;

    private int textCount = 0;

    @Override
    public void afterPropertiesSet() throws Exception {

        producer = new DefaultKaptcha();

        producer.setConfig(new Config(new Properties()));
    }

    @Override
    public String generateCaptchaKey() throws Exception {

        String key = RandomGenerator.getRandonString();

        String value = getCaptchaText();

        captchaMap.put(key, value);

        return key;
    }

    private String getCaptchaText() {

        if (preDefinedTexts != null && preDefinedTexts.isEmpty()) {

            String text = preDefinedTexts.get(textCount);

            textCount = (textCount + 1) % preDefinedTexts.size();

            return text;
        } else {

            return producer.createText();
        }
    }

    @Override
    public byte[] generateCaptchaImage(String captchaKey) throws Exception {

        String text = this.captchaMap.get(captchaKey);

        if (text == null) {

            logger.error("captch key" + captchaKey + "not found");
            throw new Exception("captch key" + captchaKey + "not found");
        }

        BufferedImage image = producer.createImage(text);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ImageIO.write(image, "jpg", outputStream);

        return outputStream.toByteArray();
    }

    @Override
    public boolean validateCaptcha(String captchaKey, String captchaValue) throws Exception {

        String text = this.captchaMap.get(captchaKey);

        if (text == null && text == "") {

            logger.error("captch key" + captchaKey + "not found");
            throw new Exception("captch key" + captchaKey + "not found");
        }

        if (text.equals(captchaValue)) {

            this.captchaMap.remove(captchaKey);
            return true;
        }

        return false;
    }

    @Override
    public List<String> getpredefinedTest() {
        return null;
    }

    @Override
    public void setPreDefinedTexts(List<String> preDefinedTexts) {

    }

    public Map<String, String> getCaptchaMap() {
        return captchaMap;
    }

    public void setCaptchaMap(Map<String, String> captchaMap) {
        this.captchaMap = captchaMap;
    }

    public List<String> getPreDefinedTexts() {
        return preDefinedTexts;
    }

    public int getTextCount() {
        return textCount;
    }

    public void setTextCount(int textCount) {
        this.textCount = textCount;
    }
}
