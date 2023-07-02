/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Zaposleni;
import java.util.List;

/**
 *
 * @author X
 */
public class SOUlogujZaposlenog extends OpstaSO{
    
    private OpstiDomenskiObjekat unetiParametri;
    private OpstiDomenskiObjekat ulogovaniZaposleni;
    
    @Override
    protected void proveriPreduslov() {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() {
        List<OpstiDomenskiObjekat> listaZaposlenih = dbb.vratiSveObjekte(new Zaposleni());
        Zaposleni unetiZaposleni = (Zaposleni) unetiParametri;
        for (OpstiDomenskiObjekat z : listaZaposlenih) {
            Zaposleni zaposleniIzBaze = (Zaposleni) z;
            if(zaposleniIzBaze.getKorisnickoIme().equals(unetiZaposleni.getKorisnickoIme()) && zaposleniIzBaze.getLozinka().equals(unetiZaposleni.getLozinka())){
                ulogovaniZaposleni = zaposleniIzBaze;
            }
        }
    }

    public OpstiDomenskiObjekat getUnetiParametri() {
        return unetiParametri;
    }

    public void setUnetiParametri(OpstiDomenskiObjekat unetiParametri) {
        this.unetiParametri = unetiParametri;
    }

    public OpstiDomenskiObjekat getUlogovaniZaposleni() {
        return ulogovaniZaposleni;
    }

    public void setUlogovaniZaposleni(OpstiDomenskiObjekat ulogovaniZaposleni) {
        this.ulogovaniZaposleni = ulogovaniZaposleni;
    }
    
}
