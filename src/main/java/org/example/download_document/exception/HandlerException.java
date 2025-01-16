package org.example.download_document.exception;

import org.example.download_document.constant.ErrorCodeDefs;
import org.example.download_document.dto.response.BaseResponseError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HandlerException {


    private static final Logger log = LoggerFactory.getLogger(HandlerException.class);

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponseError methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        BaseResponseError baseResponse = BaseResponseError.builder()
                .success(false)
                .error(processFielError(fieldErrors)).build();
        return baseResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public BaseResponseError httpMediaTypeNotAcceptableException(IllegalArgumentException ex) {
        log.error("Error " ,ex);
        return BaseResponseError.builder().success(false).error(
                BaseResponseError.Error.builder().code(500)
                        .message(ex.getMessage()).build()
        ).build();
    }



    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(AlertBadException.class)
    public BaseResponseError alertBadException(AlertBadException ex) {
        return BaseResponseError.builder().success(false).error(
                BaseResponseError.Error.builder().code(ErrorCodeDefs.ERR_BAD_REQUEST)
                        .message(ex.getMessage()).build()
        ).build();
    }


    private BaseResponseError.Error processFielError(List<FieldError> fieldErrors) {
        BaseResponseError.Error error = BaseResponseError.Error.builder().code(ErrorCodeDefs.ERR_VALIDATION)
                .message(ErrorCodeDefs.getMessage(ErrorCodeDefs.ERR_VALIDATION)).build();
        List<BaseResponseError.ErrorDetail> detailErrorList = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            BaseResponseError.ErrorDetail detailError = BaseResponseError.ErrorDetail.builder().message(fieldError.getDefaultMessage())
                    .id(fieldError.getField()).build();
            detailErrorList.add(detailError);
        }
        error.setErrorDetailList(detailErrorList);
        return error;
    }


}


