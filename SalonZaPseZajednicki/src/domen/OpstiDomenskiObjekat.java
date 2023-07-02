/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author X
 */
public interface OpstiDomenskiObjekat extends Serializable{
    
    public String vratiImeTabele();
    public String vratiParametre();
    public String vratiPK();
    public int vratiVrednostPK();
    public String vratiSlozeniPK();
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs);
    public String vratiUpdate();
    public void postaviVrednostPK(int pk);
    public String kolone();
    public String vratiUslovZaJoin();
    public String vratiAtributPretrazivanja();
    public String vratiVrednostAtributa();
    public String vratiAtributePretrazivanja();
}
