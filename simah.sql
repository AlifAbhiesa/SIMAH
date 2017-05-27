-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2017 at 08:19 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `simah`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_adart`
--

CREATE TABLE IF NOT EXISTS `tbl_adart` (
  `kode_adart` varchar(10) NOT NULL,
  `pasal` varchar(20) NOT NULL,
  `uraian` varchar(1000) NOT NULL,
  `ayat` int(11) NOT NULL,
  PRIMARY KEY (`kode_adart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_adart`
--

INSERT INTO `tbl_adart` (`kode_adart`, `pasal`, `uraian`, `ayat`) VALUES
('AD 002', 'Pasal 1', 'DPenyalah gunaan hak dan kewajiban', 1),
('AD 003', 'Pasal 3', 'Keterlambatan tiga kali berturut turut akan menyebabkan denda sebesar 10.000', 2),
('AD/ART 004', 'Pasal 01', 'Anggota Aktif Akan diberi penghargaan', 1),
('AD/ART 005', 'Pasal 01', 'Anggota Pasif tidak akan disambut di acara wisuda', 2);

--
-- Triggers `tbl_adart`
--
DROP TRIGGER IF EXISTS `delete_adart`;
DELIMITER //
CREATE TRIGGER `delete_adart` BEFORE DELETE ON `tbl_adart`
 FOR EACH ROW BEGIN
delete from tbl_hukuman where kode_adart = old.kode_adart;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_anggota`
--

