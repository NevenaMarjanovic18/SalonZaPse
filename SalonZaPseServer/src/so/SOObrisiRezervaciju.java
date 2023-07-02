/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;

/**
 *
 * @author X
 */
public class SOObrisiRezervaciju extends OpstaSO{
    
    private OpstiDomenskiObjekat param;
    private OpstiDomenskiObjekat obrisan;

    public SOObrisiRezervaciju(OpstiDomenskiObjekat param) {
        this.param = param;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        obrisan = dbb.obrisiObjekat(param);
    }

    public OpstiDomenskiObjekat getObrisan() {
        return obrisan;
    }
    
    @Override
    protected void proveriPreduslov() {
    }
}
