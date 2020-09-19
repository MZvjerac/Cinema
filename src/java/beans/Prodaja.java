
package beans;

import java.util.Date;



/**
 *
 * @author Mladen
 */
public class Prodaja 
{
    private int idProdaje;
    private Date datum;
    private int promet;

    public Prodaja(int idProdaje, Date datum, int promet) {
        this.idProdaje = idProdaje;
        this.datum = datum;
        this.promet = promet;
    }

    public Prodaja() {
    }

    public int getIdProdaje() {
        return idProdaje;
    }

    public void setIdProdaje(int idProdaje) {
        this.idProdaje = idProdaje;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getPromet() {
        return promet;
    }

    public void setPromet(int promet) {
        this.promet = promet;
    }

       
}
