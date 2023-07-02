/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Vlasnik;
import domen.Vrsta;
import java.util.List;

/**
 *
 * @author X
 */
public class SOVratiVlasnike extends OpstaSO{
    
    List<OpstiDomenskiObjekat> lista;

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        lista = dbb.vratiSveObjekte(new Vlasnik());
    }

    @Override
    protected void proveriPreduslov() {
    }

    
}
