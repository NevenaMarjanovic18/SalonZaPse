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
public class Zaposleni implements OpstiDomenskiObjekat{
    private int zaposleniid;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public Zaposleni() {
    }

    public Zaposleni(int zaposleniid, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.zaposleniid = zaposleniid;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.zaposleniid;
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
        final Zaposleni other = (Zaposleni) obj;
        if (this.zaposleniid != other.zaposleniid) {
            return false;
        }
        return true;
    }

   
    @Override
    public String vratiImeTabele() {
        return "zaposleni";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s', '%s'", zaposleniid, ime, prezime, korisnickoIme, lozinka);
    }

    @Override
    public String vratiPK() {
        return "zaposleniid";
    }

    @Override
    public int vratiVrednostPK() {
        return zaposleniid;
    }

    @Override
    public String vratiSlozeniPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        List<OpstiDomenskiObjekat> zaposleni = new ArrayList<>();
        
        try {
            while(rs.next()){
                int zaposleniid = rs.getInt("zaposleniid");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String korisnickoIme = rs.getString("korisnickoIme");
                String lozinka = rs.getString("lozinka");
                
                Zaposleni z = new Zaposleni(zaposleniid, ime, prezime, korisnickoIme, lozinka);
                zaposleni.add(z);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Zaposleni.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska kod RSuTabelu za Zaposlenog");
        }
        return zaposleni;
    }

    @Override
    public String vratiUpdate() {
        return String.format("zaposleniid = '%s', ime = '%s', prezime = '%s', korisnickoIme = '%s', lozinka = '%s'", zaposleniid, ime, prezime,korisnickoIme, lozinka);
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.zaposleniid = pk;
    }

    @Override
    public String kolone() {
        return null;
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
    }

    @Override
    public String vratiAtributPretrazivanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributePretrazivanja() {
        return null;
    }

    public int getZaposleniid() {
        return zaposleniid;
    }

    public void setZaposleniid(int zaposleniid) {
        this.zaposleniid = zaposleniid;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
}
