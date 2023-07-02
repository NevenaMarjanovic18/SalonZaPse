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
public class Vrsta implements OpstiDomenskiObjekat{
    
    private int vrstaid;
    private String naziv;
    private String kategorija;

    public Vrsta() {
    }

    public Vrsta(int vrstaid, String naziv, String kategorija) {
        this.vrstaid = vrstaid;
        this.naziv = naziv;
        this.kategorija = kategorija;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.vrstaid;
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
        final Vrsta other = (Vrsta) obj;
        if (this.vrstaid != other.vrstaid) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String vratiImeTabele() {
        return "vrsta";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", vrstaid, naziv, kategorija);
    }

    @Override
    public String vratiPK() {
        return "vrstaid";
    }

    @Override
    public int vratiVrednostPK() {
        return vrstaid;
    }

    @Override
    public String vratiSlozeniPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        List<OpstiDomenskiObjekat> vrste = new ArrayList<>();
        
        try {
            while(rs.next()){
                int vrstaid = rs.getInt("vrstaid");
                String naziv = rs.getString("naziv");
                String kategorija = rs.getString("kategorija");
                
                Vrsta v = new Vrsta(vrstaid, naziv, kategorija);
                vrste.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vrsta.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska kod RSuTabelu za Vrstu");
        }
        return vrste;
    }

    @Override
    public String vratiUpdate() {
        return String.format("vrstaid = '%s', naziv = '%s', kategorija = '%s'", vrstaid, naziv, kategorija);
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.vrstaid = pk;
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

    public int getVrstaid() {
        return vrstaid;
    }

    public void setVrstaid(int vrstaid) {
        this.vrstaid = vrstaid;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
