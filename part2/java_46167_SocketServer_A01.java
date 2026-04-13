import java.io.*;
import java.net.*;
import javax.security.auth.Subject;
public class java_46167_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{        
        // Create a server socket at port number 12345          
       ServerSocket ss = new ServerSocket (12345);         
      System.out.println ("Waiting for client on Port: "+ss.getLocalPort());   
  
     Socket s=null;             //create a socket object           
        try {                    
           s  = ss.accept();  //block until a connection is accepted             
          System.out.println("Connection Established!");                 
         } catch (IOException ex) {                      
               System.err.println ("Accept failed with:" +ex.getMessage());    return;      
        }           
  
      OutputStream out = s.getOutputStream();  //get the output stream          
     PrintWriter pw= new PrintWriter(out,true);         
         try {                  
             Thread t1 =  new Thread (() ->{                   
               BufferedReader br  =new BufferedReader((InputStreamReader)s.getInputStream());               
                String str;           
                  while  ((str =br .readLine()) != null){                       
                     System.out.println ("Client : " +str);                       }       });          t1.start(); // Start the thread        
     pw.println("Hello Server");             println (s) ;           return;   }) );  catch{        e->{}                    };      finally {                s .close()    ss .close ()            }}});                     try {}catch(Exception ex){ }finally { if(!SocketServerInstance.isClosed())
               SocketServerInstance.stop();}}}         //call stop method of server          static           ServerSocket   SS;  protected void finalize(){      superFinalizer ();    System .outprintln ("Finally Block - Closing the socket.");     try{SS = null;} catch(Exception e){}} finally {close() ; }}