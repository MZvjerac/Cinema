
package beans;

/**
 *
 * @author Mladen
 */
public class Tehnologija 
{
    private int idTehnologije;
    private String nazivTehnologije;

    public Tehnologija(int idTehnologije, String nazivTehnologije) {
        this.idTehnologije = idTehnologije;
        this.nazivTehnologije = nazivTehnologije;
    }

    public Tehnologija() {
    }

    public int getIdTehnologije() {
        return idTehnologije;
    }

    public void setIdTehnologije(int idTehnologije) {
        this.idTehnologije = idTehnologije;
    }

    public String getNazivTehnologije() {
        return nazivTehnologije;
    }

    public void setNazivTehnologije(String nazivTehnologije) {
        this.nazivTehnologije = nazivTehnologije;
    }
    
    
}
