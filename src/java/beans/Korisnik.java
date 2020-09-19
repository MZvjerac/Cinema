/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Time;

/**
 *
 * @author Mladen
 */
public class Korisnik 
{
    private int idKorisnika;
    private String ime;
    private String prezime;
    private String adresa;
    private String grad;
    private int telefon;    
    private int idKluba;
    private int poeni;
    private String username;
    private String password;
    private Time rezervacija;

    public Korisnik(int idKorisnika, String ime, String prezime, String adresa, String grad, int telefon, int idKluba, int poeni, String username, String password, Time rezervacija) {
        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.telefon = telefon;
        this.idKluba = idKluba;
        this.poeni = poeni;
        this.username = username;
        this.password = password;
        this.rezervacija = rezervacija;
    }

    public Korisnik() {
    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getIdKluba() {
        return idKluba;
    }

    public void setIdKluba(int idKluba) {
        this.idKluba = idKluba;
    }

    public int getPoeni() {
        return poeni;
    }

    public void setPoeni(int poeni) {
        this.poeni = poeni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Time getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Time rezervacija) {
        this.rezervacija = rezervacija;
    }

    
    
    
}
