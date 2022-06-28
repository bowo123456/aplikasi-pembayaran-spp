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

/**
 *
 * @author Tri Wibowo
 */
public class cKelas extends mKelas{
    public DefaultTableModel liat_data() {
        try {
            koneksiMysql con = new koneksiMysql();
            Statement Stm = con.connect();
            ResultSet rs = Stm.executeQuery(
                    "SELECT *FROM tbl_kelas ");
            DefaultTableModel mdlSiswa = new DefaultTableModel();
            mdlSiswa.addColumn("No");
            mdlSiswa.addColumn("Kode Kelas");
            mdlSiswa.addColumn("Jenis Kelas");
            mdlSiswa.addColumn("Kelas ");
            mdlSiswa.addColumn("Tahun Ajaran");
            
            

            Object[] os;
            int no = 0;
            while (rs.next()) {
                os = new Object[5];
                no++;
                os[0] = String.valueOf(no).toString();
                os[1] = rs.getInt("id_kelas");
                os[2] = rs.getInt("jenis_kelas");
                os[3] = rs.getString("kelas");
                os[4] = rs.getString("tahun_ajaran");
                

                mdlSiswa.addRow(os);
            }
            return mdlSiswa;
        } catch (SQLException ex) {
            Logger.getLogger(cKelas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public void tambah_data() {
        try {

            koneksiMysql con = new koneksiMysql();
            PreparedStatement Stm = con.connect(
                    "INSERT INTO tbl_kelas VALUES (?,?,?,?);");

            Stm.setInt(1, getId_kelas());
            Stm.setString(2, getJenis_kelas());
            Stm.setString(3, getKelas());
            Stm.setString(4, getTahun_ajaran());
          
            

            Stm.executeUpdate();
              JOptionPane.showMessageDialog(null,
                     "Barang baru berhasil ditambahkan",
                    "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(cKelas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void hapusdata() {
        try {
            koneksiMysql con = new koneksiMysql();
            PreparedStatement Stm = con.connect("delete from tbl_kelas where id_kelas=?");
            Stm.setInt(1, getId_kelas());

            Stm.executeUpdate();
               JOptionPane.showMessageDialog(null,
                       "Barang berhasil dihapus",
                       "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(cKelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ubahdata() {
        try {
            koneksiMysql con = new koneksiMysql();
            PreparedStatement Stm = con.connect("UPDATE pembayaran.tbl_kelas\n" +
                                "SET id_kelas = ?,\n" +
                                "  jenis_kelas = ?,\n" +
                                "  kelas = ?,\n" +
                                "  tahun_ajaran = ?\n" +
                                "WHERE id_kelas = ?;");

            // Stm.setString(1, getPelajaran());
          Stm.setInt(1, getId_kelas());
            Stm.setString(2, getJenis_kelas());
            Stm.setString(3, getKelas());
            Stm.setString(4, getTahun_ajaran());
            Stm.setInt(5, getId_kelas());
            

            Stm.executeUpdate();
             JOptionPane.showMessageDialog(null,
                    "berhasil diperbarui",
                   "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(cKelas .class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
