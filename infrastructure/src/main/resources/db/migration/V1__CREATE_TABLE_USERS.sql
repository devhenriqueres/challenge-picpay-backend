CREATE TABLE Users(
    Id UUID NOT NULL PRIMARY KEY,
    Email VARCHAR(70) NOT NULL UNIQUE,
    Password VARCHAR(50) NOT NULL,
    TaxNumber VARCHAR(15) NOT NULL UNIQUE,
    Fullame VARCHAR(70) NOT NULL,
    Type VARCHAR(30) NOT NULL,
    CreatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdateAt TIMESTAMP
);