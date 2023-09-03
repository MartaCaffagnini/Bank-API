package com.fabrick.api.model.entities;

import javax.persistence.*;

@Entity(name = "transactions")
public class TransactionEntity {

    public TransactionEntity(Integer accountId, String status) {
        this.accountId = accountId;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer accountId;

    private String status;
}
