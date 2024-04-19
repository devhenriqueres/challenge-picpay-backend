package br.com.banco.repository;

import br.com.banco.entity.TransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionsEntity, Long> {
}
