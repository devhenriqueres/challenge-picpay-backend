package br.com.banco.entity;

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
@Table(name = "Wallets")
public class WalletEntity {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Balance", nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "UserId")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "TransactionPinId")
    private TransactionPinEntity transactionPinEntity;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdateAt", nullable = false)
    private LocalDateTime updatedAt;


}
