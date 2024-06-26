CREATE TABLE Wallets (
    Id BIGSERIAL PRIMARY KEY,
    Balance DECIMAL(10, 2) NOT NULL,
    UserId UUID NOT NULL UNIQUE,
    TransactionPinId BIGINT NOT NULL UNIQUE,
    CreatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdateAt TIMESTAMP,

    FOREIGN KEY (UserId) REFERENCES Users(Id),
    FOREIGN KEY (TransactionPinId) REFERENCES TransactionsPin(Id)
);
