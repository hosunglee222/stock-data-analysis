package com.gachon.data_analysis.common.code;

import com.gachon.data_analysis.common.response.ResponseDto;

public interface BaseErrorCode {

    public ResponseDto.ErrorReasonDto getReason();

    public ResponseDto.ErrorReasonDto getReasonHttpStatus();
}

