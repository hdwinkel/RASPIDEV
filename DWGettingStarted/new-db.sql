--
-- File generated with SQLiteStudio v3.1.1 on Mi Jan 11 19:20:21 2017
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: CoWorker
DROP TABLE IF EXISTS CoWorker;

CREATE TABLE CoWorker (
    DeviceID        TEXT     PRIMARY KEY
                             NOT NULL,
    Name            TEXT     NOT NULL,
    BreakEndTime    DATETIME,
    RequestID       INTEGER,
    RequestAccepted BOOLEAN,
    Created         DATETIME NOT NULL
                             DEFAULT CURRENT_TIMESTAMP,
    Updated         DATETIME NOT NULL
                             DEFAULT CURRENT_TIMESTAMP,
    EMail           TEXT
);


-- Table: DisplayMessage
DROP TABLE IF EXISTS DisplayMessage;

CREATE TABLE DisplayMessage (
    MessageID   INTEGER  PRIMARY KEY
                         NOT NULL,
    DisplayText TEXT     NOT NULL,
    Created     DATETIME NOT NULL
                         DEFAULT CURRENT_TIMESTAMP
);


-- Table: HelpRequest
DROP TABLE IF EXISTS HelpRequest;

CREATE TABLE HelpRequest (
    RequestID   INTEGER  PRIMARY KEY
                         NOT NULL,
    RequestType TEXT     NOT NULL,
    Created     DATETIME NOT NULL
                         DEFAULT CURRENT_TIMESTAMP,
    Count       INTEGER
);

INSERT INTO HelpRequest (
                            RequestID,
                            RequestType,
                            Created,
                            Count
                        )
                        VALUES (
-                           1670126213,
                            'button',
                            1484157522349,
                            1
                        );

INSERT INTO HelpRequest (
                            RequestID,
                            RequestType,
                            Created,
                            Count
                        )
                        VALUES (
                            1275651377,
                            'button',
                            1484157664182,
                            1
                        );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
