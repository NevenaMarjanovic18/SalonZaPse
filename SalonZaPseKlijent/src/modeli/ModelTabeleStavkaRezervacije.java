/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.OpstiDomenskiObjekat;
import domen.StavkaRezervacije;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author X
 */
public class ModelTabeleStavkaRezervacije extends AbstractTableModel{
    
    List<OpstiDomenskiObjekat> lista = new ArrayList<>();
    String[] kolone = {"Rb.", "Naziv usluge", "Trajanje", "Cena", "Opis"};

    public ModelTabeleStavkaRezervacije() {
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
        StavkaRezervacije st =  (StavkaRezervacije) lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return st.getRbStavke();
            case 1:
                return st.getUsluga().getNaziv();
            case 2:
                return st.getUsluga().getVremeTrajanja();
            case 3:
                return st.getUsluga().getCenaUsluge();
            case 4:
                return st.getOpis();
            default:
                return "greska";
        }
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void dodajUTabelu(StavkaRezervacije sr) {
        lista.add(sr);
        fireTableDataChanged();
    }

    public void obrisiStavku(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    

}
