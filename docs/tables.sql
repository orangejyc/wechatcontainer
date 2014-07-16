CREATE TABLE user_info (
  user_id bigint  PRIMARY KEY AUTO_INCREMENT,
  username varchar(50) not null,
  password varchar(50),
  birth_date date,
  sex int,
  age int  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE role_info (
  id int  PRIMARY KEY AUTO_INCREMENT,
  name varchar(50) not null,
  info varchar(50),
  create_date date
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_role_info (
  id bigint  PRIMARY KEY AUTO_INCREMENT,
  user_id bigint not null,
  role_id int not null,
  create_date date
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE tenant_info (
  tenantid VARCHAR(38)  NOT NULL PRIMARY KEY ,
  tenantname VARCHAR(50) NOT NULL,
  wechatcode VARCHAR(50) NOT NULL,
  adminname  VARCHAR(50) NOT NULL,
  adminpwd VARCHAR(50) NOT NULL,
  baseurl VARCHAR(200) NOT NULL,
  token VARCHAR(50) NOT NULL,
  createdate  DATE,
  lastdate DATE,
  parentid VARCHAR(38)
) ENGINE=INNODB DEFAULT CHARSET=utf8;