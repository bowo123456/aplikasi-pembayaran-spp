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
public class mKelas {
 private int id_kelas;
 private String jenis_kelas,kelas,tahun_ajaran;

    public mKelas() {
    }

    public int getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(int id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getJenis_kelas() {
        return jenis_kelas;
    }

    public void setJenis_kelas(String jenis_kelas) {
        this.jenis_kelas = jenis_kelas;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTahun_ajaran() {
        return tahun_ajaran;
    }

    public void setTahun_ajaran(String tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }
 
}
