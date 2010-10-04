DROP TABLE IF EXISTS PERSONNES;

create table PERSONNES (
    ID bigint GENERATED ALWAYS AS IDENTITY,
    VERSION integer not null,
    NOM varchar(30) not null,
    PRENOM varchar(30) not null,
    TELEPHONE varchar(30),
    CIVILITE integer  not null,
    ADR1 varchar(32) not null,
    ADR2 varchar(32),
    VILLE varchar(32) not null,
    CP varchar(5) not null,
    CREATED timestamp  not null,
    MODIFIED timestamp,
    CONSTRAINT IDX_PERSONNES PRIMARY KEY (ID)
);

INSERT INTO PERSONNES (VERSION, NOM, PRENOM, CIVILITE, TELEPHONE, ADR1, ADR2, VILLE, CP, CREATED, MODIFIED) VALUES (1, 'MARTIN', 'Jules', 1, '00', 'rue de la broche', null, 'Niort', '79000',now(),null);
INSERT INTO PERSONNES (VERSION, NOM, PRENOM, CIVILITE, TELEPHONE, ADR1, ADR2, VILLE, CP, CREATED, MODIFIED) VALUES (2, 'GERMAN', 'Christine', 3, '00', 'rue de la bèche', null, 'Niort', '79000',now(),now());
INSERT INTO PERSONNES (VERSION, NOM, PRENOM, CIVILITE, TELEPHONE, ADR1, ADR2, VILLE, CP, CREATED, MODIFIED) VALUES (1, 'JACQUARD', 'Jules', 1, '00', 'rue de la pelle', null, 'Niort', '79000',now(),null);
INSERT INTO PERSONNES (VERSION, NOM, PRENOM, CIVILITE, TELEPHONE, ADR1, ADR2, VILLE, CP, CREATED, MODIFIED) VALUES (1, 'MARTIN', 'Brigitte', 2, '00', 'rue de la broche', null, 'Niort', '79000',now(),null);