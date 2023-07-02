/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Ljubimac;
import domen.OpstiDomenskiObjekat;
import domen.Rezervacija;
import domen.Vlasnik;
import domen.Zaposleni;
import forme.ServerskaForma;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author X
 */
public class ObradaKlijentskihZahteva extends Thread {

    Socket klijent;
    boolean kraj = false;
    ServerskaForma sf;
    OpstiDomenskiObjekat zaposleni;

    public ObradaKlijentskihZahteva(Socket klijent) {
        this.klijent = klijent;
    }

    @Override
    public void run() {
        while (!kraj) {
            KlijentskiZahtev kz = primiZahtev();
            int operacija = kz.getOperacija();
            ServerskiOdgovor so = new ServerskiOdgovor();
            switch (operacija) {
                case Operacije.LOGIN_ZAPOSLENI:
                    Zaposleni z = (Zaposleni) kz.getParametar();
                    zaposleni = Kontroler.getInstance().ulogujZaposlenog(z);
                    so.setOdgovor(zaposleni);
                    break;
                case Operacije.VRATI_VRSTE:
                    List<OpstiDomenskiObjekat> listaVrsta = Kontroler.getInstance().vratiVrste();
                    so.setOdgovor(listaVrsta);
                    break;
                case Operacije.VRATI_VLASNIKE:
                    List<OpstiDomenskiObjekat> listaVlasnika = Kontroler.getInstance().vratiVlasnike();
                    so.setOdgovor(listaVlasnika);
                    break;
                case Operacije.DODAJ_VLASNIKA:
                    Vlasnik v = (Vlasnik) kz.getParametar();
                    OpstiDomenskiObjekat vlasnik = Kontroler.getInstance().zapamtiVlasnika(v);
                    so.setOdgovor(vlasnik);
                    break;
                case Operacije.DODAJ_LJUBIMCA:
                    Ljubimac lj = (Ljubimac) kz.getParametar();
                    OpstiDomenskiObjekat ljubimac = Kontroler.getInstance().zapamtiLjubimca(lj);
                    so.setOdgovor(ljubimac);
                    break;
                case Operacije.VRATI_LJUBIMCE:
                    List<OpstiDomenskiObjekat> listaLjubimaca = Kontroler.getInstance().vratiLjubimce();
                    so.setOdgovor(listaLjubimaca);
                    break;
                case Operacije.NADJI_LJUBIMCE:
                    Ljubimac ljub = (Ljubimac) kz.getParametar();
                    List<OpstiDomenskiObjekat> listaLjubimacaUslov = Kontroler.getInstance().nadjiLjubimce(ljub);
                    so.setOdgovor(listaLjubimacaUslov);
                    break;
                case Operacije.IZMENI_LJUBIMCA:
                    Ljubimac izmeniLjubimac = (Ljubimac) kz.getParametar();
                    OpstiDomenskiObjekat ljubimacI = Kontroler.getInstance().izmeniLjubimca(izmeniLjubimac);
                    so.setOdgovor(ljubimacI);
                    break;
                case Operacije.OBRISI_LJUBIMCA:
                    Ljubimac obrisiLjubimac = (Ljubimac) kz.getParametar();
                    OpstiDomenskiObjekat ljubimacO = Kontroler.getInstance().obrisiLjubimca(obrisiLjubimac);
                    so.setOdgovor(ljubimacO);
                    break;
                case Operacije.VRATI_USLUGE:
                    List<OpstiDomenskiObjekat> listaUsluga = Kontroler.getInstance().vratiUsluge();
                    so.setOdgovor(listaUsluga);
                    break;
                case Operacije.DODAJ_REZERVACIJU:
                    Rezervacija r = (Rezervacija) kz.getParametar();
                    OpstiDomenskiObjekat rez = Kontroler.getInstance().zapamtiRezervaciju(r);
                    so.setOdgovor(rez);
                    break;
                case Operacije.VRATI_REZERVACIJE:
                    Rezervacija rezUlogovani = (Rezervacija) kz.getParametar();
                    List<OpstiDomenskiObjekat> listaRezervacija = Kontroler.getInstance().vratiRezervacije(rezUlogovani);
                    so.setOdgovor(listaRezervacija);
                    break;
                case Operacije.NADJI_REZERVACIJE:
                    Rezervacija rr = (Rezervacija) kz.getParametar();
                    List<OpstiDomenskiObjekat> listaRez = Kontroler.getInstance().nadjiRezervacije(rr);
                    so.setOdgovor(listaRez);
                    break;
                case Operacije.IZMENI_REZERVACIJU:
                    Rezervacija rezI = (Rezervacija) kz.getParametar();
                    OpstiDomenskiObjekat rezIzmenjena = Kontroler.getInstance().izmeniRezervaciju(rezI);
                    so.setOdgovor(rezIzmenjena);
                    break;
                case Operacije.OBRISI_REZERVACIJU:
                    Rezervacija rezBrisanje = (Rezervacija) kz.getParametar();
                    OpstiDomenskiObjekat obrisana = Kontroler.getInstance().obrisiRezervaciju(rezBrisanje);
                    so.setOdgovor(obrisana);
                    break;
            }
            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois = new ObjectInputStream(klijent.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(klijent.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
