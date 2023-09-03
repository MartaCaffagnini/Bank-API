package com.fabrick.api.dto.requests;

import com.fabrick.api.dto.shared.DtoCreditor;
import com.fabrick.api.dto.shared.DtoTaxRelief;
import lombok.Data;

@Data
public class DtoMoneyTransferFabrickRequest {

    DtoCreditor creditor;

    String executionDate;

    String uri;

    String description;

    Number amount;

    String currency;

    Boolean isUrgent;

    Boolean isInstant;

    String feeType;

    String feeAccountId;

    DtoTaxRelief taxRelief;
}