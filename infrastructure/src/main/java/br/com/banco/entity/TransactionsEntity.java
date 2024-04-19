package br.com.banco.entity;

import br.com.banco.core.domain.enums.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Transactions")
public class TransactionsEntity {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FromWallet")
    private WalletEntity fromWalletEntity;

    @ManyToOne
    @JoinColumn(name = "ToWallet")
    private WalletEntity toWalletEntity;

    @Column(name = "TransactionValue", nullable = false)
    private BigDecimal transactionValue;

    @Column(name = "Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdateAt", nullable = false)
    private LocalDateTime updatedAt;


}
