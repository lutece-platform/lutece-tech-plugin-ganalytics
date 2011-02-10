--
-- Structure for table ganalytics
--

DROP TABLE IF EXISTS ganalytics_code;
CREATE TABLE ganalytics_code (
  ganalytics_code varchar(255) DEFAULT 'UA-XXXXXXXX',
 
  PRIMARY KEY (ganalytics_code)
);

