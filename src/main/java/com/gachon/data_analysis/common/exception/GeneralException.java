package com.gachon.data_analysis.common.exception;


import com.gachon.data_analysis.common.code.BaseErrorCode;
import com.gachon.data_analysis.common.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private final BaseErrorCode code;

    public ResponseDto.ErrorReasonDto getErrorReason() {
        return this.code.getReason();
    }

    public ResponseDto.ErrorReasonDto getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
