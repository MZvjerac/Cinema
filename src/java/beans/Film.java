
package beans;

import java.sql.Time;

/**
 *
 * @author Mladen
 */
public class Film 
{
        private int idFilm;
        private String nazivFilma;
        private String reziser;
        private String zanr;
        private Time trajanje;
        private String recenzija;
        private String slika;
        private String trejler;
        private int idl;
        private int ids;

    public Film(int idFilm, String nazivFilma, String reziser, String zanr, Time trajanje, String recenzija, String slika, String trejler, int idl, int ids) {
        this.idFilm = idFilm;
        this.nazivFilma = nazivFilma;
        this.reziser = reziser;
        this.zanr = zanr;
        this.trajanje = trajanje;
        this.recenzija = recenzija;
        this.slika = slika;
        this.trejler = trejler;
        this.idl = idl;
        this.ids = ids;
    }

    public Film() {
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getNazivFilma() {
        return nazivFilma;
    }

    public void setNazivFilma(String nazivFilma) {
        this.nazivFilma = nazivFilma;
    }

    public String getReziser() {
        return reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public Time getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Time trajanje) {
        this.trajanje = trajanje;
    }

    public String getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(String recenzija) {
        this.recenzija = recenzija;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getTrejler() {
        return trejler;
    }

    public void setTrejler(String trejler) {
        this.trejler = trejler;
    }

    public int getIdl() {
        return idl;
    }

    public void setIdl(int idl) {
        this.idl = idl;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    

    
        
        
}
