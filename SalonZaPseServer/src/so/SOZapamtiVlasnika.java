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
public class SOZapamtiVlasnika extends OpstaSO{
    
    private OpstiDomenskiObjekat param;
    private OpstiDomenskiObjekat vlasnik;

    public SOZapamtiVlasnika(OpstiDomenskiObjekat param) {
        this.param = param;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() {
        vlasnik = dbb.sacuvajObjekat(param);
    }
    
    @Override
    protected void proveriPreduslov() {
    }

    public OpstiDomenskiObjekat getParam() {
        return param;
    }

    public void setParam(OpstiDomenskiObjekat param) {
        this.param = param;
    }

    public OpstiDomenskiObjekat getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(OpstiDomenskiObjekat vlasnik) {
        this.vlasnik = vlasnik;
    }
    
}
