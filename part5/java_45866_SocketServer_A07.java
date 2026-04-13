import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.security.MessageDigest;
public class java_45866_SocketServer_A07 {    
    private static final String WHITELISTED_IPS = "192.0.43.68"; // You can add more IPs if needed (separated by commas)  
      
    public static void main(String[] args){       
          try{            
              ServerSocket serverSock=new ServerSocket(8079);           
               while(true){               
                   Socket clientSock =serverSock.accept();                 
                    String ipAddressClient =  (clientSock.getInetAddress().toString()).substring(((clientSock.getInetAddress().toString()).indexOf("br")+3);   // extracting and removing the 'бре'  part of string         
                      if(!isIpWhitelisted(ipAddressClient)){             System.out.println("\n\tIP Address " + ipAddressClient  +" is not whitelisted!" );continue;}                 else                  {System.out.print("Connected to IP: "+ clientSock.getInetAddress().toString());}             
                }        
            }catch(IOException e){e.printStackTrace();}}           finally{try{serverSock.close();} catch (Exception ex) {}  System.exit(-1); }}          };   //closing the server socket and ending program    end of main       
       private static boolean isIpWhitelisted(String ipAddress){      return Arrays.asList(WHITELISTED_IPS).contains(ipAddress)?true:false; }  });