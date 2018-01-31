package com.ifish.ms.core.exception;

import com.google.common.base.Strings;
import com.ifish.ms.core.util.ObjectUtils;
import com.ifish.ms.core.util.SystemConstants;

public class ApplicationException extends Exception {

    private static final long serialVersionUID = 1L;

    public ApplicationException(ApplicationExceptionCode exceptionCode) {

        super(formatMessage(exceptionCode, null));
    }

    public ApplicationException(ApplicationExceptionCode exceptionCode, String errorMessage) {

        super(formatMessage(exceptionCode, errorMessage));
    }

    public ApplicationException(ApplicationExceptionCode exceptionCode, String errorMessage, Object... errorMessageArgs) {

        super(formatMessage(exceptionCode, ObjectUtils.format(errorMessage, errorMessageArgs)));
    }

    public ApplicationException(ApplicationExceptionCode exceptionCode, Throwable cause) {

        super(formatMessage(exceptionCode, null), cause);
    }

    private static String formatMessage(ApplicationExceptionCode exceptionCode, String errorMessage) {

        String msg = exceptionCode.getCode() + SystemConstants.RECORD_SEPARATOR.getValue() + exceptionCode.getMessage();
        if (!Strings.isNullOrEmpty(errorMessage)) {
            msg = msg + errorMessage;
        }
        return msg;
    }

}
