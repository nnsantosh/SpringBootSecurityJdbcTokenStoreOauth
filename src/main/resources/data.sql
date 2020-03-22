
CREATE TABLE if not exists auth_users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  active BOOLEAN NOT NULL,
  creation_date TIMESTAMP NOT NULL,
  last_updated_date TIMESTAMP NOT NULL
);
ALTER TABLE auth_users ADD CONSTRAINT USER_NAME_UNIQUE UNIQUE(user_name);

CREATE TABLE if not exists auth_roles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  role_name VARCHAR(250) NOT NULL,
  creation_date TIMESTAMP NOT NULL,
  last_updated_date TIMESTAMP NOT NULL
);
ALTER TABLE auth_roles ADD CONSTRAINT ROLE_NAME_UNIQUE UNIQUE(role_name);

CREATE TABLE if not exists auth_user_roles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  creation_date TIMESTAMP NOT NULL,
  last_updated_date TIMESTAMP NOT NULL,
  foreign key (user_id) references auth_users(id),
  foreign key (role_id) references auth_roles(id)
);

create table if not exists oauth_client_details (
    client_id varchar(256) primary key,
    resource_ids varchar(256),
    client_secret varchar(256),
    scope varchar(256),
    authorized_grant_types varchar(256),
    web_server_redirect_uri varchar(256),
    authorities varchar(256),
    access_token_validity integer,
    refresh_token_validity integer,
    additional_information varchar(4096),
    autoapprove varchar(256)
);

create table if not exists oauth_access_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication LONGVARBINARY,
  refresh_token VARCHAR(256)
);

create table if not exists oauth_refresh_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication LONGVARBINARY
);

--delete from oauth_client_details;

--INSERT INTO oauth_client_details (client_id,client_secret,resource_ids,scope,authorized_grant_types,access_token_validity,refresh_token_validity,web_server_redirect_uri) VALUES ('sampleClientId','$2a$10$auDwTW35Pdcs8.ni2OBImu3.q3VTgsp4s0cRCgCj9omLFFVMovxoO','resource_id','user_info','authorization_code,check_token,refresh_token,password',1000000,1000000,'http://localhost:8081/login');
