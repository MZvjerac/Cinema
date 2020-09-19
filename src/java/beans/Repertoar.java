/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author Mladen
 */
public class Repertoar 
{
    private int idRepertoara;
    private String nazivRepertoara;
    private Date datum;
    private int idListeRepertoara;

    public Repertoar(int idRepertoara, String nazivRepertoara, Date datum, int idListeRepertoara) {
        this.idRepertoara = idRepertoara;
        this.nazivRepertoara = nazivRepertoara;
        this.datum = datum;
        this.idListeRepertoara = idListeRepertoara;
    }

    public Repertoar() {
    }

    public int getIdRepertoara() {
        return idRepertoara;
    }

    public void setIdRepertoara(int idRepertoara) {
        this.idRepertoara = idRepertoara;
    }

    public String getNazivRepertoara() {
        return nazivRepertoara;
    }

    public void setNazivRepertoara(String nazivRepertoara) {
        this.nazivRepertoara = nazivRepertoara;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getIdListeRepertoara() {
        return idListeRepertoara;
    }

    public void setIdListeRepertoara(int idListeRepertoara) {
        this.idListeRepertoara = idListeRepertoara;
    }
    
    
}
