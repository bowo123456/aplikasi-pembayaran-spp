/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tri Wibowo
 */
public class mPembagianKelas {
    private int kd_kelas,nis;
    private String tahun_ajaran;

    public mPembagianKelas() {
    }

    public int getKd_kelas() {
        return kd_kelas;
    }

    public void setKd_kelas(int kd_kelas) {
        this.kd_kelas = kd_kelas;
    }

    public int getNis() {
        return nis;
    }

    public void setNis(int nis) {
        this.nis = nis;
    }

    public String getTahun_ajaran() {
        return tahun_ajaran;
    }

    public void setTahun_ajaran(String tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }
    
}
