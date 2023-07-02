/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Ljubimac;
import domen.OpstiDomenskiObjekat;
import domen.Rezervacija;
import domen.Vlasnik;
import domen.Zaposleni;
import java.util.List;
import so.SOIzmeniLjubimca;
import so.SONadjiLjubimce;
import so.SONadjiRezervacije;
import so.SOObrisiLjubimca;
import so.SOObrisiRezervaciju;
import so.SOUlogujZaposlenog;
import so.SOVratiLjubimce;
import so.SOVratiRezervacije;
import so.SOVratiUsluge;
import so.SOVratiVlasnike;
import so.SOVratiVrste;
import so.SOZapamtiLjubimca;
import so.SOZapamtiRezervaciju;
import so.SOZapamtiVlasnika;

/**
 *
 * @author X
 */
public class Kontroler {
    private static Kontroler instance;

    public Kontroler() {
    }

    public static Kontroler getInstance() {
        if(instance == null){
            instance = new Kontroler();
        }
        return instance;
    }

    public OpstiDomenskiObjekat ulogujZaposlenog(Zaposleni z) {
        SOUlogujZaposlenog soz = new SOUlogujZaposlenog();
        soz.setUnetiParametri(z);
        soz.izvrsiOperaciju();
        return soz.getUlogovaniZaposleni();
    }

    public List<OpstiDomenskiObjekat> vratiVrste() {
        SOVratiVrste sovr = new SOVratiVrste();
        sovr.izvrsiOperaciju();
        return sovr.getLista();
    }

    public List<OpstiDomenskiObjekat> vratiVlasnike() {
        SOVratiVlasnike sovl = new SOVratiVlasnike();
        sovl.izvrsiOperaciju();
        return sovl.getLista();
    }

    public OpstiDomenskiObjekat zapamtiVlasnika(Vlasnik v) {
        SOZapamtiVlasnika sozv = new SOZapamtiVlasnika(v);
        sozv.izvrsiOperaciju();
        return sozv.getVlasnik();
    }

    public OpstiDomenskiObjekat zapamtiLjubimca(Ljubimac lj) {
        SOZapamtiLjubimca sozlj = new SOZapamtiLjubimca(lj);
        sozlj.izvrsiOperaciju();
        return sozlj.getLjubimac();
    }

    public List<OpstiDomenskiObjekat> vratiLjubimce() {
        SOVratiLjubimce sovlj = new SOVratiLjubimce();
        sovlj.izvrsiOperaciju();
        return sovlj.getLista();
    }

    public List<OpstiDomenskiObjekat> nadjiLjubimce(Ljubimac ljub) {
        SONadjiLjubimce sonlj = new SONadjiLjubimce(ljub);
        sonlj.izvrsiOperaciju();
        return sonlj.getLista();
    }

    public OpstiDomenskiObjekat izmeniLjubimca(Ljubimac izmeniLjubimac) {
        SOIzmeniLjubimca soilj = new SOIzmeniLjubimca(izmeniLjubimac);
        soilj.izvrsiOperaciju();
        return soilj.getLjubimac();
    }

    public OpstiDomenskiObjekat obrisiLjubimca(Ljubimac obrisiLjubimac) {
        SOObrisiLjubimca soolj = new SOObrisiLjubimca(obrisiLjubimac);
        soolj.izvrsiOperaciju();
        return soolj.getObrisan();
    }

    public List<OpstiDomenskiObjekat> vratiUsluge() {
        SOVratiUsluge sovu = new SOVratiUsluge();
        sovu.izvrsiOperaciju();
        return sovu.getLista();
    }

    public OpstiDomenskiObjekat zapamtiRezervaciju(Rezervacija r) {
        SOZapamtiRezervaciju sozr = new SOZapamtiRezervaciju(r);
        sozr.izvrsiOperaciju();
        return sozr.getRezervacija();
    }

    public List<OpstiDomenskiObjekat> vratiRezervacije(Rezervacija rez) {
        SOVratiRezervacije sovr = new SOVratiRezervacije(rez);
        sovr.izvrsiOperaciju();
        return sovr.getListaRezervacija();
    }

    public List<OpstiDomenskiObjekat> nadjiRezervacije(Rezervacija rr) {
        SONadjiRezervacije sonr = new SONadjiRezervacije(rr);
        sonr.izvrsiOperaciju();
        return sonr.getListaNadjenih();
    }

    public OpstiDomenskiObjekat izmeniRezervaciju(Rezervacija rezI) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public OpstiDomenskiObjekat obrisiRezervaciju(Rezervacija rezBrisanje) {
        SOObrisiRezervaciju soor = new SOObrisiRezervaciju(rezBrisanje);
        soor.izvrsiOperaciju();
        return soor.getObrisan();
    }

    
    

    
}
