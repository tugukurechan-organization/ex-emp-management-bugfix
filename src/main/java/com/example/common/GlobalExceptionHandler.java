package com.example.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 例外をキャッチしてエラー画面に遷移する.
 *
 * @author takeru.chugun
 */
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /*
     * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    @Override
    public ModelAndView resolveException(
            HttpServletRequest request,
            HttpServletResponse response,
            Object obj,
            Exception e) {
        LOGGER.error("エラーが発生しました！", e);
        return null;
    }
}