CREATE TABLE resource (
  resource_id int(11) NOT NULL AUTO_INCREMENT,
  resource_name varchar(45) NOT NULL unique,
  resource_type varchar(45) NOT NULL,
   availability varchar(45),
   create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   update_date TIMESTAMP DEFAULT NULL,
   is_deleted int(10) DEFAULT 0,
   PRIMARY KEY (resource_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;