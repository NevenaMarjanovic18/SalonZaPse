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
public class SOIzmeniLjubimca extends OpstaSO{
    
    private OpstiDomenskiObjekat param;
    private OpstiDomenskiObjekat ljubimac;

    public SOIzmeniLjubimca(OpstiDomenskiObjekat param) {
        this.param = param;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() {
        ljubimac = dbb.izmeniObjekat(param);
        
    }

    public OpstiDomenskiObjekat getParam() {
        return param;
    }

    public void setParam(OpstiDomenskiObjekat param) {
        this.param = param;
    }

    public OpstiDomenskiObjekat getLjubimac() {
        return ljubimac;
    }

    @Override
    protected void proveriPreduslov() {
    }
}
