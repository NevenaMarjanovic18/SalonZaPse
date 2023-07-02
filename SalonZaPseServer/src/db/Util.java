/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author X
 */
public class Util {
    private Properties properties;
    private static Util instance;
    
    private Util() throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream("configuration/cfg.properties");
        properties=new Properties();
        properties.load(fis);
        System.out.println(properties.getProperty("url"));
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("password"));
    }
    
    public static Util getInstance() throws IOException{
        if(instance==null){
            instance=new Util();
        }
        return instance;
    }
    
   
    public String getURL(){
        return properties.getProperty("url");
    }
    
    public String getUser(){
        return properties.getProperty("user");
    }
    
    public String getPassword(){
        return properties.getProperty("password");
    }
}
