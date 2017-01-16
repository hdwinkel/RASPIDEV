--
-- File generated with SQLiteStudio v3.1.1 on Mo Jan 16 02:59:52 2017
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
                         1484442375692,
-                        1924527348,
                         1484430798700,
                         1484438775692,
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
    MessageID   INTEGER  PRIMARY KEY
                         NOT NULL,
    DisplayText TEXT     NOT NULL,
    Created     DATETIME NOT NULL
                         DEFAULT CURRENT_TIMESTAMP
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

INSERT INTO HelpRequest (
                            RequestID,
                            Name,
                            Type,
                            Count,
                            Created
                        )
                        VALUES (
-                           1824848968,
                            'button01',
                            'button',
                            1,
                            1484529640795
                        );

INSERT INTO HelpRequest (
                            RequestID,
                            Name,
                            Type,
                            Count,
                            Created
                        )
                        VALUES (
-                           206251765,
                            'button01',
                            'button',
                            1,
                            1484529396788
                        );

INSERT INTO HelpRequest (
                            RequestID,
                            Name,
                            Type,
                            Count,
                            Created
                        )
                        VALUES (
                            607291927,
                            'button01',
                            'button',
                            1,
                            1484531211023
                        );

INSERT INTO HelpRequest (
                            RequestID,
                            Name,
                            Type,
                            Count,
                            Created
                        )
                        VALUES (
                            737484769,
                            'button01',
                            'button',
                            1,
                            1484531636903
                        );

INSERT INTO HelpRequest (
                            RequestID,
                            Name,
                            Type,
                            Count,
                            Created
                        )
                        VALUES (
                            1002717126,
                            'button02',
                            'button',
                            1,
                            1484529269221
                        );

INSERT INTO HelpRequest (
                            RequestID,
                            Name,
                            Type,
                            Count,
                            Created
                        )
                        VALUES (
                            1504285641,
                            'button01',
                            'button',
                            1,
                            1484529953091
                        );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
