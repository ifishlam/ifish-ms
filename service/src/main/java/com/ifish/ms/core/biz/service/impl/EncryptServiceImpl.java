/*
 * Copyright (c) 2017. iFish Studio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * @author Angus Lam
 * @date 2017/11/24
 *
 *
 */

package com.ifish.ms.core.biz.service.impl;

import com.ifish.ms.core.biz.service.EncryptService;
import com.ifish.ms.core.exception.ApplicationException;
import com.ifish.ms.core.exception.ApplicationExceptionCode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Service;

@Service("encryptService")
public class EncryptServiceImpl implements EncryptService {

    @Override
    public String encryptByMd5(String str) throws ApplicationException {

        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new ApplicationException(ApplicationExceptionCode.ERROR_SYSTEM_UNKNOWN);
        }
        return result;
    }
}
