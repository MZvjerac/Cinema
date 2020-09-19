/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Mladen
 */
public class Menadzer 
{
    private String jmbgMenadzera;
    private String ime;
    private String prezime;
    private String vrstaMenadzera;
    private int idBioskopa;
    private String username;
    private String password;

    public Menadzer(String jmbgMenadzera, String ime, String prezime, String vrstaMenadzera, int idBioskopa, String username, String password) {
        this.jmbgMenadzera = jmbgMenadzera;
        this.ime = ime;
        this.prezime = prezime;
        this.vrstaMenadzera = vrstaMenadzera;
        this.idBioskopa = idBioskopa;
        this.username = username;
        this.password = password;
    }

    public Menadzer() {
    }

    public String getJmbgMenadzera() {
        return jmbgMenadzera;
    }

    public void setJmbgMenadzera(String jmbgMenadzera) {
        this.jmbgMenadzera = jmbgMenadzera;
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

    public String getVrstaMenadzera() {
        return vrstaMenadzera;
    }

    public void setVrstaMenadzera(String vrstaMenadzera) {
        this.vrstaMenadzera = vrstaMenadzera;
    }

    public int getIdBioskopa() {
        return idBioskopa;
    }

    public void setIdBioskopa(int idBioskopa) {
        this.idBioskopa = idBioskopa;
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
    
    
}
