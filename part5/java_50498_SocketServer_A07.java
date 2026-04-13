import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class java_50498_SocketServer_A07 {  
    private static final String USERNAME = "admin"; // This is a placeholder, should be changed to actual username when using this code 
    private static final String PASSWORD_KEY = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; // This is a placeholder, should be changed to actual password key when using this code
  
    public static void main(String[] args) throws Exception { 
        ServerSocket server = new ServerSocket(8189);        
    
            while (true){            
                Socket socket=server.accept();                 
                    try{          
                        DataInputStream dis=new DataInputStream(socket.getInputStream());         
                            String usernamePrompted =  dis.readUTF();  //Read the client's request   for user name   
                         boolean isAuthenticated = authenticateUserWithPasswordBasedAuth(usernamePrompted,PASSWORD_KEY);       if(!isAuthenticated) {                     System.out.println("Authentication failed");continue; }      DataOutputStream dos=new DataOutputStream(socket.getOutputStream());             //Send an acknowledgment to the client  
                            dos.writeUTF("Acknowledgement: Successfully Authentication!"); 
                        socket.close();                         
                    }catch (Exception e){ System.out.println ("Error :"+e);}      
                server.close();                  
            }     
    }}