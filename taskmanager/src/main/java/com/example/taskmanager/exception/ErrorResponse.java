package com.example.taskmanager.exception;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;

    public ErrorResponse(int status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

}
