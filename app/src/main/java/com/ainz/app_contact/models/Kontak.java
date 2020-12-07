package com.ainz.app_contact.models;

public class Kontak {

    private String id_kontak, nama, no_telp, email;

    public Kontak(String id_kontak, String nama, String no_telp, String email) {
        this.id_kontak = id_kontak;
        this.nama = nama;
        this.no_telp = no_telp;
        this.email = email;
    }

    public String getId_kontak() {
        return id_kontak;
    }

    public void setId_kontak(String id_kontak) {
        this.id_kontak = id_kontak;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
