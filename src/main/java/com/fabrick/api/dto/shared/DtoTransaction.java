package com.fabrick.api.dto.shared;

import lombok.Data;

import java.util.Date;

@Data
public class DtoTransaction {
    public DtoTransaction(String transactionId, String operationId, Date accountingDate, Date valueDate, DtoType type, Number amount, String currency, String description) {
        this.transactionId = transactionId;
        this.operationId = operationId;
        this.accountingDate = accountingDate;
        this.valueDate = valueDate;
        this.type = type;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    String transactionId;

    String operationId;

    Date accountingDate;

    Date valueDate;

    DtoType type;

    Number amount;

    String currency;

    String description;
}
