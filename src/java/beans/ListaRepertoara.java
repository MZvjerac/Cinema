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
public class ListaRepertoara 
{
    private int iDListeRepertoara;
    private String nazivListe;

    public ListaRepertoara(int iDListeRepertoara, String nazivListe) {
        this.iDListeRepertoara = iDListeRepertoara;
        this.nazivListe = nazivListe;
    }

    public ListaRepertoara() {
    }

    public int getiDListeRepertoara() {
        return iDListeRepertoara;
    }

    public void setiDListeRepertoara(int iDListeRepertoara) {
        this.iDListeRepertoara = iDListeRepertoara;
    }

    public String getNazivListe() {
        return nazivListe;
    }

    public void setNazivListe(String nazivListe) {
        this.nazivListe = nazivListe;
    }
   

   
    
    
}
