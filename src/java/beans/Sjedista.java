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
public class Sjedista 
{
    private int idSjedista;    
    private Boolean rezervisano;
    private String vrsta;
    private int cijena;
    private int idListeSjedista;

    public Sjedista(int idSjedista, Boolean rezervisano, String vrsta, int cijena, int idListeSjedista) {
        this.idSjedista = idSjedista;
        this.rezervisano = rezervisano;
        this.vrsta = vrsta;
        this.cijena = cijena;
        this.idListeSjedista = idListeSjedista;
    }

    public Sjedista() {
    }

    public int getIdSjedista() {
        return idSjedista;
    }

    public void setIdSjedista(int idSjedista) {
        this.idSjedista = idSjedista;
    }

    public Boolean getRezervisano() {
        return rezervisano;
    }

    public void setRezervisano(Boolean rezervisano) {
        this.rezervisano = rezervisano;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public int getCijena() {
        return cijena;
    }

    public void setCijena(int cijena) {
        this.cijena = cijena;
    }

    public int getIdListeSjedista() {
        return idListeSjedista;
    }

    public void setIdListeSjedista(int idListeSjedista) {
        this.idListeSjedista = idListeSjedista;
    }

       
    
    
}