CREATE TABLE IF NOT EXISTS `tbl_anggota` (
  `nim` varchar(12) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_hp` varchar(13) NOT NULL,
  `email` varchar(30) NOT NULL,
  `angkatan` varchar(10) NOT NULL,
  `status` varchar(15) DEFAULT NULL,
  `id_jabatan` int(11) DEFAULT NULL,
  `id_sekolah` int(11) DEFAULT NULL,
  PRIMARY KEY (`nim`),
  KEY `FK_tbl_anggota_tbl_jabatan` (`id_jabatan`),
  KEY `FK_tbl_anggota_tbl_sekolah` (`id_sekolah`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_anggota`
--

INSERT INTO `tbl_anggota` (`nim`, `nama`, `alamat`, `no_hp`, `email`, `angkatan`, `status`, `id_jabatan`, `id_sekolah`) VALUES
('152015001', 'Ahmad Habibi', 'Jl. Walang Sungsang No 20', '023145679128', 'habibi@gmail.com', '2015-2016', 'Aktif', 5, 11),
('152015009', 'Nadia Vanessa', 'Jl. Cieumbeulit No 20', '0129127125', 'vanes@gmail.com', '2016-2017', 'Pasif Sekali', 8, 10),
('152015077', 'M. Alif Abhiesa Al Kautsar', 'Jl Bandung', '0898989898', 'abhiesa24@gmailcom', '2015-2016', 'Aktif', 5, 1),
('152015090', 'Julian', 'Jl. Plered no 20', '08121726125', 'jullian@gmail.com', '2016-2017', 'Pasif Sekali', 5, 1),
('1520152015', 'Alif', 'Jl Bandung', '0129120', 'alif@gmail.com', '2018-2019', 'Aktif', 5, 1),
('162015099', 'Sutirman', 'Jl. Pahlawan No. 24', '081224', 'timan@gmail.com', '2015-2016', 'Pasif', 7, 11),
('52015000', 'Kausar', 'Pabuaran', '01292197', 'kausar@gmail.com', '2015-2016', 'Pasif Sekali', 8, 13);

--
-- Triggers `tbl_anggota`
--
DROP TRIGGER IF EXISTS `Delete_Anggota`;
DELIMITER //
CREATE TRIGGER `Delete_Anggota` BEFORE DELETE ON `tbl_anggota`
 FOR EACH ROW BEGIN
delete from tbl_pelanggaran where nim = OLD.nim;
delete from tbl_prestasi where nim = OLD.nim;
delete from tbl_panitia where nim = OLD.nim;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hukuman`
--

CREATE TABLE IF NOT EXISTS `tbl_hukuman` (
  `id_hukuman` int(11) NOT NULL AUTO_INCREMENT,
  `kode_adart` varchar(10) DEFAULT NULL,
  `nama` varchar(50) NOT NULL,
  `uraian` varchar(500) NOT NULL,
  PRIMARY KEY (`id_hukuman`),
  KEY `FK_tbl_hukuman_tbl_adart` (`kode_adart`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `tbl_hukuman`
--

INSERT INTO `tbl_hukuman` (`id_hukuman`, `kode_adart`, `nama`, `uraian`) VALUES
(1, 'AD 003', 'Drop bro', 'Out'),
(8, 'AD 002', 'Hukuman Denda', 'Hukuman denda 200');

--
-- Triggers `tbl_hukuman`
--
DROP TRIGGER IF EXISTS `delete_hukuman`;
DELIMITER //
CREATE TRIGGER `delete_hukuman` BEFORE DELETE ON `tbl_hukuman`
 FOR EACH ROW BEGIN
delete from tbl_pelanggaran where id_hukuman = old.id_hukuman;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_jabatan`
--

CREATE TABLE IF NOT EXISTS `tbl_jabatan` (
  `id_jabatan` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(20) NOT NULL,
  `jobdesc` varchar(1000) NOT NULL,
  `periode` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id_jabatan`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `tbl_jabatan`
--

INSERT INTO `tbl_jabatan` (`id_jabatan`, `nama`, `jobdesc`, `periode`, `status`) VALUES
(5, 'Anggota Himpunan', 'Mengikuti setiap rapat rutin dan aktif perpartisipasi dalam setiapp kegiatan maupun proker', '2015-2016', 'Himpunan'),
(6, 'Ketua Pelaksana', 'Mengkoordinir setiap panitia untuk saling bekerjasama agar tercapainya hasil yang baik dalam acara', '2015-2016', 'Proker'),
(7, 'Ketua Himpunan', 'Membimbing dan mengkoordinir semua pengurus himpunan dan bertanggung jawab besar atas terlaksananya proker proker yang sudah direncanakan', '2015-2016', 'Himpunan'),
(8, 'Wakil Ketua Himpunan', 'Menggantikan ketua himpunan saat berhalangan hadir', '2015-2016', 'Himpunan'),
(9, 'Seksi Keamanan', 'Memastikan Kemanan acara', '2015-2016', 'Proker'),
(10, 'Seksi Kebersihan', 'Bertanggung jawab dan mengkoordinir setiap anggota untuk menjaga kebersihan tempat selama acara berlangsung', '2015-2016', 'Proker');

--
-- Triggers `tbl_jabatan`
--
DROP TRIGGER IF EXISTS `delete_jabatan`;
DELIMITER //
CREATE TRIGGER `delete_jabatan` BEFORE DELETE ON `tbl_jabatan`
 FOR EACH ROW BEGIN
update tbl_anggota set id_jabatan = null where id_jabatan = old.id_jabatan;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_kegiatan`
--

CREATE TABLE IF NOT EXISTS `tbl_kegiatan` (
  `id_kegiatan` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `uraian` varchar(500) DEFAULT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`id_kegiatan`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `tbl_kegiatan`
--

INSERT INTO `tbl_kegiatan` (`id_kegiatan`, `nama`, `uraian`, `tanggal`) VALUES
(6, 'HMGD Sport', 'Pertandingan Futsal Perwakilan HIMF', '2016-10-22'),
(7, 'Deisnatalis ITENAS', 'Lomba Sepeda Santaii', '2016-11-22'),
(8, 'Jalan Santai', 'Event Bank BRI jalan santaii', '2016-12-22');

--
-- Triggers `tbl_kegiatan`
--
DROP TRIGGER IF EXISTS `delete_kegiatan`;
DELIMITER //
CREATE TRIGGER `delete_kegiatan` BEFORE DELETE ON `tbl_kegiatan`
 FOR EACH ROW BEGIN
delete from tbl_prestasi where id_kegiatan = old.id_kegiatan;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE IF NOT EXISTS `tbl_login` (
  `username` varchar(12) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`username`, `password`, `status`) VALUES
('152015077', 'kausar', 'user'),
('152015090', 'julian', 'user'),
('162015099', 'timanubat', 'user'),
('admin', 'admin', 'admin'),
('alif', 'kausar', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_panitia`
--

CREATE TABLE IF NOT EXISTS `tbl_panitia` (
  `id_panitia` int(11) NOT NULL AUTO_INCREMENT,
  `nim` varchar(12) DEFAULT NULL,
  `id_proker` int(11) DEFAULT NULL,
  `id_jabatan` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_panitia`),
  KEY `FK_tbl_panatia_tbl_anggota` (`nim`),
  KEY `FK_tbl_panatia_tbl_jabatan` (`id_jabatan`),
  KEY `FK_tbl_panatia_tbl_proker` (`id_proker`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `tbl_panitia`
--

INSERT INTO `tbl_panitia` (`id_panitia`, `nim`, `id_proker`, `id_jabatan`) VALUES
(8, '152015077', 9, 9),
(9, '152015077', 10, 9),
(10, '152015077', 11, 6),
(11, '162015099', 9, 6),
(14, '152015001', 9, 9),
(15, '152015001', 10, 10),
(16, '152015001', 11, 6),
(17, '152015090', 9, 9);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pelanggaran`
--

CREATE TABLE IF NOT EXISTS `tbl_pelanggaran` (
  `id_pelanggaran` int(11) NOT NULL AUTO_INCREMENT,
  `id_hukuman` int(11) NOT NULL,
  `nim` varchar(12) NOT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`id_pelanggaran`),
  KEY `FK_tbl_pelanggaran_tbl_anggota` (`nim`),
  KEY `FK_tbl_pelanggaran_tbl_hukuman` (`id_hukuman`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `tbl_pelanggaran`
--

INSERT INTO `tbl_pelanggaran` (`id_pelanggaran`, `id_hukuman`, `nim`, `tanggal`) VALUES
(1, 8, '152015001', '2017-02-20'),
(2, 1, '152015001', '2017-02-20'),
(3, 8, '152015090', '2017-05-20'),
(4, 1, '152015090', '2017-04-03'),
(5, 8, '162015099', '2017-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_prestasi`
--

CREATE TABLE IF NOT EXISTS `tbl_prestasi` (
  `id_prestasi` int(11) NOT NULL AUTO_INCREMENT,
  `nim` varchar(12) NOT NULL,
  `id_kegiatan` int(11) NOT NULL,
  `uraian` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_prestasi`),
  KEY `FK_tbl_prestasi_tbl_anggota` (`nim`),
  KEY `FK_tbl_prestasi_tbl_kegiatan` (`id_kegiatan`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tbl_prestasi`
--

INSERT INTO `tbl_prestasi` (`id_prestasi`, `nim`, `id_kegiatan`, `uraian`) VALUES
(1, '152015090', 8, 'Jalannya paling santai'),
(2, '152015090', 7, 'Juara Lomba Lotre'),
(3, '152015077', 7, 'lomba masak'),
(4, '152015001', 7, 'Menang Lomba Lari');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_proker`
--

CREATE TABLE IF NOT EXISTS `tbl_proker` (
  `id_proker` int(11) NOT NULL AUTO_INCREMENT,
  `nama_proker` varchar(50) NOT NULL,
  `tujuan` varchar(500) NOT NULL,
  `tempat` varchar(50) DEFAULT NULL,
  `anggaran` int(8) DEFAULT NULL,
  `tanggal` date NOT NULL,
  `status` varchar(20) NOT NULL,
  `periode` varchar(10) NOT NULL,
  PRIMARY KEY (`id_proker`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `tbl_proker`
--

INSERT INTO `tbl_proker` (`id_proker`, `nama_proker`, `tujuan`, `tempat`, `anggaran`, `tanggal`, `status`, `periode`) VALUES
(9, 'Wisuda I', 'Menyambut wisudawan dan wisudawati di acara\nwisuda agustus dan menyelenggarakan\npenyematan dan perpisahan kepada wisudawan Jurusan\nTeknik Informatika', 'Gedung 2 ITENAS', 1000000, '2015-08-20', 'Sudah Terlaksana', '2015-2016'),
(10, 'Wisuda II', 'Menyambut wisudawan dan wisudawati di acara\nwisuda februari dan menyelenggarakan\npenyematan dan perpisahan kepada wisudawan Jurusan\nTeknik Informatika', 'Gedung 2 ITENAS', 1500000, '2016-02-12', 'Sudah Terlaksana', '2015-2016'),
(11, 'PKKM', 'Memberikan pengenalan himpunan\nkepada anggota baru sekaligus penyematan\nsebagai tanda diterimanya anggota baru dalam himpunan', 'Gedung 2 ITENAS', 3000000, '2016-03-20', 'Sudah Terlaksana', '2015-2016'),
(12, 'HMIF RAMADHAN', 'Menjalin hubungan dengan masyarakat dan mengadakan takjil bersama dengan anak yatim di panti asuhan', 'Panti Asuhan Garuda\nJl. Garuda no 23, Indonesia', 2000000, '2016-06-12', 'Belum Terlaksana', '2015-2016'),
(13, 'IF SPORT', 'HMIF mengadakan perlombaan dibidang olahraga untuk menjalin hubungan antara anggota dari berbagai kelas', 'Lapang Basket ITENAS, Student Center', 5000000, '2016-07-20', 'Belum Terlaksana', '2015-2016'),
(14, 'Musyawarah Besar', 'Memperbaiki AD/ART dan memusyawarahkan HIMF untuk lebih baik', 'Student Center Lt.2 ITENAS', 1000000, '2016-08-10', 'Belum Terlaksana', '2015-2016'),
(15, 'PKKM 2017', 'Penerimaan Anggota Baru', 'Student Center', 20000000, '2017-01-01', 'Sudah Terlaksana', '2016-2017');

--
-- Triggers `tbl_proker`
--
DROP TRIGGER IF EXISTS `delete_proker`;
DELIMITER //
CREATE TRIGGER `delete_proker` BEFORE DELETE ON `tbl_proker`
 FOR EACH ROW BEGIN
delete from tbl_panitia where id_proker = old.id_proker;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_sekolah`
--

CREATE TABLE IF NOT EXISTS `tbl_sekolah` (
  `id_sekolah` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `no_hp` varchar(13) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_sekolah`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `tbl_sekolah`
--

INSERT INTO `tbl_sekolah` (`id_sekolah`, `nama`, `alamat`, `no_hp`, `email`) VALUES
(1, 'SMK N 1 Lemahabang', 'Jl. Cirebon Pabuaran No.27', 'smkn1lemahaba', '089668848134'),
(2, 'SMA 1 Bandung', 'Jl, Cipto Mangun Kusumo No.24', 'smknbdg@gmail', '01212192'),
(10, 'SMA N 5 Bandung', 'Jl. Kh Wahid Hasim Bandung No 25', 'sman5bdg@gmai', '(0231) 8827182'),
(11, 'SMA Bina Husada', 'Jl. Bina Husada No 25', 'smabinu@gmail', '09128126'),
(12, 'SMA N 1 Lombok', 'Jl. Lombok No 20', 'lomboksma@gma', '08127621456'),
(13, 'MAN waled', 'Jl. Waled No 27	', 'waledman@gmai', '023145679'),
(14, 'SMA N 1 Pwk', 'Jl. Pwk Pelosok dalam', 'pwksma@gmail.', '123456');

--
-- Triggers `tbl_sekolah`
--
DROP TRIGGER IF EXISTS `delete_sekolah`;
DELIMITER //
CREATE TRIGGER `delete_sekolah` BEFORE DELETE ON `tbl_sekolah`
 FOR EACH ROW BEGIN
update tbl_anggota set id_sekolah = null where id_sekolah = old.id_sekolah;
END
//
DELIMITER ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_anggota`
--
ALTER TABLE `tbl_anggota`
  ADD CONSTRAINT `FK_tbl_anggota_tbl_jabatan` FOREIGN KEY (`id_jabatan`) REFERENCES `tbl_jabatan` (`id_jabatan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tbl_anggota_tbl_sekolah` FOREIGN KEY (`id_sekolah`) REFERENCES `tbl_sekolah` (`id_sekolah`) ON UPDATE CASCADE;

--
-- Constraints for table `tbl_hukuman`
--
ALTER TABLE `tbl_hukuman`
  ADD CONSTRAINT `FK_tbl_hukuman_tbl_adart` FOREIGN KEY (`kode_adart`) REFERENCES `tbl_adart` (`kode_adart`) ON UPDATE CASCADE;

--
-- Constraints for table `tbl_panitia`
--
ALTER TABLE `tbl_panitia`
  ADD CONSTRAINT `FK_tbl_panatia_tbl_anggota` FOREIGN KEY (`nim`) REFERENCES `tbl_anggota` (`nim`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tbl_panatia_tbl_jabatan` FOREIGN KEY (`id_jabatan`) REFERENCES `tbl_jabatan` (`id_jabatan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tbl_panatia_tbl_proker` FOREIGN KEY (`id_proker`) REFERENCES `tbl_proker` (`id_proker`) ON UPDATE CASCADE;

--
-- Constraints for table `tbl_pelanggaran`
--
ALTER TABLE `tbl_pelanggaran`
  ADD CONSTRAINT `FK_tbl_pelanggaran_tbl_anggota` FOREIGN KEY (`nim`) REFERENCES `tbl_anggota` (`nim`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tbl_pelanggaran_tbl_hukuman` FOREIGN KEY (`id_hukuman`) REFERENCES `tbl_hukuman` (`id_hukuman`) ON UPDATE CASCADE;

--
-- Constraints for table `tbl_prestasi`
--
ALTER TABLE `tbl_prestasi`
  ADD CONSTRAINT `FK_tbl_prestasi_tbl_anggota` FOREIGN KEY (`nim`) REFERENCES `tbl_anggota` (`nim`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tbl_prestasi_tbl_kegiatan` FOREIGN KEY (`id_kegiatan`) REFERENCES `tbl_kegiatan` (`id_kegiatan`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
