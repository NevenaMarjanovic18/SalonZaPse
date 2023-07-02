/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Ljubimac;
import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author X
 */
public class SOVratiLjubimce extends OpstaSO{
    List<OpstiDomenskiObjekat> lista;

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        lista = dbb.vratiSveObjekte(new Ljubimac());
    }

    @Override
    protected void proveriPreduslov() {
    }
}
