-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 12-Jun-2019 às 06:39
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.1.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `delegaciaprojeto`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `arma`
--

CREATE TABLE `arma` (
  `numeroArma` int(11) NOT NULL,
  `descricaoArma` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `arma`
--

INSERT INTO `arma` (`numeroArma`, `descricaoArma`) VALUES
(3838, 'Revolver');

-- --------------------------------------------------------

--
-- Estrutura da tabela `criminoso`
--

CREATE TABLE `criminoso` (
  `rgCriminoso` varchar(6) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `idade` int(11) NOT NULL,
  `Endereco_numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `criminoso`
--

INSERT INTO `criminoso` (`rgCriminoso`, `nome`, `idade`, `Endereco_numero`) VALUES
('808080', 'Carlim', 19, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `criminosovitima`
--

CREATE TABLE `criminosovitima` (
  `Vitima_rgVitima` varchar(10) NOT NULL,
  `Criminoso_rgCriminoso` varchar(6) NOT NULL,
  `tipoDoCrime` varchar(45) NOT NULL,
  `descricaoDoCrime` varchar(145) NOT NULL,
  `localCrime` varchar(45) NOT NULL,
  `dataCrime` varchar(45) NOT NULL,
  `Arma_numeroArma` int(11) NOT NULL,
  `Funcionario_rgFuncionario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `criminosovitima`
--

INSERT INTO `criminosovitima` (`Vitima_rgVitima`, `Criminoso_rgCriminoso`, `tipoDoCrime`, `descricaoDoCrime`, `localCrime`, `dataCrime`, `Arma_numeroArma`, `Funcionario_rgFuncionario`) VALUES
('202020', '808080', 'Homicidio', 'Criminoso Matou a Vitima, após reagir a assalto', 'Brasilia DF', '09/05/2015', 3838, 606060);

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `numero` int(11) NOT NULL,
  `rua` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`numero`, `rua`) VALUES
(0, 'Rua do Tio'),
(1, 'Rua V'),
(2, 'Dos  santos'),
(3, 'Dos anjos');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `rgFuncionario` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `Login_usuarios` int(11) NOT NULL,
  `Endereco_numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`rgFuncionario`, `nome`, `Login_usuarios`, `Endereco_numero`) VALUES
(606060, 'Wilson', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `usuarios` int(11) NOT NULL,
  `senha` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`usuarios`, `senha`) VALUES
(1, 123);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vitima`
--

CREATE TABLE `vitima` (
  `rgVitima` varchar(10) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `idade` int(11) NOT NULL,
  `Endereco_numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `vitima`
--

INSERT INTO `vitima` (`rgVitima`, `telefone`, `nome`, `idade`, `Endereco_numero`) VALUES
('202020', '11112222', 'Matheus', 20, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `arma`
--
ALTER TABLE `arma`
  ADD PRIMARY KEY (`numeroArma`);

--
-- Indexes for table `criminoso`
--
ALTER TABLE `criminoso`
  ADD PRIMARY KEY (`rgCriminoso`),
  ADD KEY `fk_Criminoso_Endereco1_idx` (`Endereco_numero`);

--
-- Indexes for table `criminosovitima`
--
ALTER TABLE `criminosovitima`
  ADD PRIMARY KEY (`Vitima_rgVitima`,`Criminoso_rgCriminoso`),
  ADD KEY `fk_Vitima_has_Criminoso_Criminoso1_idx` (`Criminoso_rgCriminoso`),
  ADD KEY `fk_Vitima_has_Criminoso_Vitima1_idx` (`Vitima_rgVitima`),
  ADD KEY `fk_CriminosoVitima_Arma1_idx` (`Arma_numeroArma`),
  ADD KEY `fk_CriminosoVitima_Funcionario1_idx` (`Funcionario_rgFuncionario`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`numero`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`rgFuncionario`),
  ADD KEY `fk_Funcionario_Login1_idx` (`Login_usuarios`),
  ADD KEY `fk_Funcionario_Endereco1_idx` (`Endereco_numero`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`usuarios`);

--
-- Indexes for table `vitima`
--
ALTER TABLE `vitima`
  ADD PRIMARY KEY (`rgVitima`),
  ADD KEY `fk_Vitima_Endereco1_idx` (`Endereco_numero`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `usuarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `criminoso`
--
ALTER TABLE `criminoso`
  ADD CONSTRAINT `fk_Criminoso_Endereco1` FOREIGN KEY (`Endereco_numero`) REFERENCES `endereco` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `criminosovitima`
--
ALTER TABLE `criminosovitima`
  ADD CONSTRAINT `fk_CriminosoVitima_Arma1` FOREIGN KEY (`Arma_numeroArma`) REFERENCES `arma` (`numeroArma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CriminosoVitima_Funcionario1` FOREIGN KEY (`Funcionario_rgFuncionario`) REFERENCES `funcionario` (`rgFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Vitima_has_Criminoso_Criminoso1` FOREIGN KEY (`Criminoso_rgCriminoso`) REFERENCES `criminoso` (`rgCriminoso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Vitima_has_Criminoso_Vitima1` FOREIGN KEY (`Vitima_rgVitima`) REFERENCES `vitima` (`rgVitima`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_Funcionario_Endereco1` FOREIGN KEY (`Endereco_numero`) REFERENCES `endereco` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Funcionario_Login1` FOREIGN KEY (`Login_usuarios`) REFERENCES `login` (`usuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `vitima`
--
ALTER TABLE `vitima`
  ADD CONSTRAINT `fk_Vitima_Endereco1` FOREIGN KEY (`Endereco_numero`) REFERENCES `endereco` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
