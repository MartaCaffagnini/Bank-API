package com.fabrick.api.model.repositories;

import com.fabrick.api.model.entities.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepository extends CrudRepository<TransactionEntity, String> {
}
