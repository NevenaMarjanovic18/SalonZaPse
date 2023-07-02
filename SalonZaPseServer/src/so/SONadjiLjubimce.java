/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Ljubimac;
import domen.OpstiDomenskiObjekat;
import domen.Vlasnik;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author X
 */
public class SONadjiLjubimce extends OpstaSO{
    
    List<OpstiDomenskiObjekat> lista = new ArrayList<>();
    Ljubimac ljubimac;

    public SONadjiLjubimce(Ljubimac ljubimac) {
        this.ljubimac = ljubimac;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(){
        lista = dbb.vratiObjekte(ljubimac);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    @Override
    protected void proveriPreduslov() {
    }
}
