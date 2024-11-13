package com.gachon.data_analysis.common.code;

import com.gachon.data_analysis.common.response.ResponseDto;

public interface BaseCode {

    public ResponseDto.ReasonDto getReason();

    public ResponseDto.ReasonDto getReasonHttpStatus();
}
