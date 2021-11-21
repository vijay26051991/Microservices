CREATE TABLE `parkinglot`.`users`
(
    `id`       INT          NOT NULL,
    `username` VARCHAR(45)  NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `email`    VARCHAR(45) NULL,
    `phone`    VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE
);
