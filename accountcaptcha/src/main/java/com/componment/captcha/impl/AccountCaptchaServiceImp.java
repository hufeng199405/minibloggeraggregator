package com.componment.captcha.impl;

import com.componment.captcha.AccountCaptchaService;

import java.util.List;

public class AccountCaptchaServiceImp implements AccountCaptchaService {


    @Override
    public String generateCaptchaKey() throws Exception {
        return null;
    }

    @Override
    public byte[] generateCaptchaImage(String captchaKey) throws Exception {
        return new byte[0];
    }

    @Override
    public boolean validateCaptcha(String captchaKey, String captchaValue) throws Exception {
        return false;
    }

    @Override
    public List<String> getpredefinedTest() {
        return null;
    }

    @Override
    public void setPreDefinedTexts(List<String> preDefinedTexts) {

    }
}
