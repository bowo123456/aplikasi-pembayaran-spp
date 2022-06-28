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
import model.mPembayaran;

/**
 *
 * @author Tri Wibowo
 */
public class cPembayaran  extends mPembayaran{
    
    public DefaultTableModel liat_data() {
        try {
            koneksiMysql con = new koneksiMysql();
            Statement Stm = con.connect();
            ResultSet rs = Stm.executeQuery(
                    "SELECT\n" +
                    "  `id_pembayaran`,\n" +
                    "  tp.`nis`,\n" +
                    "  ts.`nisn`,\n" +
                    "  ts.`nama_siswa`,\n" +
                    "  tp.`id_kelas`,\n" +
                    "  tk.`kelas`,\n" +
                    "  `tanggal_pembayaran`,\n" +
                    "  `jenis_pembayaran`,\n" +
                    "  `keterangan`\n" +
                    "FROM `pembayaran`.`tbl_pembayaran` AS tp\n" +
                    "INNER JOIN tbl_siswa AS ts\n" +
                    "ON tp.`nis` = ts.`nis`\n" +
                    "INNER JOIN tbl_kelas AS tk\n" +
                    "ON tp.`id_kelas` = tk.`id_kelas`");
            DefaultTableModel mdlPembayaran = new DefaultTableModel();
            mdlPembayaran.addColumn("No");
            mdlPembayaran.addColumn("Id Pembayaran");
            mdlPembayaran.addColumn("NIS");
            mdlPembayaran.addColumn("NISN");
            mdlPembayaran.addColumn("Nama Siswa ");
            mdlPembayaran.addColumn("Id Kelas");
            mdlPembayaran.addColumn(" Kelas");
            mdlPembayaran.addColumn("Tanggal Pembayaran");
            mdlPembayaran.addColumn("Jenis Pembayaran");
            mdlPembayaran.addColumn("Keterangan");
            
            
            

            Object[] os;
            int no = 0;
            while (rs.next()) {
                os = new Object[19];
                no++;
                os[0] = String.valueOf(no).toString();
                os[1] = rs.getInt("id_pembayaran");
                os[2] = rs.getString("nis");
                os[3] = rs.getString("nisn");
                os[4] = rs.getString("nama_siswa");
                os[5] = rs.getString("id_kelas");
                os[6] = rs.getString("kelas");
                os[7] = rs.getString("tanggal_pembayaran");
                os[8] = rs.getString("jenis_pembayaran");
                os[9] = rs.getString("keterangan");
                
                

                mdlPembayaran.addRow(os);
            }
            return mdlPembayaran;
        } catch (SQLException ex) {
            Logger.getLogger(cPembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public void tambah_data() {
        try {

            koneksiMysql con = new koneksiMysql();
            PreparedStatement Stm = con.connect(
                    "INSERT INTO pembayaran.tbl_pembayaran\n" +
                    "            ( nis,\n" +
                    "             id_kelas,\n" +
                    "             tanggal_pembayaran,\n" +
                    "             jenis_pembayaran,\n" +
                    "             keterangan)\n" +
                    "VALUES (?,?,?,?,?);");

            Stm.setInt(1, getNis());
            Stm.setInt(2, getId_kelas());
            Stm.setString(3, getTgl_pembayaran());
            Stm.setString(4, getJenis_pembayaran());
            Stm.setString(5, getKeterangan());
            
          
            

            Stm.executeUpdate();
              JOptionPane.showMessageDialog(null,
                     "Barang baru berhasil ditambahkan",
                    "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(cPembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void hapusdata() {
        try {
            koneksiMysql con = new koneksiMysql();
            PreparedStatement Stm = con.connect("delete from tbl_pembayaran where nis=?");
            Stm.setInt(1, getNis());

            Stm.executeUpdate();
               JOptionPane.showMessageDialog(null,
                       "Barang berhasil dihapus",
                       "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(cPembayaran.class.getName()).log(Level.SEVERE, null, ex);
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
//          Stm.setInt(1, getId_kelas());
//            Stm.setString(2, getJenis_kelas());
//            Stm.setString(3, getKelas());
//            Stm.setString(4, getTahun_ajaran());
//            Stm.setInt(5, getId_kelas());
            

            Stm.executeUpdate();
             JOptionPane.showMessageDialog(null,
                    "berhasil diperbarui",
                   "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(cPembayaran .class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
