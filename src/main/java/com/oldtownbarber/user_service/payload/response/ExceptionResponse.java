package com.oldtownbarber.user_service.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionResponse {

    private String message;

    private String error;

    private LocalDateTime timestamp;
}
