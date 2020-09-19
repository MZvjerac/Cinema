
package beans;

/**
 *
 * @author Mladen
 */
public class Sala 
{
    private int idSale;
    private int idTehnologije;   
    private int idRepertoara;
    private int idListeSjedista;

    public Sala(int idSale, int idTehnologije, int idRepertoara, int idListeSjedista) {
        this.idSale = idSale;
        this.idTehnologije = idTehnologije;
        this.idRepertoara = idRepertoara;
        this.idListeSjedista = idListeSjedista;
    }

    public Sala() {
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getIdTehnologije() {
        return idTehnologije;
    }

    public void setIdTehnologije(int idTehnologije) {
        this.idTehnologije = idTehnologije;
    }

    public int getIdRepertoara() {
        return idRepertoara;
    }

    public void setIdRepertoara(int idRepertoara) {
        this.idRepertoara = idRepertoara;
    }

    public int getIdListeSjedista() {
        return idListeSjedista;
    }

    public void setIdListeSjedista(int idListeSjedista) {
        this.idListeSjedista = idListeSjedista;
    }
    
        
    
    
}
