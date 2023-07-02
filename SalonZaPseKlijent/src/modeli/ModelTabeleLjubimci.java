/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Ljubimac;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author X
 */
public class ModelTabeleLjubimci extends AbstractTableModel{
    
    List<OpstiDomenskiObjekat> lista = new ArrayList<>();
    String[] kolone = {"Ime", "Vrsta", "Vlasnik"};

    public ModelTabeleLjubimci() {
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
        Ljubimac lj = (Ljubimac) lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return lj.getIme();
            case 1:
                return lj.getVrsta();
            case 2:
                return lj.getVlasnik();
            default:
                return "greska";
        }
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void dodajLjubimceUListu(List<OpstiDomenskiObjekat> listaLjubimaca) {
        lista = listaLjubimaca;
        fireTableDataChanged();
    }

    public void popuniTabelu(List<OpstiDomenskiObjekat> listaLjubimaca) {
        lista = listaLjubimaca;
        fireTableDataChanged();
    }
    
    
    
}
