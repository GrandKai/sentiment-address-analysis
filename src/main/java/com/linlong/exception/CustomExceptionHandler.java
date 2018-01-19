package com.linlong.exception;

import com.linlong.core.bean.ResponseModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseModel handler() {
        return ResponseModel.builder().code(-1).message("系统异常").build();
    }

    @ExceptionHandler(value = CustomException.class)
    public ResponseModel handlerCustomException(CustomException custom) {
        return ResponseModel.builder().code(custom.getCode()).message(custom.getMessage()).build();
    }
}
