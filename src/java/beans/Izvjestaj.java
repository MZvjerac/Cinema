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
public class Izvjestaj 
{
    private Date datum;
    private int sumirano;

    public Izvjestaj(Date datum, int sumirano) {
        this.datum = datum;
        this.sumirano = sumirano;
    }

    public Izvjestaj() {
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getSumirano() {
        return sumirano;
    }

    public void setSumirano(int sumirano) {
        this.sumirano = sumirano;
    }
    
    
}
