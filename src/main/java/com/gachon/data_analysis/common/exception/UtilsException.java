package com.gachon.data_analysis.common.exception;

import com.gachon.data_analysis.common.code.BaseErrorCode;

public class UtilsException extends GeneralException {
    public UtilsException(BaseErrorCode code) {
        super(code);
    }
}
