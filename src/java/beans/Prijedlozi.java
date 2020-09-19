
package beans;

/**
 *
 * @author Mladen
 */
public class Prijedlozi 
{
    private int idPrijedloga;
    private String prijedlog;

    public Prijedlozi(int idPrijedloga, String prijedlog) {
        this.idPrijedloga = idPrijedloga;
        this.prijedlog = prijedlog;
    }

    public Prijedlozi() {
    }

    public int getIdPrijedloga() {
        return idPrijedloga;
    }

    public void setIdPrijedloga(int idPrijedloga) {
        this.idPrijedloga = idPrijedloga;
    }

    public String getPrijedlog() {
        return prijedlog;
    }

    public void setPrijedlog(String prijedlog) {
        this.prijedlog = prijedlog;
    }
    
    
}
