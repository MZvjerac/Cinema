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
public class ListaSjedista 
{
    private int idListeSjedista;
    private String vrstaSjedista;

    public ListaSjedista(int idListeSjedista, String vrstaSjedista) {
        this.idListeSjedista = idListeSjedista;
        this.vrstaSjedista = vrstaSjedista;
    }

    public ListaSjedista() {
    }

    public int getIdListeSjedista() {
        return idListeSjedista;
    }

    public void setIdListeSjedista(int idListeSjedista) {
        this.idListeSjedista = idListeSjedista;
    }

    public String getVrstaSjedista() {
        return vrstaSjedista;
    }

    public void setVrstaSjedista(String vrstaSjedista) {
        this.vrstaSjedista = vrstaSjedista;
    }
    
    
}
