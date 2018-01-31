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

package com.ifish.ms.base.view;


import com.ifish.ms.base.bean.BaseBean;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class BaseListView<Bean extends BaseBean> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected final List<BaseView<Bean>> beanViewList;

    @SuppressWarnings({"unchecked", "rawtypes"})
    protected BaseListView(Iterable<Bean> beanList, Class<? extends BaseView<Bean>> viewClass) {
        this.beanViewList = new ArrayList<BaseView<Bean>>();

        Constructor[] constructors = viewClass.getConstructors();
        int constructorsLength = constructors.length;

        if (constructorsLength > 0) {
            try {
                for (int i = 0; i < constructorsLength; i++) {
                    if (constructors[i].getParameterTypes() != null) {
                        for (Bean bean : beanList) {
                            this.beanViewList.add((BaseView<Bean>) constructors[i].newInstance(bean));
                        }
                    }
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public List<BaseView<Bean>> getEntries() {
        return this.beanViewList;
    }

}
