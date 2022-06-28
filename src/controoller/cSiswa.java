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
import model.mSiswa;

/**
 *
 * @author Tri Wibowo
 */
public class cSiswa extends mSiswa {
    
    public DefaultTableModel liat_data() {
        try {
            koneksiMysql con = new koneksiMysql();
            Statement Stm = con.connect();
            ResultSet rs = Stm.executeQuery(
                    "SELECT *FROM tbl_siswa ");
            DefaultTableModel mdlSiswa = new DefaultTableModel();
            mdlSiswa.addColumn("No");
            mdlSiswa.addColumn("NIS");
            mdlSiswa.addColumn("NISN");
            mdlSiswa.addColumn("Nama Lengkap");
            mdlSiswa.addColumn("Jenis Kelamin");
            mdlSiswa.addColumn("Tempat");
            mdlSiswa.addColumn("Tanggal Lahir");
            mdlSiswa.addColumn("Agama");
            mdlSiswa.addColumn("Alamat");
            mdlSiswa.addColumn("Asal Sekolah");
            
            
          
            

            Object[] os;
            int no = 0;
            while (rs.next()) {
                os = new Object[10];
                no++;
                os[0] = String.valueOf(no).toString();
                os[1] = rs.getInt("nis");
                os[2] = rs.getInt("nisn");
                os[3] = rs.getString("nama_siswa");
                os[4] = rs.getString("jekel");
                os[5] = rs.getString("tempat");
                os[6] = rs.getString("tanggal_lahir");
                os[7] = rs.getString("agama");
                os[8] = rs.getString("alamat");
                os[9] = rs.getString("asal_sekolah");
                

                mdlSiswa.addRow(os);
            }
            return mdlSiswa;
        } catch (SQLException ex) {
            Logger.getLogger(cSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public void TambahPelajaran() {
        try {

            koneksiMysql con = new koneksiMysql();
            PreparedStatement Stm = con.connect(
                    "INSERT INTO tbl_siswa VALUES (?,?,?,?,?,?,?,?,?);");

            Stm.setInt(1, getNis());
            Stm.setInt(2, getNisn());
            Stm.setString(3, getNama());
            Stm.setString(4, getJekel());
            Stm.setString(5, getTempat());
            Stm.setString(6, getTanggal_lahir());
            Stm.setString(7, getAgama());
            Stm.setString(8, getAlamat());
            Stm.setString(9, getSekolah_asal());
            

            Stm.executeUpdate();
              JOptionPane.showMessageDialog(null,
                     "Barang baru berhasil ditambahkan",
                    "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(cSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void hapusdata() {
        try {
            koneksiMysql con = new koneksiMysql();
            PreparedStatement Stm = con.connect("delete from tbl_siswa where nis=?");
            Stm.setInt(1, getNis());

            Stm.executeUpdate();
               JOptionPane.showMessageDialog(null,
                       "Barang berhasil dihapus",
                       "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(cSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ubahdata() {
        try {
            koneksiMysql con = new koneksiMysql();
            PreparedStatement Stm = con.connect("UPDATE pembayaran.tbl_siswa\n" +
                            "SET nis = ?,\n" +
                            "  nisn = ?,\n" +
                            "  nama_siswa = ?,\n" +
                            "  jekel = ?,\n" +
                            "  tempat = ?,\n" +
                            "  tanggal_lahir = ?,\n" +
                            "  agama = ?,\n" +
                            "  alamat = ?,\n" +
                            "  asal_sekolah = ?\n" +
                            "WHERE nis = ?;");

            // Stm.setString(1, getPelajaran());
          Stm.setInt(1, getNis());
            Stm.setInt(2, getNisn());
            Stm.setString(3, getNama());
            Stm.setString(4, getJekel());
            Stm.setString(5, getTempat());
            Stm.setString(6, getTanggal_lahir());
            Stm.setString(7, getAgama());
            Stm.setString(8, getAlamat());
            Stm.setString(9, getSekolah_asal());
            Stm.setInt(10, getNis());
            

            Stm.executeUpdate();
             JOptionPane.showMessageDialog(null,
                    "berhasil diperbarui",
                   "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(cSiswa .class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
