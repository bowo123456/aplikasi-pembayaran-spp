/*
SQLyog Ultimate v10.42 
MySQL - 5.5.5-10.4.19-MariaDB : Database - pembayaran
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pembayaran` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `pembayaran`;

/*Table structure for table `tbl_kelas` */

DROP TABLE IF EXISTS `tbl_kelas`;

CREATE TABLE `tbl_kelas` (
  `id_kelas` int(20) NOT NULL,
  `jenis_kelas` int(5) DEFAULT NULL,
  `kelas` varchar(30) DEFAULT NULL,
  `tahun_ajaran` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_kelas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `tbl_kelas` */

insert  into `tbl_kelas`(`id_kelas`,`jenis_kelas`,`kelas`,`tahun_ajaran`) values (1,7,'7.9','2022/2023');

/*Table structure for table `tbl_pembagian_kelas` */

DROP TABLE IF EXISTS `tbl_pembagian_kelas`;

CREATE TABLE `tbl_pembagian_kelas` (
  `id_kelas` int(20) NOT NULL,
  `nis` int(20) DEFAULT NULL,
  `tahun_ajaran` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_kelas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `tbl_pembagian_kelas` */

/*Table structure for table `tbl_pembayaran` */

DROP TABLE IF EXISTS `tbl_pembayaran`;

CREATE TABLE `tbl_pembayaran` (
  `id_pembayaran` int(20) NOT NULL AUTO_INCREMENT,
  `nis` int(20) DEFAULT NULL,
  `id_kelas` int(12) DEFAULT NULL,
  `tanggal_pembayaran` varchar(200) DEFAULT NULL,
  `jenis_pembayaran` varchar(200) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pembayaran`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tbl_pembayaran` */

/*Table structure for table `tbl_siswa` */

DROP TABLE IF EXISTS `tbl_siswa`;

CREATE TABLE `tbl_siswa` (
  `nis` int(11) NOT NULL,
  `nisn` varchar(10) DEFAULT NULL,
  `nama_siswa` varchar(255) DEFAULT NULL,
  `jekel` varchar(12) DEFAULT NULL,
  `tempat` varchar(255) DEFAULT NULL,
  `tanggal_lahir` varchar(255) DEFAULT NULL,
  `agama` varchar(20) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `asal_sekolah` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `tbl_siswa` */

insert  into `tbl_siswa`(`nis`,`nisn`,`nama_siswa`,`jekel`,`tempat`,`tanggal_lahir`,`agama`,`alamat`,`asal_sekolah`) values (192007001,'999898982','Ryan D.P','Laki-laki','Bekasi','08 Juni 2022','Islam','Bekasi','SDN');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
