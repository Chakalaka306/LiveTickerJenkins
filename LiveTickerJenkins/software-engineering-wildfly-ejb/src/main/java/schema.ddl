
    create table Event (
        id integer not null,
        primary key (id)
    );

    create table Game (
        id integer not null,
        Team1 varchar(255) not null,
        Team2 varchar(255) not null,
        anstoﬂ datetime not null,
        event tinyblob not null,
        tore1 integer,
        tore2 integer,
        primary key (id)
    );

    create table LiveTickerSession (
        id integer not null auto_increment,
        creationTime datetime,
        user_id integer,
        primary key (id)
    );

    create table User (
        id integer not null,
        email varchar(255) not null,
        password varchar(255),
        userName varchar(255) not null,
        primary key (id)
    );

    alter table Game 
        add constraint UK_81nbs7kq6cxqpoeyycgcwgbb8  unique (Team2);

    alter table User 
        add constraint UK_e6gkqunxajvyxl5uctpl2vl2p  unique (email);

    alter table LiveTickerSession 
        add constraint FK_lrangejq8ki47xhpdfark1w5j 
        foreign key (user_id) 
        references User (id);
