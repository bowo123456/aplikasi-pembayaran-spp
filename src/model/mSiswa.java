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
public class mSiswa {
    private int nis,nisn;
    private String nama,tempat,tanggal_lahir,jekel,agama,sekolah_asal,alamat;

    public mSiswa() {
    }

    public int getNis() {
        return nis;
    }

    public void setNis(int nis) {
        this.nis = nis;
    }

    public int getNisn() {
        return nisn;
    }

    public void setNisn(int nisn) {
        this.nisn = nisn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getJekel() {
        return jekel;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getSekolah_asal() {
        return sekolah_asal;
    }

    public void setSekolah_asal(String sekolah_asal) {
        this.sekolah_asal = sekolah_asal;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
}
