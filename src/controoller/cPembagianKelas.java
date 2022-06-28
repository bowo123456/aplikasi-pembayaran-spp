/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controoller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.koneksiMysql;
import model.mKelas;
import model.mPembagianKelas;

/**
 *
 * @author Tri Wibowo
 */
public class cPembagianKelas extends mPembagianKelas{
    public DefaultTableModel liat_data() {
        try {
            koneksiMysql con = new koneksiMysql();
            Statement Stm = con.connect();
            ResultSet rs = Stm.executeQuery(
               "SELECT \n" +
                    "tk.`id_kelas`,\n" +
                    "tk.`nis`,\n" +
                    "ts.`nisn`,\n" +
                    "ts.`nama_siswa`,\n" +
                    "ts.`jekel`,\n" +
                    "tk2.`jenis_kelas`,\n" +
                    "tk2.`kelas`,\n" +
                    "tk.`tahun_ajaran`\n" +
                    "FROM tbl_pembagian_kelas AS tk\n" +
                    "INNER JOIN tbl_siswa ts\n" +
                    "ON tk.`nis` = ts.`nis`	\n" +
                    "INNER JOIN tbl_kelas tk2\n" +
                    "ON tk.`id_kelas` = tk2.`id_kelas` ");
          
            DefaultTableModel mdlSiswa = new DefaultTableModel();
            mdlSiswa.addColumn("No");
            mdlSiswa.addColumn("Kode Kelas");
            mdlSiswa.addColumn("NIS");
            mdlSiswa.addColumn("NISN");            
            mdlSiswa.addColumn("Nama");
            mdlSiswa.addColumn("Jenis Kelamin");
            mdlSiswa.addColumn("Jenis Kelas");
            mdlSiswa.addColumn("Kelas ");
            mdlSiswa.addColumn("Tahun Ajaran");
            
            

            Object[] os;
            int no = 0;
            while (rs.next()) {
                os = new Object[10];
                no++;
                os[0] = String.valueOf(no).toString();
                os[1] = rs.getInt("id_kelas");
                os[2] = rs.getInt("nis");
                os[3] = rs.getString("nisn");            
                os[4] = rs.getString("nama_siswa");
                os[5] = rs.getString("jekel");             
                os[6] = rs.getInt("jenis_kelas");
                os[7] = rs.getString("kelas");
                os[8] = rs.getString("tahun_ajaran");
                

                mdlSiswa.addRow(os);
            }
            return mdlSiswa;
        } catch (SQLException ex) {
            Logger.getLogger(cPembagianKelas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public void tambah_data() {
        try {

            koneksiMysql con = new koneksiMysql();
            PreparedStatement Stm = con.connect(
                    "INSERT INTO tbl_pembagian_kelas VALUES (?,?,?);");

            Stm.setInt(1, getKd_kelas());
            Stm.setInt(2, getNis());
            Stm.setString(3, getTahun_ajaran());
          
            

            Stm.executeUpdate();
              JOptionPane.showMessageDialog(null,
                     "Barang baru berhasil ditambahkan",
                    "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(cPembagianKelas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void hapusdata() {
        try {
            koneksiMysql con = new koneksiMysql();
            PreparedStatement Stm = con.connect("delete from tbl_pembagian_kelas where id_kelas=?");
            Stm.setInt(1, getKd_kelas());

            Stm.executeUpdate();
               JOptionPane.showMessageDialog(null,
                       "Barang berhasil dihapus",
                       "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(cPembagianKelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ubahdata() {
        try {
            koneksiMysql con = new koneksiMysql();
            PreparedStatement Stm = con.connect("UPDATE pembayaran.tbl_pembagian_kelas\n" +
                                "SET id_kelas = ?,\n" +
                                "  nis = ?,\n" +
                                "  tahun_ajaran = ?\n" +
                                "WHERE id_kelas = ?;");

            // Stm.setString(1, getPelajaran());
          Stm.setInt(1, getKd_kelas());
            Stm.setInt(2, getNis());
            Stm.setString(3, getTahun_ajaran());
            Stm.setInt(4, getKd_kelas());
            
            

            Stm.executeUpdate();
             JOptionPane.showMessageDialog(null,
                    "berhasil diperbarui",
                   "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(cPembagianKelas .class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
