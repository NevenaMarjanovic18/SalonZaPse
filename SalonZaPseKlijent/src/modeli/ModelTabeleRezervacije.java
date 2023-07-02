/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.OpstiDomenskiObjekat;
import domen.Rezervacija;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author X
 */
public class ModelTabeleRezervacije extends AbstractTableModel{
    
    List<OpstiDomenskiObjekat> lista = new ArrayList<>();
    String[] kolone = {"Ljubimac", "Datum", "Ukupno vreme trajanja", "Ukupna cena", "Zaposleni"};

    public ModelTabeleRezervacije() {
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacija r = (Rezervacija) lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return r.getLjubimac();
            case 1:
                return r.getDatum();
            case 2:
                return r.getUkupnoVremeTrajanja();
            case 3:
                return r.getUkupnaCena();
            case 4:
                return r.getZaposleni();
            default:
                return "greska";
        }
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void dodajListuLjubimaca(List<OpstiDomenskiObjekat> listaRezervacija) {
        lista = listaRezervacija;
        fireTableDataChanged();
    }

    public void dodajRezervacije(List<OpstiDomenskiObjekat> listaRezervacija) {
        lista = listaRezervacija;
        fireTableDataChanged();
    }

    
}
