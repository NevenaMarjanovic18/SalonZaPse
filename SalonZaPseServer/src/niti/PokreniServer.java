/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author X
 */
public class PokreniServer extends Thread{
    
    ServerSocket ss;
    

    @Override
    public void run() {
        try {
            ss = new ServerSocket(9000);
            while(true){
                Socket klijent = ss.accept();
                ObradaKlijentskihZahteva nit = new ObradaKlijentskihZahteva(klijent);
                nit.start();
                System.out.println("Klijent se povezao");
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zaustaviServer() {
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
