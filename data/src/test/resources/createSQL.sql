
    create table PERSONNES (
        ID bigint not null,
        VERSION integer not null,
        NOM varchar(30) not null,
        PRENOM varchar(30) not null,
        TELEPHONE varchar(30),
        CIVILITE integer  not null,
        CREATED timestamp  not null,
        MODIFY timestamp,
        CONSTRAINT IDX_PERSONNES PRIMARY KEY (ID)
    );


    CREATE TABLE ADRESSES (
        ID bigint not null,
        VERSION integer not null,
	    ADR1 varchar(32) not null,
	    ADR2 varchar(32),
	    VILLE varchar(32) not null,
	    CP varchar(5) not null,
		CREATED timestamp   not null,
	    CONSTRAINT IDX_ADRESSES PRIMARY KEY (ID)
	);

	CREATE TABLE CIVILITES ( 
		ID integer NOT NULL, 
	    LIBELLE_COURT varchar(5) not null,
	    LIBELLE_LONG varchar(30) not null,
	    CONSTRAINT IDX_CIVILITES PRIMARY KEY (ID)
	);

	CREATE TABLE PERSONNE_ADRESSE ( 
		personneId integer NOT NULL, 
		adresseId integer NOT NULL, 
		PRIMARY KEY (personneId,adresseId)
	);
