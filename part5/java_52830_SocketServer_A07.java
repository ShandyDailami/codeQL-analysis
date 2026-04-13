import java.io.*;
import java.net.*;
import javax.crypto.*;
import sun.security.ssl.*;

public class java_52830_SocketServer_A07 {  
    private static final String ADMIN_USER = "admin";  // User to authenticate with    
    private static final String PASSWORD = "password";// Expected password for authentication     
      
        public static void main(String[] args) throws IOException, NoSuchPaddingException, IllegalBlockSizeException {  
            ServerSocket serverSock;         
         SSLServerSocket sslSock=null ;  // Secure socket   
           try{             
             KeyStore ks = KeyStore.getInstance("JKS");     
               char[] password1 = "password".toCharArray();    
                System.out.println(password1);      
            ks.load(new FileInputStream("/home/user_data/.keystore"),  // path to your keystore file  
              password1 );   
             KeyStore truststore=null;     
           try {       
               String tspassword = "truststore";       char[] trustPassword =  tspassword.toCharArray();    
                FileInputStream fis  = new FileInputStream("/home/user_data/.truststore"); // path to your keystore file    fs=newFileInputStram...  (1 more line)  28349 bytes read, write; unrelated checksum so far. Did open times: preivous
                truststore = KeyStore.getInstance("JKS" );        FileInputStream inStream  = new F i n e Input Stream( "/home/user_data/.truststore"); // path to your keystore file     3859 bytes read, write; unrelated checksum so far...  (1 more line)  27640 bytes
                trustStore.load(inStream , tspassword ); fs=new FileInputStream("/home<｜begin▁of▁sentence｜>user_data/.truststore"): the password is not correct or no such file: /s user data .~/trus..tore (No such file 1)    The operation failed with the following error message in console :the command java.security.PrivilegedActionException was encountered while trying to invoke a method "JavaSecurity"
                //it's not possible for me if you don’t know how this works, but I assume it has something do...  (1 more line)  28349 bytes read , write; unrelated checksum so far. Did open times: previously07_AuthFailure the operation failed with th