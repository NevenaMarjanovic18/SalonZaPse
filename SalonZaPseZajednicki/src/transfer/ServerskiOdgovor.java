/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author X
 */
public class ServerskiOdgovor implements Serializable{
    
    private int uspesnost;
    private Object odgovor;
    private String poruka;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(int uspesnost, Object odgovor, String poruka) {
        this.uspesnost = uspesnost;
        this.odgovor = odgovor;
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public int getUspesnost() {
        return uspesnost;
    }

    public void setUspesnost(int uspesnost) {
        this.uspesnost = uspesnost;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }
}
