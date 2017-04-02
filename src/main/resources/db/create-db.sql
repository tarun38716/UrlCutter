CREATE TABLE UC_ACCOUNT (
UCA_ACCOUNT_ID VARCHAR (20) NOT NULL,
UCA_PASSWORD VARCHAR (8) NOT NULL,
PRIMARY KEY (UCA_ACCOUNT_ID)
);

CREATE TABLE UC_URLS(
UCU_URL_ID INT NOT NULL IDENTITY(10000,1),
UCA_ACCOUNT_ID VARCHAR (20) NOT NULL,
UCU_SHORT_URL NVARCHAR NOT NULL,
UCU_LONG_URL NVARCHAR NOT NULL,
UCU_REDIRECT_TYPE INT NOT NULL,
UCU_COUNT BIGINT NULL,
PRIMARY KEY (UCU_URL_ID),
FOREIGN KEY (UCA_ACCOUNT_ID) REFERENCES UC_ACCOUNT(UCA_ACCOUNT_ID),
UNIQUE (UCA_ACCOUNT_ID,UCU_LONG_URL)
);




