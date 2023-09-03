package com.fabrick.api.dto.shared;

import lombok.Data;

@Data
public class DtoCreditor {
    public DtoCreditor(String name, DtoAccount account, DtoAddress address) {
        this.name = name;
        this.account = account;
        this.address = address;
    }

    String name;

    DtoAccount account;

    DtoAddress address;
}
