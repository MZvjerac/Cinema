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
public class Klub 
{
    private int idKluba;
    private String nazivKluba;

    public Klub(int idKluba, String nazivKluba) {
        this.idKluba = idKluba;
        this.nazivKluba = nazivKluba;
    }

    public Klub() {
    }

    public int getIdKluba() {
        return idKluba;
    }

    public void setIdKluba(int idKluba) {
        this.idKluba = idKluba;
    }

    public String getNazivKluba() {
        return nazivKluba;
    }

    public void setNazivKluba(String nazivKluba) {
        this.nazivKluba = nazivKluba;
    }
    
    
}
