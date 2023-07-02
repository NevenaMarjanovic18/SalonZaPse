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
public class StavkaRezervacije implements OpstiDomenskiObjekat{
    private int rbStavke;
    private Rezervacija rezervacija;
    private String opis;
    private Usluga usluga;

    public StavkaRezervacije() {
    }
    
    public StavkaRezervacije(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public StavkaRezervacije(int rbStavke, Rezervacija rezervacija, String opis, Usluga usluga) {
        this.rbStavke = rbStavke;
        this.rezervacija = rezervacija;
        this.opis = opis;
        this.usluga = usluga;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.rbStavke;
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
        final StavkaRezervacije other = (StavkaRezervacije) obj;
        if (this.rbStavke != other.rbStavke) {
            return false;
        }
        return true;
    }
    

    @Override
    public String vratiImeTabele() {
        return "stavkarezervacije";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s'", rbStavke, rezervacija.getRezervacijaid(), opis, usluga.getUslugaid());
    }

    @Override
    public String vratiPK() {
        return null;
    }

    @Override
    public int vratiVrednostPK() {
        return rezervacija.getRezervacijaid();
    }

    @Override
    public String vratiSlozeniPK() {
        return String.format(" rbStavke = '%d' AND rezervacijaid = '%d' ",  rbStavke, rezervacija.getRezervacijaid());
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        List<OpstiDomenskiObjekat> stavke = new ArrayList<>();
        
        try {
            while(rs.next()){
                int rbStavke = rs.getInt("rbStavke");
                int rezervacijaid = rs.getInt("rezervacijaid");
                String opis = rs.getString("opis");
                int uslugaid = rs.getInt("uslugaid");
                
                Usluga u = new Usluga(uslugaid, rs.getString("naziv"), rs.getInt("vremeTrajanja"), rs.getDouble("cenaUsluge"));
                Rezervacija r = new Rezervacija(rezervacijaid);
                StavkaRezervacije st =  new StavkaRezervacije(rbStavke, r, opis, u);
                
                stavke.add(st);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StavkaRezervacije.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greksa kod RSuTabelu za Stavke Rezervacije");
        }
        return stavke;
    }

    @Override
    public String vratiUpdate() {
        return String.format("rbStavke='%s',rezervacijaid='%s', opis='%s', uslugaid='%s'", rbStavke, rezervacija.getRezervacijaid(), opis, usluga.getUslugaid());
    }

    @Override
    public void postaviVrednostPK(int pk) {
        
    }

    @Override
    public String kolone() {
        return " * ";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "stavkarezervacije st JOIN usluga u ON st.uslugaid = u.uslugaid";
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return " rezervacijaid = ";
    }

    @Override
    public String vratiVrednostAtributa() {
        return rezervacija.getRezervacijaid() + "";
    }

    @Override
    public String vratiAtributePretrazivanja() {
        return null;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }
}
