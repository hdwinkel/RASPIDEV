--
-- File generated with SQLiteStudio v3.1.1 on So Jan 29 23:25:44 2017
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: CoWorker
DROP TABLE IF EXISTS CoWorker;

CREATE TABLE CoWorker (
    DeviceID     TEXT     PRIMARY KEY
                          NOT NULL,
    Name         TEXT     NOT NULL,
    BreakEndTime DATETIME,
    RequestID    INTEGER,
    Created      DATETIME NOT NULL
                          DEFAULT CURRENT_TIMESTAMP,
    Updated      DATETIME NOT NULL
                          DEFAULT CURRENT_TIMESTAMP,
    EMail        TEXT
);

INSERT INTO CoWorker (
                         DeviceID,
                         Name,
                         BreakEndTime,
                         RequestID,
                         Created,
                         Updated,
                         EMail
                     )
                     VALUES (
                         'deviceid01',
                         'Detlef Winkelvoss',
                         1484682827696,
-                        1924527348,
                         1484430798700,
                         1484682527696,
                         'winkel@egladil.de'
                     );

INSERT INTO CoWorker (
                         DeviceID,
                         Name,
                         BreakEndTime,
                         RequestID,
                         Created,
                         Updated,
                         EMail
                     )
                     VALUES (
                         'deviceid02',
                         'Det Winkelvoss',
                         1484430866219,
-                        1102808392,
                         1484430866219,
                         1484430866219,
                         'winkel@egladil.de'
                     );


-- Table: DisplayMessage
DROP TABLE IF EXISTS DisplayMessage;

CREATE TABLE DisplayMessage (
    MessageID    INTEGER  PRIMARY KEY
                          NOT NULL,
    DisplayText1 TEXT     NOT NULL,
    DisplayText2 TEXT     NOT NULL,
    Created      DATETIME NOT NULL
                          DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO DisplayMessage (
                               MessageID,
                               DisplayText1,
                               DisplayText2,
                               Created
                           )
                           VALUES (
                               851036537,
                               'Press Button',
                               'for Help Please!',
                               1485728485455
                           );


-- Table: HelpRequest
DROP TABLE IF EXISTS HelpRequest;

CREATE TABLE HelpRequest (
    RequestID INTEGER  PRIMARY KEY
                       NOT NULL,
    Name      STRING   NOT NULL,
    Type      TEXT     NOT NULL,
    Count     INTEGER  NOT NULL,
    Created   DATETIME NOT NULL
                       DEFAULT CURRENT_TIMESTAMP
);


-- Table: Manned
DROP TABLE IF EXISTS Manned;

CREATE TABLE Manned (
    ID                PRIMARY KEY
                      NOT NULL,
    IsManned INTEGER  NOT NULL,
    Updated  DATETIME NOT NULL
);

INSERT INTO Manned (
                       ID,
                       IsManned,
                       Updated
                   )
                   VALUES (
                       1,
                       0,
                       1485728485446
                   );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
