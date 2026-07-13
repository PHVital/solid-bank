CREATE TABLE checking_account (
    id INT PRIMARY KEY GENERATED,
    balance DOUBLE NOT NULL DEFAULT 0,
    account_holder VARCHAR(255) NOT NULL
);

CREATE TABLE transaction (
    id INT PRIMARY KEY GENERATED ,
    account_id INT NOT NULL,
    amount DOUBLE NOT NULL,
    date_time DATE NOT NULL,
    type VARCHAR(50) NOT NULL,

    CONSTRAINT fk_transaction_account
        FOREIGN KEY (account_id)
        REFERENCES checking_account(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_transaction_account
    ON transaction(account_id);