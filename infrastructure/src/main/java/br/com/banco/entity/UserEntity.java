package br.com.banco.entity;

import br.com.banco.core.domain.enums.UserTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Column(name = "Id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "TaxNumber", nullable = false)
    private String TaxNumber;

    @Column(name = "Fullame", nullable = false)
    private String fullname;

    @Column(name = "Type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserTypeEnum type;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdateAt", nullable = false)
    private LocalDateTime updatedAt;

}
