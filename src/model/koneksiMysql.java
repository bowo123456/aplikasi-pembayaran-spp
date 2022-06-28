/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tri Wibowo
 */
public class koneksiMysql {
    String alamat="jdbc:mysql://localhost:3306/pembayaran";
   public java.sql.Statement connect() {
        //Connection conn=null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(koneksiMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           // try{
                java.sql.Connection conn = DriverManager.getConnection(
                    alamat, "root", "");//alamat url mysql
            //} catch (SQLException ec) {
           //     Logger.getLogger(KoneksiMysql.class.getName()).log(Level.SEVERE, null, ec);
               // MainClass mc=new MainClass();
          //  }
            java.sql.Statement statement = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            return statement;
        } catch (SQLException ex) {
            Logger.getLogger(koneksiMysql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Tidak Terhubung \n"
                    + "Harap Cek Mysql "+ex
                    , "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return null;
    }

    public PreparedStatement connect(String query) {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(koneksiMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Connection conn = DriverManager.getConnection(
                   alamat, "root", "");//alamat url mysql
            PreparedStatement 
                    stm = conn.prepareStatement(query); // parameter
           
            return stm;
        } catch (SQLException ex) {
            Logger.getLogger(koneksiMysql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Tidak Terhubung \n"
                    + "Harap Cek Mysql "+ex
                    , "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return null;
    }

 public java.sql.Connection getConnection() {
         try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(koneksiMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Connection conn = DriverManager.getConnection
        (alamat,"root", ""); //alamat url mysql
                   return conn;
        } catch (SQLException ex) {
            Logger.getLogger(koneksiMysql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Tidak Terhubung \n"
                    + "Harap Cek Mysqlnya \n "+ex
                    , "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return null;
    }
}
