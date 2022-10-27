package com.ZenPack.exception;


import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private HttpStatus status;
    private String message;
}