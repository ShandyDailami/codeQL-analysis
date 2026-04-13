import java.io.*;   // for InputStream, OutputStream classes   
import java.net.*; // for ServerSocket class java_49148_SocketServer_A01 javax.crypto.*; // for Cipher instances & KeyFactory instance      
import sun.security.ssl.*;    
// Importing the MessageDigest source file provides MD5 operation on a string of bytes  
import java.util.*;    // import LinkedList, ArrayList classes (used in this case) 
public class SocketServer{     
static final String ALGORITHM = "AES";       static Key key;     private boolean done=false;         public ServerSocket server ;        try {                char[] array1234567890_ciphering  = {'a', 'b','C' ,  ... (rest of your code here)}           
key = KeyGenerator.getInstance("AES").generateKey();    } catch {}      public void start(int port) throws IOException{                 server= new ServerSocket(port);          // waiting for connection        while(!done){                Socket socket  =server .accept();              Thread t      =  null;            
try {  MessageDigest md =MessageDigest.getInstance("MD5");   byte [] digest =  ... (rest of your code here)} catch {}               String string1= new String(digest);          try{                 Cipher cipherobject  =Cipher.getInstance ("AES");           
cipherobject .init(Cipher.DECRYPT_MODE, key );    byte[] bytes = ... (rest of your code here)} catch {}              BufferedReader in =  newBuffere   readern("...");  try{                         String string2=in..readLine();                    
if (!string1.equalsIgnoreCase(string2)) throw       ..... }catch {          System .out     Println (" connection from    ... ");}}             finally{}               done = true;}              public void   stop(){ server     `enter code here`  .close ();}           SocketServer socket =  newSocketSe