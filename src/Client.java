import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian
 */
public class Client {
    Socket connection = null;
    String serverAddress = "";
    int port;
    DataOutputStream out=null;
    DataInputStream in= null;
    Gestore g;
    public Client()
    {   
        //nome o IP del server
        serverAddress="localhost";
        //porta 
        port=2000;   
        //Date now=new Date();
    }
    public void connetti()
    {
        try
        {
            //dichiarazione oggetto socket
            connection = new Socket(serverAddress, port);
            System.out.println("Connessione aperta");
        }
        catch(ConnectException e){
            System.err.println("Server non disponibile!");
        }
        catch(UnknownHostException e1){
            System.err.println("Errore DNS!");
        }
        catch(IOException e2){//
            System.err.println(e2);
            e2.printStackTrace();
        }
        g=new Gestore(connection,"Client");
    }

    
    
}