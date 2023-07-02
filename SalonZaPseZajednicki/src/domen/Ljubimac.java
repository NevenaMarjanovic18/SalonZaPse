 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author X
 */
public class Ljubimac implements OpstiDomenskiObjekat{
    private int ljubimacid;
    private String ime;
    private Vrsta vrsta;
    private Vlasnik vlasnik;

    public Ljubimac() {
    }

    public Ljubimac(int ljubimacid, String ime, Vrsta vrsta, Vlasnik vlasnik) {
        this.ljubimacid = ljubimacid;
        this.ime = ime;
        this.vrsta = vrsta;
        this.vlasnik = vlasnik;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.ljubimacid;
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
        final Ljubimac other = (Ljubimac) obj;
        if (this.ljubimacid != other.ljubimacid) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiImeTabele() {
        return "ljubimac";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s'", ljubimacid, ime, vrsta.getVrstaid(), vlasnik.getVlasnikid());
                
    }

    @Override
    public String vratiPK() {
        return "ljubimacid";
    }

    @Override
    public int vratiVrednostPK() {
        return ljubimacid;
    }

    @Override
    public String vratiSlozeniPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        List<OpstiDomenskiObjekat> ljubimci = new ArrayList<>();
        
        try {
            while(rs.next()){
                
                int ljubimacid = rs.getInt("ljubimacid");
                String ime = rs.getString("ime");
                int vrstaid = rs.getInt("vrstaid");
                int vlasnikid = rs.getInt("vlasnikid");
                Vrsta v = new Vrsta(vrstaid, rs.getString("naziv"), rs.getString("kategorija"));
                Vlasnik vl = new Vlasnik(vlasnikid, rs.getString(7), rs.getString("prezime"), rs.getString("brojTelefona"));
                
                Ljubimac lj = new Ljubimac(ljubimacid, ime, v, vl);
                ljubimci.add(lj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ljubimac.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska kod RSuTabelu za Ljubimca");
        }
        return ljubimci;
    }

    @Override
    public String vratiUpdate() {
        return String.format("ljubimacid = '%s', ime = '%s', vrstaid = '%s', vlasnikid = '%s'", ljubimacid, ime, vrsta.getVrstaid(), vlasnik.getVlasnikid());
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.ljubimacid = pk;
    }

    @Override
    public String kolone() {
        return " lj.*, v.naziv, v.kategorija, vl.ime, vl.prezime, vl.brojTelefona";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "ljubimac lj JOIN vrsta v ON (lj.vrstaid = v.vrstaid) JOIN vlasnik vl ON (lj.vlasnikid = vl.vlasnikid)";
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return " lj.vlasnikid = ";
    }

    @Override
    public String vratiVrednostAtributa() {
        return String.valueOf(vlasnik.getVlasnikid());
    }

    @Override
    public String vratiAtributePretrazivanja() {
        return null;
    }

    public int getLjubimacid() {
        return ljubimacid;
    }

    public void setLjubimacid(int ljubimacid) {
        this.ljubimacid = ljubimacid;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Vrsta getVrsta() {
        return vrsta;
    }

    public void setVrsta(Vrsta vrsta) {
        this.vrsta = vrsta;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
    }

    @Override
    public String toString() {
        return "Ime: " + ime + ", Vrsta: " + vrsta + ", Kategorija: " + vrsta.getKategorija() + ", Vlasnik: " + vlasnik;
    }
    
    
}
