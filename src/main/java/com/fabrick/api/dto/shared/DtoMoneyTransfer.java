package com.fabrick.api.dto.shared;

import lombok.Data;

import java.util.Date;

@Data
public class DtoMoneyTransfer {
    public DtoMoneyTransfer(String moneyTransferId, String status, String direction, DtoCreditor creditor, DtoDebtor debtor, String cro, String trn, String uri, String description, Date createdDatetime, Date accountedDatetime, Date debtorValueDate, Date creditorValueDate, DtoAmount amount, Boolean isUrgent, Boolean isInstant, String feeType, String feeAccountID, DtoFee[] fees, Boolean hasTaxRelief) {
        this.moneyTransferId = moneyTransferId;
        this.status = status;
        this.direction = direction;
        this.creditor = creditor;
        this.debtor = debtor;
        this.cro = cro;
        this.trn = trn;
        this.uri = uri;
        this.description = description;
        this.createdDatetime = createdDatetime;
        this.accountedDatetime = accountedDatetime;
        this.debtorValueDate = debtorValueDate;
        this.creditorValueDate = creditorValueDate;
        this.amount = amount;
        this.isUrgent = isUrgent;
        this.isInstant = isInstant;
        this.feeType = feeType;
        this.feeAccountID = feeAccountID;
        this.fees = fees;
        this.hasTaxRelief = hasTaxRelief;
    }

    String moneyTransferId;

    String status;

    String direction;

    DtoCreditor creditor;

    DtoDebtor debtor;

    String cro;

    String trn;

    String uri;

    String description;

    Date createdDatetime;

    Date accountedDatetime;

    Date debtorValueDate;

    Date creditorValueDate;

    DtoAmount amount;

    Boolean isUrgent;

    Boolean isInstant;

    String feeType;

    String feeAccountID;

    DtoFee[] fees;

    Boolean hasTaxRelief;
}