
    create table PERSONNES (
        ID bigint not null,
        VERSION integer not null,
        NOM varchar(30) not null,
        PRENOM varchar(30) not null,
        TELEPHONE varchar(30),
        CIVILITE varchar(10)  not null,
        CREATED timestamp  not null,
        CONSTRAINT IDX_PERSONNES PRIMARY KEY (ID)
    );

    CREATE TABLE ADRESSES (
	    ID integer identity primary key,
	    ADRESSE varchar(255),
	    VILLE varchar(50) not null,
	    CODE_POSTAL varchar(30) not null,
		CREATED timestamp,
	    CONSTRAINT IDX_ADRESSES PRIMARY KEY (ID)
	);

	CREATE TABLE PERSONNE_ADRESSE (
		personneId integer NOT NULL,
		adresseId integer NOT NULL,
		PRIMARY KEY (personneId,adresseId)
	);

	CREATE TABLE CIVILITES (
		ID integer NOT NULL,
	    LIBELLE_COURT varchar(5) not null,
	    LIBELLE_LONG varchar(30) not null,
	    CONSTRAINT IDX_CIVILITES PRIMARY KEY (ID)
	);


INSERT INTO PERSONNES ( ID, VERSION, NOM, PRENOM, CIVILITE, TELEPHONE, CREATED) VALUES (1, 1, 'MARTIN', 'Jules', 1, '00',now());
INSERT INTO PERSONNES ( ID, VERSION, NOM, PRENOM, CIVILITE, TELEPHONE, CREATED) VALUES (2, 1, 'GERMAN', 'Christine', 2, '00',now());
INSERT INTO PERSONNES ( ID, VERSION, NOM, PRENOM, CIVILITE, TELEPHONE, CREATED) VALUES (3, 1, 'JACQUARD', 'Jules', 1, '00',now());
INSERT INTO PERSONNES ( ID, VERSION, NOM, PRENOM, CIVILITE, TELEPHONE, CREATED) VALUES (4, 1, 'BISTROU', 'Brigitte', 3, '00',now());

COMMIT WORK;

INSERT INTO PERSONNE_ADRESSE (personneId, adresseId) values (1,1);
INSERT INTO PERSONNE_ADRESSE (personneId, adresseId) values (1,2);
INSERT INTO PERSONNE_ADRESSE (personneId, adresseId) values (2,1);
INSERT INTO PERSONNE_ADRESSE (personneId, adresseId) values (3,3);
INSERT INTO PERSONNE_ADRESSE (personneId, adresseId) values (4,2);

COMMIT WORK;

INSERT INTO ADRESSES ( ID, ADRESSE, VILLE, CODE_POSTAL, CREATED) VALUES (1, 'rue de la broche','Niort', '79000', now());
INSERT INTO ADRESSES ( ID, ADRESSE, VILLE, CODE_POSTAL, CREATED) VALUES (2, 'rue de la barre','Niort', '79001', now());
INSERT INTO ADRESSES ( ID, ADRESSE, VILLE, CODE_POSTAL, CREATED) VALUES (3, 'rue de la pioche','Niort', '79002', now());

COMMIT WORK;

INSERT INTO CIVILITES ( ID, LIBELLE_COURT, LIBELLE_LONG) VALUES (1, 'Mr.', 'Monsieur');
INSERT INTO CIVILITES ( ID, LIBELLE_COURT, LIBELLE_LONG) VALUES (2, 'Mme.', 'Madame');
INSERT INTO CIVILITES ( ID, LIBELLE_COURT, LIBELLE_LONG) VALUES (3, 'Mlle.', 'Mademoiselle');

COMMIT WORK;
