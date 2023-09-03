package com.fabrick.api.dto.responses;

import com.fabrick.api.dto.shared.DtoAccountBalance;
import com.fabrick.api.dto.shared.DtoError;
import lombok.Data;

@Data
public class DtoAccountBalanceFabrickResponse {
    String status;

    DtoError[] errors;

    DtoAccountBalance payload;

    public DtoAccountBalanceFabrickResponse(String status, DtoError[] errors, DtoAccountBalance payload) {
        this.status = status;
        this.errors = errors;
        this.payload = payload;
    }
}
