create schema livraria;
use livraria;

CREATE TABLE IF NOT EXISTS `livraria`.`clientes` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(14) ,
  `cnpj` VARCHAR(18) ,
  `endereco` VARCHAR(60) ,
  `telefone` VARCHAR(14) ,
  PRIMARY KEY (`idcliente`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC)  )
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `livraria`.`editoras` (
  `ideditora` INT NOT NULL AUTO_INCREMENT,
  `nomeEditora` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NULL,
  `gerente` VARCHAR(45) NULL,
  PRIMARY KEY (`ideditora`),
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC)  ))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `livraria`.`pedidos` (
  `idpedido` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `idcliente` INT NOT NULL,
  `subTotal` float,
  PRIMARY KEY (`idpedido`),
  INDEX `fk_pedidos_clientes1_idx` (`idcliente` ASC) ,
  CONSTRAINT `fk_pedidos_clientes1`
    FOREIGN KEY (`idcliente`)
    REFERENCES `livraria`.`clientes` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `livraria`.`livros` (
  `idlivro` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `assunto` VARCHAR(45) NOT NULL,
  `isbn` VARCHAR(45) NOT NULL,
  `estoque` INT NOT NULL,
  `preco` float,
  `ideditora` INT NOT NULL,
  PRIMARY KEY (`idlivro`),
  UNIQUE INDEX `isbn_UNIQUE` (`isbn` ASC) ,
  INDEX `fk_livros_editoras1_idx` (`ideditora` ASC) ,
  CONSTRAINT `fk_livros_editoras1`
    FOREIGN KEY (`ideditora`)
    REFERENCES `livraria`.`editoras` (`ideditora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `livraria`.`pedidosLivros` (
  `idpedido` INT NOT NULL,
  `idlivro` INT NOT NULL,
  INDEX `fk_pedidos_has_livros_livros1_idx` (`idlivro` ASC) ,
  INDEX `fk_pedidos_has_livros_pedidos1_idx` (`idpedido` ASC) ,
  CONSTRAINT `fk_pedidos_has_livros_pedidos1`
    FOREIGN KEY (`idpedido`)
    REFERENCES `livraria`.`pedidos` (`idpedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedidos_has_livros_livros1`
    FOREIGN KEY (`idlivro`)
    REFERENCES `livraria`.`livros` (`idlivro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;