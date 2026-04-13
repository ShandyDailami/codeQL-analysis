import java.net.*;
import java.io.*;
  
public class java_47534_SocketServer_A07 {
    public static void main(String args[]) throws Exception{      
        ServerSocket server = new ServerSocket(5067);         //create a socket on port 1234                
          System.out.println("Waiting for connection from client...");                    
           Socket sock =server.accept();    /* get incoming communication */   while (true) {                  char buffer[]=new String().getBytes();                      int bytes_read;                   DataInputStream dis =  new  DataInputStream(sock.getInputStream());                       // read inexact data from the client           
                                                                                                                    System.out.println("Client connected: "+ sock);   while ((bytes_read =dis.available())>0) {           buffer=new String (buffer , bytes_read );  /* echo back received message */                             if(checkAuthFailuer(buffer)) throw new RuntimeException ("Authentication failed");
                                                                                                                    System.out.println("Client sent: " +"\n<<<>>>>> "\+sock);    sock.getOutputStream().write((bytes_read).toString ());  /* echo back the received byte */                          }                  server.close();       }} //end of main method