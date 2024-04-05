package br.com.banco.core.domain;

import br.com.banco.core.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String password;
    private TaxNumber taxNumber;
    private String fullName;
    private UserTypeEnum type;
    private TrasactionPin trasactionPin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(UUID id, String email, String password, TaxNumber taxNumber, String fullName, UserTypeEnum type, TrasactionPin trasactionPin, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.trasactionPin = trasactionPin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(String email, String password, TaxNumber taxNumber, String fullName, UserTypeEnum type, TrasactionPin trasactionPin) {
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.trasactionPin = trasactionPin;
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public TrasactionPin getTrasactionPin() {
        return trasactionPin;
    }

    public void setTrasactionPin(TrasactionPin trasactionPin) {
        this.trasactionPin = trasactionPin;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!getId().equals(user.getId())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getTaxNumber().equals(user.getTaxNumber())) return false;
        if (!getFullName().equals(user.getFullName())) return false;
        if (getType() != user.getType()) return false;
        if (!getTrasactionPin().equals(user.getTrasactionPin())) return false;
        if (!getCreatedAt().equals(user.getCreatedAt())) return false;
        return getUpdatedAt() != null ? getUpdatedAt().equals(user.getUpdatedAt()) : user.getUpdatedAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getTaxNumber().hashCode();
        result = 31 * result + getFullName().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getTrasactionPin().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        return result;
    }
}
