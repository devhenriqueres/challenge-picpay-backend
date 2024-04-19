package br.com.banco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TransactionsPin")
public class TransactionPinEntity {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Pin", nullable = false)
    private String pin;

    @Column(name = "Attempt", nullable = false)
    private int attempt;

    @Column(name = "Blocked", nullable = false)
    private Boolean blocked;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdateAt", nullable = false)
    private LocalDateTime updatedAt;


}
