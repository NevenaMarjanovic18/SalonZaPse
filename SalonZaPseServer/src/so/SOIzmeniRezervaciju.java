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
public class SOIzmeniRezervaciju extends OpstaSO{
    private OpstiDomenskiObjekat param;
    private OpstiDomenskiObjekat rezervacija;

    public SOIzmeniRezervaciju(OpstiDomenskiObjekat param) {
        this.param = param;
    }
 
    @Override
    protected void izvrsiKonkretnuOperaciju() {
            rezervacija = dbb.izmeniObjekat(param);
            obrisiStavke(rezervacija);
            postaviStavke(rezervacija);
       
    }

    public OpstiDomenskiObjekat getParam() {
        return param;
    }

    public void setParam(OpstiDomenskiObjekat param) {
        this.param = param;
    }

    public OpstiDomenskiObjekat getRezervacija() {
        return rezervacija;
    }

    
    private void obrisiStavke(OpstiDomenskiObjekat rez) {
        Rezervacija r = (Rezervacija) rez;
        List<OpstiDomenskiObjekat> stavkeBrisanje = dbb.vratiObjekte(new StavkaRezervacije(r));
        for (OpstiDomenskiObjekat odo : stavkeBrisanje) {
            StavkaRezervacije st = (StavkaRezervacije) odo;
            dbb.obrisiObjekat(st);
        }
    }

    private void postaviStavke(OpstiDomenskiObjekat izmenjenaRezervacija) {
        Rezervacija r = (Rezervacija) param;
        for (OpstiDomenskiObjekat odo : r.getListaStavki()) {
            StavkaRezervacije st = (StavkaRezervacije) odo;
            dbb.sacuvajObjekat(st);
        }
        Rezervacija izmenjena = (Rezervacija) izmenjenaRezervacija;
        izmenjena.setListaStavki(dbb.vratiObjekte(new StavkaRezervacije(izmenjena)));
    }

    @Override
    protected void proveriPreduslov() {
    }

}
