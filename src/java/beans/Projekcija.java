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
public class Projekcija 
{
    private int idProjekcije;
    private Time početak;   
    private int idFilm;

    public Projekcija(int idProjekcije, Time početak, int idFilm) {
        this.idProjekcije = idProjekcije;
        this.početak = početak;
        this.idFilm = idFilm;
    }

    public Projekcija() {
    }

    public int getIdProjekcije() {
        return idProjekcije;
    }

    public void setIdProjekcije(int idProjekcije) {
        this.idProjekcije = idProjekcije;
    }

    public Time getPočetak() {
        return početak;
    }

    public void setPočetak(Time početak) {
        this.početak = početak;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    

    
    
    
}
