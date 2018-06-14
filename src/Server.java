import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
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
public class Server {
    public static final String RED = "\u001B[31m";  //client output
    public static final String BLUE = "\u001B[34m"; //server output
    int port;
    DataInputStream in;
    DataOutputStream out;
    Date now;
    //oggetto ServerSocket necessario per accettare richieste dal client
    ServerSocket sSocket;
    //oggetto da usare per realizzare la connessione TCP
    Socket connection;
    Gestore g;
    public Server()
    {
        port=2000;
        in=null;
        out=null;
        now=null;
        sSocket=null;
    }
    public void connetti()
    {
        try{
            // il server si mette in ascolto sulla porta voluta
            sSocket = new ServerSocket(port);
            System.out.println("In attesa di connessioni!");
            //si è stabilita la connessione
            connection = sSocket.accept();
            sSocket.close();
            System.out.println("Connessione stabilita!");
            System.out.println("Socket server: " + connection.getLocalSocketAddress());
            System.out.println("Socket client: " + connection.getRemoteSocketAddress());
            //lettura dal client
            //in = new DataInputStream(connection.getInputStream());
            //System.out.println(clientUser + " ha detto: " + in.readUTF());   
        }
           catch(Exception e){
               System.err.println("Errore di I/O!");
        }
        g=new Gestore(connection,"Server");
    }
}