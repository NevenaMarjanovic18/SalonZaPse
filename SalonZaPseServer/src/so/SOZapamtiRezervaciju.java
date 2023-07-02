/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Rezervacija;
import domen.StavkaRezervacije;
import java.util.List;

/**
 *
 * @author X
 */
public class SOZapamtiRezervaciju extends OpstaSO{
    
    OpstiDomenskiObjekat param;
    OpstiDomenskiObjekat rezervacija;

    public SOZapamtiRezervaciju(OpstiDomenskiObjekat param) {
        this.param = param;
    }
  
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        
        rezervacija = dbb.sacuvajObjekat((Rezervacija) param);
        sacuvajStavke();
        
    }

    public OpstiDomenskiObjekat getParam() {
        return param;
    }

    public OpstiDomenskiObjekat getRezervacija() {
        return rezervacija;
    }

    

    private void sacuvajStavke() {
        Rezervacija rez = (Rezervacija) param;
        List<OpstiDomenskiObjekat> stavke = rez.getListaStavki();
        for (OpstiDomenskiObjekat odo : stavke) {
            StavkaRezervacije st = (StavkaRezervacije) odo;
            dbb.sacuvajObjekat(st);
        }
    }

    @Override
    protected void proveriPreduslov() {
    }
}
