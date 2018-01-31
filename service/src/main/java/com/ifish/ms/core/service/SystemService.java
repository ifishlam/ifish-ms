/*
 * Copyright (c) 2017. iFish Studio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * @author Angus Lam
 * @date 2017/10/21
 *
 *
 */

package com.ifish.ms.core.service;

import java.util.Map;

public interface SystemService {

    String getActiveSystemProperty(String propertyKey);

    Map listActiveSystemProperty();

    Map listInactiveSystemProperty();

    Map listAllSystemProperty();
}
