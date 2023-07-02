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
public class Vlasnik implements OpstiDomenskiObjekat{
    private int vlasnikid;
    private String ime;
    private String prezime;
    private String brojTelefona;

    public Vlasnik() {
    }

    public Vlasnik(int vlasnikid, String ime, String prezime, String brojTelefona) {
        this.vlasnikid = vlasnikid;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.vlasnikid;
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
        final Vlasnik other = (Vlasnik) obj;
        if (this.vlasnikid != other.vlasnikid) {
            return false;
        }
        return true;
    }
    

    @Override
    public String vratiImeTabele() {
        return "vlasnik";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s'", vlasnikid, ime, prezime, brojTelefona);
    }

    @Override
    public String vratiPK() {
        return "vlasnikid";
    }

    @Override
    public int vratiVrednostPK() {
        return vlasnikid;
    }

    @Override
    public String vratiSlozeniPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        List<OpstiDomenskiObjekat> vlasnici = new ArrayList<>();
        
        try {
            while(rs.next()){
                int vlasnikid = rs.getInt("vlasnikid");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String brojTelefona = rs.getString("brojTelefona");
                
                Vlasnik v = new Vlasnik(vlasnikid, ime, prezime, brojTelefona);
                vlasnici.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vlasnik.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska kod RSuTabelu za Vlasnika");
        }
        return vlasnici;
    }

    @Override
    public String vratiUpdate() {
        return String.format("vlasnikid = '%s', ime = '%s', prezime = '%s', brojTelefona = '%s'", vlasnikid, ime, prezime, brojTelefona);
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.vlasnikid = pk;
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

    public int getVlasnikid() {
        return vlasnikid;
    }

    public void setVlasnikid(int vlasnikid) {
        this.vlasnikid = vlasnikid;
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

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }
}
