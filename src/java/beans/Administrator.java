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
public class Administrator 
{
    private String jmbgAdministratora;
    private String ime;
    private String prezime;
    private int idBioskopa;
    private String jmbgMenadzera;
    private String username;
    private String password;

    public Administrator(String jmbgAdministratora, String ime, String prezime, int idBioskopa, String jmbgMenadzera, String username, String password) {
        this.jmbgAdministratora = jmbgAdministratora;
        this.ime = ime;
        this.prezime = prezime;
        this.idBioskopa = idBioskopa;
        this.jmbgMenadzera = jmbgMenadzera;
        this.username = username;
        this.password = password;
    }

    public Administrator() {
    }

    public String getJmbgAdministratora() {
        return jmbgAdministratora;
    }

    public void setJmbgAdministratora(String jmbgAdministratora) {
        this.jmbgAdministratora = jmbgAdministratora;
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

    public int getIdBioskopa() {
        return idBioskopa;
    }

    public void setIdBioskopa(int idBioskopa) {
        this.idBioskopa = idBioskopa;
    }

    public String getJmbgMenadzera() {
        return jmbgMenadzera;
    }

    public void setJmbgMenadzera(String jmbgMenadzera) {
        this.jmbgMenadzera = jmbgMenadzera;
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
