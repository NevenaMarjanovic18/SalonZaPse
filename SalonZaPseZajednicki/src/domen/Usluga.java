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
public class Usluga implements OpstiDomenskiObjekat{
    private int uslugaid;
    private String naziv;
    private int vremeTrajanja;
    private double cenaUsluge;

    public Usluga() {
    }

    public Usluga(int uslugaid, String naziv, int vremeTrajanja, double cenaUsluge) {
        this.uslugaid = uslugaid;
        this.naziv = naziv;
        this.vremeTrajanja = vremeTrajanja;
        this.cenaUsluge = cenaUsluge;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.uslugaid;
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
        final Usluga other = (Usluga) obj;
        if (this.uslugaid != other.uslugaid) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String vratiImeTabele() {
        return "usluga";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s'", uslugaid, naziv, vremeTrajanja, cenaUsluge);
    }

    @Override
    public String vratiPK() {
        return "uslugaid";
    }

    @Override
    public int vratiVrednostPK() {
        return uslugaid;
    }

    @Override
    public String vratiSlozeniPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        List<OpstiDomenskiObjekat> usluge = new ArrayList<>();
        
        try {
            while(rs.next()){
                int uslugaid = rs.getInt("uslugaid");
                String naziv = rs.getString("naziv");
                int vremeTrajanja = rs.getInt("vremeTrajanja");
                double cenaUsluge = rs.getDouble("cenaUsluge");
                
                Usluga u = new Usluga(uslugaid, naziv, vremeTrajanja, cenaUsluge);
                usluge.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usluga.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska kod RSuTabelu za Uslugu");
        }
        return usluge;
    }

    @Override
    public String vratiUpdate() {
        return String.format("uslugaid = '%s', naziv = '%s', vremeTrajanja = '%s', cenaUsluge = '%s'", uslugaid, naziv, vremeTrajanja, cenaUsluge);
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.uslugaid = pk;
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

    public int getUslugaid() {
        return uslugaid;
    }

    public void setUslugaid(int uslugaid) {
        this.uslugaid = uslugaid;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getVremeTrajanja() {
        return vremeTrajanja;
    }

    public void setVremeTrajanja(int vremeTrajanja) {
        this.vremeTrajanja = vremeTrajanja;
    }

    public double getCenaUsluge() {
        return cenaUsluge;
    }

    public void setCenaUsluge(double cenaUsluge) {
        this.cenaUsluge = cenaUsluge;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
