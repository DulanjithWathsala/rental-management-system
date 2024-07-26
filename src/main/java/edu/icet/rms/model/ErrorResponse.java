package edu.icet.rms.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private String errorMessage;
    private String status;
}
