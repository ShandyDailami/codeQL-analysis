import java.io.*;
import java.net.*;
import java.sql.*;   // For JDBC and MySQL database operations

public class java_43133_SocketServer_A03 { 
    private ServerSocket server;    
      
    public static void main(String[] args) throws Exception{        
        new SocketServer().start();             
      }          
         
    protected synchronized void start()throws IOException   // Protected for testing.              
    {                         
            System.out.println("Starting Server on port " +server.getLocalPort()); 
                    server =new ServerSocket(1234);             
                   acceptClients();                       }                     
       private void acceptClients() throws SocketException   //Private for testing too, to allow extending this class with a test case   
      {         System.out.println("Waiting For Clients on Port "+server.getLocalPort());         
        while(true)              {Socket client= server.accept();            
            new ClientHandler (client);           }    
       }}   // Close bracket should go here and match the open brace of SocketServer      public class Clie  ntHandler extends Thread    /** Constructor, to accept a socket as argument **/        {         private Soc eket;          Societ(soc)             System.out .println("Client Connected");
            }              // Method read - reads in messages from the Client and then echoes them back  Public void run(){while (true){ try{ Socketeckt = server sock edataInputStream= new DataInputStream(clientSocket.getInputS tream()); BufferedReader reader=  newBufferedReade r("inputMessage"); String message; intr naNcidoBytes, Length = 0 ;byte[] bytes=new byte[512];while ((inT =reader .read(bytes))!= - 1){Length += intr } try{ out.println ("Server: " + in‌​Message );}catch (IOException e ) {e.printStackTrace()}} catch