package com.fabrick.api.dto.shared;

import lombok.Data;

@Data
public class DtoDebtor {
    public DtoDebtor(String name, DtoAccount account) {
        this.name = name;
        this.account = account;
    }

    String name;

    DtoAccount account;
}
