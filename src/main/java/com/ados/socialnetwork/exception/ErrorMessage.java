package com.ados.socialnetwork.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private Date timestamp;
    private String message;
    private String details;
}

