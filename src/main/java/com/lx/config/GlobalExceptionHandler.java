package com.lx.config;

import com.lx.model.RspBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

import static org.springframework.http.HttpStatus.NOT_EXTENDED;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 在controller里面内容执行之前，校验一些参数不匹配啊，Get post方法不对啊之类的
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("出错了", NOT_EXTENDED);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RspBase<String> jsonHandler(HttpServletRequest request, Exception e) throws Exception {
        logger.error("请求地址：" + request.getRequestURL(), e);
        RspBase<String> r = new RspBase<>();
        r.setMsg(e.getMessage()).setCode("0001");
        return r;
    }

    private void log(Exception ex, HttpServletRequest request) {
        logger.error("请求地址：" + request.getRequestURL(), ex);
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement().toString();
            logger.error(name + "---" + request.getParameter(name));
        }
    }

}
