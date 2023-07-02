/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;

/**
 *
 * @author X
 */
public abstract class OpstaSO {
    
    protected DBBroker dbb;

    public OpstaSO() {
        this.dbb = new DBBroker();
    }
    
    synchronized public void izvrsiOperaciju(){
        otvoriKonekciju();
        try {
            proveriPreduslov();
            izvrsiKonkretnuOperaciju();
            potvrdiTransakciju();
        } catch (Exception e) {
            ponistiTransakciju();
            throw e;
        } finally {
            zatvoriKonekciju();
        }
    }

    private void potvrdiTransakciju() {
        dbb.potvrdiTransakciju();
    }

    private void ponistiTransakciju() {
        dbb.ponistiTransakciju();
    }

    private void zatvoriKonekciju() {
        dbb.raskiniKonekciju();
    }

    private void otvoriKonekciju() {
        dbb.uspostaviKonekciju();
    }

    protected abstract void proveriPreduslov();
    
    protected abstract void izvrsiKonkretnuOperaciju();
    
}
