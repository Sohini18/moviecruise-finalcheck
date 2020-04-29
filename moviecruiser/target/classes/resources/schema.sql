

CREATE TABLE IF NOT EXISTS 'moviecruise'.'movie' (
 `mo_id` INT NOT NULL AUTO_INCREMENT,
  `mo_title` VARCHAR(100) NULL,
  `mo_boxOffice` VARCHAR(100) NULL,
  `mo_active` VARCHAR(3) NULL,
  `mo_date_of_launch` DATE NULL,
  `mo_genre` VARCHAR(45) NULL,
  `mo_teaser` VARCHAR(3) NULL,
  PRIMARY KEY (`mo_id`))
ENGINE = InnoDB;