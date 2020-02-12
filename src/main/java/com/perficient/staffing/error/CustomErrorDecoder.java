//package com.perficient.staffing.error;
//
//import com.perficient.staffing.exception.NotFoundException;
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.catalina.connector.Response;
//import org.springframework.stereotype.Component;
//
//
//@Slf4j
//public class CustomErrorDecoder implements ErrorDecoder {
////
////
////    private final ErrorDecoder defaultErrorDecoder = new Default();
////
////    @Override
////    public Exception decode(String methodKey, Response response) {
////
////        log.debug("methodKey is " + methodKey);
////        log.debug(response.toString());
////        log.debug("status is " + response.status());
////
////        if (response.status() == 404) {
////            throw new NotFoundException(response.reason());
////        }
////
////        if (response.status() == 400) {
////            throw new IllegalArgumentException(response.reason());
////        }
////
////        if (response.status() != 200) {
////            throw new RuntimeException(response.reason());
////        }
////
////        return defaultErrorDecoder.decode(methodKey, response);
////    }
//}
//
