/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author X
 */
public class SOVratiRezervacije extends OpstaSO{
    
    private List<OpstiDomenskiObjekat> listaRezervacija;
    private OpstiDomenskiObjekat ulogovaniR;

    public SOVratiRezervacije(OpstiDomenskiObjekat ulogovani) {
        listaRezervacija = new ArrayList<>();
        this.ulogovaniR = ulogovani;
    }

    public List<OpstiDomenskiObjekat> getListaRezervacija() {
        return listaRezervacija;
    }


    @Override
    protected void izvrsiKonkretnuOperaciju() {
        listaRezervacija = dbb.vratiObjekte(ulogovaniR);
       
    }
    
    @Override
    protected void proveriPreduslov() {
    }

    
}
