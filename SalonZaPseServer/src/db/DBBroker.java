/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import domen.Zaposleni;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author X
 */
public class DBBroker {
    private Connection konekcija;

    public DBBroker() {
    }

    public void uspostaviKonekciju() {
        try {
            String url = Util.getInstance().getURL();
            String user = Util.getInstance().getUser();
            String password = Util.getInstance().getPassword();
            konekcija = DriverManager.getConnection(url, user, password);
            konekcija.setAutoCommit(false);  
            
        }catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska kod citanja iz properties fajla!");
            
        }catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Konekcija na bazu neuspesna!");
        }
    }
    
    public void raskiniKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Raskidanje konekcije neuspesno!");
        }
    }
    
    public void potvrdiTransakciju() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nije uspela potvrda transakcije!");
        }
    }
    
    public void ponistiTransakciju() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nije uspelo ponistavanje transakcije!");
        }   
    }

    public List<OpstiDomenskiObjekat> vratiSveObjekte(OpstiDomenskiObjekat odo) {
        try {
            String upit;
            if(odo.kolone() == null){
                upit = "SELECT * FROM " + odo.vratiImeTabele();
            }else{
                upit = "SELECT " + odo.kolone() + " FROM " + odo.vratiUslovZaJoin();
            }
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = odo.RSuTabelu(rs);
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
    
    public OpstiDomenskiObjekat sacuvajObjekat(OpstiDomenskiObjekat odo) { 
         
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(" + odo.vratiPK() + ") AS poslednjiID from " + odo.vratiImeTabele());
            while (rs.next()) {
                int lastid = rs.getInt("poslednjiID");
                odo.postaviVrednostPK(++lastid);
            }
            String upit = String.format("INSERT INTO %s VALUES (%s)", odo.vratiImeTabele(), odo.vratiParametre());
            System.out.println(upit);
            s.executeUpdate(upit);
            s.close();
            return odo;            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<OpstiDomenskiObjekat> vratiObjekte(OpstiDomenskiObjekat odo) {
        try {
            String upit = "SELECT "+odo.kolone()+" FROM " + odo.vratiUslovZaJoin()+" WHERE "+odo.vratiAtributPretrazivanja()+odo.vratiVrednostAtributa();
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = odo.RSuTabelu(rs);
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public OpstiDomenskiObjekat izmeniObjekat(OpstiDomenskiObjekat odo) {
        try {
            String upit;
            if (odo.vratiPK() != null) {
                upit = String.format("UPDATE %s SET %s WHERE %s = %s", odo.vratiImeTabele(), odo.vratiUpdate(), odo.vratiPK(), odo.vratiVrednostPK());
            } else {
                upit = String.format("UPDATE %s SET %s WHERE %s", odo.vratiImeTabele(), odo.vratiUpdate(), odo.vratiSlozeniPK());
            }
           
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            s.close();
            return odo;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public OpstiDomenskiObjekat obrisiObjekat(OpstiDomenskiObjekat odo) {
        try {
            String upit;
            if (odo.vratiPK() != null) {
                 upit = String.format("DELETE FROM %s WHERE %s = %s", odo.vratiImeTabele(), odo.vratiPK(), odo.vratiVrednostPK());
            } else {
                 upit = String.format("DELETE FROM %s WHERE %s", odo.vratiImeTabele(), odo.vratiSlozeniPK());
            }
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            potvrdiTransakciju();
            s.close();
            return odo;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public OpstiDomenskiObjekat sacuvajObjekat2(OpstiDomenskiObjekat odo){
         
        try {
            String upit = String.format("INSERT INTO %s VALUES (%s)", odo.vratiImeTabele(), odo.vratiParametre());
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            ResultSet rs = s.executeQuery("SELECT LAST_INSERT_ID() as poslednjiID from " + odo.vratiImeTabele());
            while (rs.next()) {
                int lastid = rs.getInt("poslednjiID");
                odo.postaviVrednostPK(lastid);
                break;
            }
            s.close();
            return odo;            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<OpstiDomenskiObjekat> vratiObjekte2(OpstiDomenskiObjekat odo) {
        try {
            String upit = "SELECT "+odo.kolone()+" FROM " + odo.vratiUslovZaJoin()+" WHERE "+odo.vratiAtributPretrazivanja()+odo.vratiVrednostAtributa();
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = odo.RSuTabelu(rs);
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<OpstiDomenskiObjekat> nadjiObjekte(OpstiDomenskiObjekat odo){
        try {
            String upit = "SELECT "+odo.kolone()+" FROM " + odo.vratiUslovZaJoin()+" WHERE "+odo.vratiAtributePretrazivanja();
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = odo.RSuTabelu(rs);
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
