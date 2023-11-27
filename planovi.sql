/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.21-MariaDB : Database - planoviproba
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`planoviproba` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `planoviproba`;

/*Table structure for table `aktivnost` */

DROP TABLE IF EXISTS `aktivnost`;

CREATE TABLE `aktivnost` (
  `AktivnostID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivAktivnosti` varchar(30) NOT NULL,
  `OpisAktivnosti` varchar(30) NOT NULL,
  `TipAktivnostiID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`AktivnostID`),
  KEY `fk_tipAktivnosti_id` (`TipAktivnostiID`),
  CONSTRAINT `fk_tipAktivnosti_id` FOREIGN KEY (`TipAktivnostiID`) REFERENCES `tipaktivnosti` (`TipAktivnostiID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `aktivnost` */

insert  into `aktivnost`(`AktivnostID`,`NazivAktivnosti`,`OpisAktivnosti`,`TipAktivnostiID`) values 
(1,'Masaza','Sportska masaza.',1),
(2,'Trening','Trening u obliznjoj teretani.',2),
(3,'Slusanje seminara','Slusanje i zapisivanje beleski',3);

/*Table structure for table `beleska` */

DROP TABLE IF EXISTS `beleska`;

CREATE TABLE `beleska` (
  `BeleskaID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naslov` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Sadrzaj` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `KorisnikID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`BeleskaID`),
  KEY `f_korisnik` (`KorisnikID`),
  CONSTRAINT `f_korisnik` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `beleska` */

insert  into `beleska`(`BeleskaID`,`Naslov`,`Sadrzaj`,`KorisnikID`) values 
(6,'Nabavka','hleb, jaja, mleko',1),
(7,'Diplomski rad','prijava teme \nizrada rada \nodbrana rada \nizdavanje diplome ',1),
(8,'Napredno programiranje projekat','tema \n8 domenskih klasa \n10 sistemskih operacija \nverzioniranje, grane, git \nmaven \ntestiranje (JUnit) \ndokumentovanje (Javadoc) \njson',1);

/*Table structure for table `cilj` */

DROP TABLE IF EXISTS `cilj`;

CREATE TABLE `cilj` (
  `CiljID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivCilja` varchar(30) NOT NULL,
  `OpisCilja` varchar(200) NOT NULL,
  `KategorijaID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`CiljID`),
  KEY `fk_kategorija` (`KategorijaID`),
  CONSTRAINT `fk_kategorija` FOREIGN KEY (`KategorijaID`) REFERENCES `kategorijacilja` (`KategorijaID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4;

/*Data for the table `cilj` */

insert  into `cilj`(`CiljID`,`NazivCilja`,`OpisCilja`,`KategorijaID`) values 
(1,'Licni razvoj','Treninzi, knjige, edukacija',1),
(4,'Poloziti softvere','Mora da se ostvari u julu!',4),
(5,'Pilates treninzi','Snimci sa YouTube-a (Move with Nicole)',2);

/*Table structure for table `dnevnaaktivnost` */

DROP TABLE IF EXISTS `dnevnaaktivnost`;

CREATE TABLE `dnevnaaktivnost` (
  `NedeljniPlanID` bigint(10) unsigned NOT NULL,
  `Rb` int(7) NOT NULL,
  `DatumAktivnosti` date NOT NULL,
  `Beleske` varchar(200) NOT NULL,
  `AktivnostID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`NedeljniPlanID`,`Rb`),
  KEY `fk_aktivnost_id` (`AktivnostID`),
  CONSTRAINT `fk_aktivnost_id` FOREIGN KEY (`AktivnostID`) REFERENCES `aktivnost` (`AktivnostID`),
  CONSTRAINT `fk_nedeljniPlan_id` FOREIGN KEY (`NedeljniPlanID`) REFERENCES `nedeljniplan` (`NedeljniPlanID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `dnevnaaktivnost` */

insert  into `dnevnaaktivnost`(`NedeljniPlanID`,`Rb`,`DatumAktivnosti`,`Beleske`,`AktivnostID`) values 
(1,1,'2023-08-21','Odmor.',1),
(1,2,'2023-08-21','Noge i kardio.',2),
(1,3,'2023-08-21','Odlsusaj 2h materijala.',3),
(1,4,'2023-08-22','Odmor.',1),
(1,5,'2023-08-22','Trcanje 8km.',2),
(1,6,'2023-08-22','Odlsusaj 2h materijala.',3),
(3,1,'2023-11-20','Neke beleske.',1),
(3,2,'2023-11-20','Neke beleske.',1),
(3,3,'2023-11-20','Neke beleske.',1),
(3,4,'2023-11-20','Neke beleske.',1),
(3,5,'2023-11-20','Neke beleske.',1),
(3,6,'2023-11-20','Neke beleske.',1),
(3,7,'2023-11-20','Neke beleske.',1);

/*Table structure for table `kategorijacilja` */

DROP TABLE IF EXISTS `kategorijacilja`;

CREATE TABLE `kategorijacilja` (
  `KategorijaID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivKategorije` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`KategorijaID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `kategorijacilja` */

insert  into `kategorijacilja`(`KategorijaID`,`NazivKategorije`) values 
(1,'Licni razvoj'),
(2,'Fitnes'),
(3,'Ishrana'),
(4,'Studije'),
(5,'Posao');

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `KorisnikID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(30) NOT NULL,
  `Prezime` varchar(30) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  PRIMARY KEY (`KorisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `korisnik` */

insert  into `korisnik`(`KorisnikID`,`Ime`,`Prezime`,`Username`,`Password`) values 
(1,'Ana','Adamovic','ana','ana123'),
(2,'Jovan','Vitosevic','jovan','jovan123');

/*Table structure for table `nedeljniplan` */

DROP TABLE IF EXISTS `nedeljniplan`;

CREATE TABLE `nedeljniplan` (
  `NedeljniPlanID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `DatumOd` date NOT NULL,
  `DatumDo` date NOT NULL,
  `CiljID` bigint(10) unsigned NOT NULL,
  `KorisnikID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`NedeljniPlanID`),
  KEY `fk_cilj_id` (`CiljID`),
  KEY `fk_korisnik_id` (`KorisnikID`),
  CONSTRAINT `fk_cilj_id` FOREIGN KEY (`CiljID`) REFERENCES `cilj` (`CiljID`),
  CONSTRAINT `fk_korisnik_id` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `nedeljniplan` */

insert  into `nedeljniplan`(`NedeljniPlanID`,`DatumOd`,`DatumDo`,`CiljID`,`KorisnikID`) values 
(1,'2023-08-21','2023-08-27',1,1),
(3,'2023-11-20','2023-11-26',4,1);

/*Table structure for table `tipaktivnosti` */

DROP TABLE IF EXISTS `tipaktivnosti`;

CREATE TABLE `tipaktivnosti` (
  `TipAktivnostiID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivTipaAktivnosti` varchar(30) NOT NULL,
  PRIMARY KEY (`TipAktivnostiID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tipaktivnosti` */

insert  into `tipaktivnosti`(`TipAktivnostiID`,`NazivTipaAktivnosti`) values 
(1,'Opustajuca'),
(2,'Fizicka'),
(3,'Mentalna');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
