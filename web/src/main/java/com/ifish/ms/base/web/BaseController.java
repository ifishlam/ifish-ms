/*
 * Copyright (c) 2017. iFish Studio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * @author Angus Lam
 * @date 2017/10/20
 *
 *
 */

package com.ifish.ms.base.web;

public class BaseController {

    protected Object saveResult(Object obj) {

        ResponseResult result = new ResponseResult(obj);

        return result;
    }
}
