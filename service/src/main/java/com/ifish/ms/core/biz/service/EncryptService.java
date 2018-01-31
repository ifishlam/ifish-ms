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

package com.ifish.ms.core.biz.service;

import com.ifish.ms.core.exception.ApplicationException;

public interface EncryptService {

    /**
     * Encrypt the string by MD5
     *
     * @param str
     * @return
     * @throws ApplicationException
     */
    String encryptByMd5(String str) throws ApplicationException;

}
