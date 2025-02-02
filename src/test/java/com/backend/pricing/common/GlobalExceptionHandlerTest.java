package com.backend.pricing.common;

import com.backend.pricing.common.exception.ConflictException;
import com.backend.pricing.common.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @InjectMocks
    GlobalExceptionHandler globalExceptionHandler;

    @Test
    void notFoundExceptionTest() {
        NotFoundException exception = mock(NotFoundException.class);
        WebRequest request = mock(WebRequest.class);
        assertNotNull(globalExceptionHandler.handleException(exception, request));
    }

    @Test
    void conflictExceptionTest() {
        ConflictException exception = mock(ConflictException.class);
        WebRequest request = mock(WebRequest.class);
        assertNotNull(globalExceptionHandler.handleException(exception, request));
    }

    @Test
    void methodArgumentNotValidExceptionTest() {
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        WebRequest request = mock(WebRequest.class);
        assertNotNull(globalExceptionHandler.handleException(exception, request));
    }

    @Test
    void httpMessageNotReadableExceptionTest() {
        HttpMessageNotReadableException exception = mock(HttpMessageNotReadableException.class);
        WebRequest request = mock(WebRequest.class);
        assertNotNull(globalExceptionHandler.handleException(exception, request));
    }

    @Test
    void handleExceptionTest() {
        MissingServletRequestParameterException exception = mock(MissingServletRequestParameterException.class);
        WebRequest request = mock(WebRequest.class);
        assertNotNull(globalExceptionHandler.handleException(exception, request));
    }

}