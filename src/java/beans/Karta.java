
package beans;

/**
 *
 * @author Mladen
 */
public class Karta 
{
    private int idKarte;
    private String vrstaKarte;
    private double cijena;
    private int idRezervacije;
    private int idFilm;

    public Karta(int idKarte, String vrstaKarte, double cijena, int idRezervacije, int idFilm) {
        this.idKarte = idKarte;
        this.vrstaKarte = vrstaKarte;
        this.cijena = cijena;
        this.idRezervacije = idRezervacije;
        this.idFilm = idFilm;
    }

    public Karta() {
    }

    public int getIdKarte() {
        return idKarte;
    }

    public void setIdKarte(int idKarte) {
        this.idKarte = idKarte;
    }

    public String getVrstaKarte() {
        return vrstaKarte;
    }

    public void setVrstaKarte(String vrstaKarte) {
        this.vrstaKarte = vrstaKarte;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public int getIdRezervacije() {
        return idRezervacije;
    }

    public void setIdRezervacije(int idRezervacije) {
        this.idRezervacije = idRezervacije;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }
    
    
}
