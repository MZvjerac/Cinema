
package beans;

/**
 *
 * @author Mladen
 */
public class Rezervacija 
{
    private int idRezervacije;
    private int trajanjeRezervacije;
    private int idKorisnika;

    public Rezervacija(int idRezervacije, int trajanjeRezervacije, int idKorisnika) {
        this.idRezervacije = idRezervacije;
        this.trajanjeRezervacije = trajanjeRezervacije;
        this.idKorisnika = idKorisnika;
    }

    public Rezervacija() {
    }

    public int getIdRezervacije() {
        return idRezervacije;
    }

    public void setIdRezervacije(int idRezervacije) {
        this.idRezervacije = idRezervacije;
    }

    public int getTrajanjeRezervacije() {
        return trajanjeRezervacije;
    }

    public void setTrajanjeRezervacije(int trajanjeRezervacije) {
        this.trajanjeRezervacije = trajanjeRezervacije;
    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }
    
    
}
