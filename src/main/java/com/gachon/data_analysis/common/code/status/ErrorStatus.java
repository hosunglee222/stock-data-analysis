package com.gachon.data_analysis.common.code.status;

import org.springframework.http.HttpStatus;

import com.gachon.data_analysis.common.code.BaseErrorCode;
import com.gachon.data_analysis.common.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    /**
     * Common Error & Global Error
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    METHOD_ARGUMENT_NOT_VALID(HttpStatus.BAD_REQUEST, "올바르지 않은 요청입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인증과정에서 오류가 발생하였습니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "금지된 요청입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않은 Http Method 입니다."),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러가 발생했습니다."),
    ;

    private final HttpStatus code;
    private final String message;

    public int getCode() {
        return code.value();
    }

    public HttpStatus getHttpStatus() {
        return code;
    }

    @Override
    public ResponseDto.ErrorReasonDto getReason() {
        return ResponseDto.ErrorReasonDto.builder()
                .isSuccess(false)
                .code(getCode())
                .message(message)
                .build();
    }

    @Override
    public ResponseDto.ErrorReasonDto getReasonHttpStatus() {
        return ResponseDto.ErrorReasonDto.builder()
                .status(this.code)
                .isSuccess(false)
                .code(getCode())
                .message(message)
                .build();
    }
}
