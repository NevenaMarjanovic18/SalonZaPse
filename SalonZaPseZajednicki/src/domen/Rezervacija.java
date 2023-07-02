/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author X
 */
public class Rezervacija implements OpstiDomenskiObjekat{
    private int rezervacijaid;
    private Date datum;
    private String opis;
    private int ukupnoVremeTrajanja;
    private double ukupnaCena;
    private List<OpstiDomenskiObjekat> listaStavki;
    private Zaposleni zaposleni;
    private Ljubimac ljubimac;

    public Rezervacija() {
    }

    public Rezervacija(int rezervacijaid, Date datum, String opis, int ukupnoVremeTrajanja, double ukupnaCena, Zaposleni zaposleni, Ljubimac ljubimac) {
        this.rezervacijaid = rezervacijaid;
        this.datum = datum;
        this.opis = opis;
        this.ukupnoVremeTrajanja = ukupnoVremeTrajanja;
        this.ukupnaCena = ukupnaCena;
        this.listaStavki = new ArrayList<>();
        this.zaposleni = zaposleni;
        this.ljubimac = ljubimac;
    }

    public Rezervacija(int rezervacijaid) {
        this.rezervacijaid = rezervacijaid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.rezervacijaid;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rezervacija other = (Rezervacija) obj;
        if (this.rezervacijaid != other.rezervacijaid) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String vratiImeTabele() {
        return "rezervacija";
    }

    @Override
    public String vratiParametre() {
        java.sql.Timestamp sqlDatum = new java.sql.Timestamp(datum.getTime());
        return String.format("'%s', '%s', '%s', '%s', '%s', '%s', '%s'", rezervacijaid, sqlDatum, opis, ukupnoVremeTrajanja, ukupnaCena, zaposleni.getZaposleniid(), ljubimac.getLjubimacid());
        
    }

    @Override
    public String vratiPK() {
        return "rezervacijaid";
    }

    @Override
    public int vratiVrednostPK() {
        return rezervacijaid;
    }

    @Override
    public String vratiSlozeniPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        List<OpstiDomenskiObjekat> rezervacije = new ArrayList<>();
        
        try {
            while(rs.next()){
                int rezervacijaid = rs.getInt("rezervacijaid");
                Date datum = rs.getTimestamp("datumVreme");
                String opis = rs.getString("opisRezervacije");
                int ukupnoVremeTrajanja = rs.getInt("ukupnoVremeTrajanja");
                double ukupnaCena = rs.getDouble("ukupnaCena");
                int zaposleniid = rs.getInt("zaposleniid");
                int ljubimacid = rs.getInt("ljubimacid");
                
                Ljubimac lj = new Ljubimac(ljubimacid, rs.getString("imeLjubimca"), new Vrsta(rs.getInt("vrstaid"), rs.getString("nazivVrste"), rs.getString("kategorija")), new Vlasnik(rs.getInt("vlasnikid"), rs.getString("imeVlasnika"), rs.getString("prezimeVlasnika"), rs.getString("brojTelefona")));
                Rezervacija r = new Rezervacija(rezervacijaid, datum, opis, ukupnoVremeTrajanja, ukupnaCena, new Zaposleni(zaposleniid, rs.getString("imeZaposlenog"), rs.getString("prezimeZaposlenog"), rs.getString("korisnickoIme"), rs.getString("lozinka")), lj);
                StavkaRezervacije st = new StavkaRezervacije(rs.getInt("rbStavke"), r, rs.getString("opisStavke"), new Usluga(rs.getInt("uslugaid"), rs.getString("nazivUsluge"), rs.getInt("vremeTrajanja"), rs.getDouble("cenaUsluge")));
                
                
                if(!rezervacije.contains(r)){
                  r.getListaStavki().add(st);
                  rezervacije.add(r);
               }else{
                   for (OpstiDomenskiObjekat odo : rezervacije) {
                       Rezervacija rez = (Rezervacija) odo;
                       if(r.equals(rez)){
                           rez.getListaStavki().add(st);
                       }
                   }
               }  
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rezervacija.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska prilikom RSuTabelu kod Rezervacije");
        }
        return rezervacije;
    }

    @Override
    public String vratiUpdate() {
        java.sql.Timestamp sqlDatum = new java.sql.Timestamp(datum.getTime());
        return String.format("rezervacijaid = '%s', datum = '%s', opis = '%s', ukupnoVremeTrajanja= '%s', ukupnaCena= '%s', zaposleniid = '%s', ljubimacid = '%s'", rezervacijaid, sqlDatum, opis, ukupnoVremeTrajanja, ukupnaCena, zaposleni.getZaposleniid(), ljubimac.getLjubimacid());
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.rezervacijaid = pk;
    }

    @Override
    public String kolone() {
        return "r.rezervacijaid, r.datumVreme, r.opis AS opisRezervacije, r.ukupnoVremeTrajanja, r.ukupnaCena, z.zaposleniid, z.ime as imeZaposlenog, z.prezime as prezimeZaposlenog, z.korisnickoIme , z.lozinka, lj.ljubimacid, lj.ime as imeLjubimca, vl.vlasnikid, vl.ime AS imeVlasnika, vl.prezime as prezimeVlasnika, vl.brojTelefona, vr.vrstaid, vr.naziv as nazivVrste, vr.kategorija, st.rbStavke, st.opis as opisStavke, u.uslugaid, u.naziv as nazivUsluge, u.vremeTrajanja, u.cenaUsluge";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "ljubimac lj JOIN vlasnik vl ON lj.vlasnikid = vl.vlasnikid "
                + "JOIN vrsta vr ON lj.vrstaid = vr.vrstaid "
                + "JOIN rezervacija r ON r.ljubimacid = lj.ljubimacid "
                + "JOIN zaposleni z ON r.zaposleniid = z.zaposleniid "
                + "JOIN stavkarezervacije st ON r.rezervacijaid = st.rezervacijaid "
                + "JOIN usluga u ON st.uslugaid = u.uslugaid ";
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return " z.zaposleniid = ";
    }

    @Override
    public String vratiVrednostAtributa() {
        return String.valueOf(zaposleni.getZaposleniid());
    }

    @Override
    public String vratiAtributePretrazivanja() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String d = sdf.format(datum);
        return String.format(" z.zaposleniid = '%s' AND DATE(datumVreme) = '%s' ", zaposleni.getZaposleniid(), d);
    }

    public int getRezervacijaid() {
        return rezervacijaid;
    }

    public void setRezervacijaid(int rezervacijaid) {
        this.rezervacijaid = rezervacijaid;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getUkupnoVremeTrajanja() {
        return ukupnoVremeTrajanja;
    }

    public void setUkupnoVremeTrajanja(int ukupnoVremeTrajanja) {
        this.ukupnoVremeTrajanja = ukupnoVremeTrajanja;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public List<OpstiDomenskiObjekat> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<OpstiDomenskiObjekat> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Ljubimac getLjubimac() {
        return ljubimac;
    }

    public void setLjubimac(Ljubimac ljubimac) {
        this.ljubimac = ljubimac;
    }

    @Override
    public String toString() {
        return "Datum i vreme: " + datum + ", ukupno vreme trajanja: " + ukupnoVremeTrajanja + ", ukupna cena: " + ukupnaCena;
    }
}
