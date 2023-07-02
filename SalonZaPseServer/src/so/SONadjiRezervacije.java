/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Rezervacija;
import java.util.List;

/**
 *
 * @author X
 */
public class SONadjiRezervacije extends OpstaSO{
    
    private Rezervacija rezervacija;
    private List<OpstiDomenskiObjekat> listaNadjenih;

    public SONadjiRezervacije(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() {
        listaNadjenih = dbb.nadjiObjekte(rezervacija);
        
    }

    public List<OpstiDomenskiObjekat> getListaNadjenih() {
        return listaNadjenih;
    }
    
    @Override
    protected void proveriPreduslov() {
    }
}
