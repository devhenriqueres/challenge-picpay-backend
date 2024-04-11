package br.com.banco.core.domain;

import br.com.banco.core.domain.enums.UserTypeEnum;
import br.com.banco.core.exception.TransferException;
import br.com.banco.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Wallet {
    private Long id; // id of the wallet
    private TransactionPin transactionPin;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(Long id, TransactionPin transactionPin, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.transactionPin = transactionPin;
    }

    public Wallet(TransactionPin transactionPin, BigDecimal balance, User user) {
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value){
        this.balance.add(value);
    }

    public void transfer(BigDecimal value) throws TransferException {

        if (this.user.getType() == UserTypeEnum.SHOPKEEPER){
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }
        if (this.balance.compareTo(value) < 0){
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }

        this.balance.subtract(value);
    }

    public void receiveTransfer(BigDecimal value) {
        this.balance.add(value);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wallet wallet)) return false;

        return getId().equals(wallet.getId()) && Objects.equals(getTransactionPin(), wallet.getTransactionPin()) && Objects.equals(getBalance(), wallet.getBalance()) && Objects.equals(getUser(), wallet.getUser()) && Objects.equals(getCreatedAt(), wallet.getCreatedAt()) && getUpdatedAt().equals(wallet.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + getTransactionPin().hashCode();
        result = 31 * result + getBalance().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }
}
