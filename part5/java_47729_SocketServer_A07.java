import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;

public class java_47729_SocketServer_A07 { 
    private static ArrayList<User> users = new ArrayList<>(); // Simulate a database here with predefined Users for simplicity sake  
    
    public static void main(String[] args) throws Exception{     
        ServerSocket server  = new ServerSocket(80);      
         System.out.println("Server started..." ); 
         
           while (true){            
               Socket socket = server.accept();             
                   handleRequest(socket);   }           
     }    public static void handleRequest(Socket s) {      //A method to manage client requests        try{               
         BufferedReader in  = new BufferedReader(new InputStreamReader (s.getInputStream()));                 
               String inputLine ="";  while ((inputLine=in .readLine()) != null){             if(!isValidUserNamePasswordPair(inputLine)) break;            //Invalid user name or password pair, exit from loop     }          try{              User u =  new User ();         BufferedWriter out  =new PrintWriter (s.getOutputStream(),true );          
        String response = "";   for (; ; ) {                if ((response=in .readLine()) == null) break;  //Receive user data                   HashMessageDigest md   = MessageDigest.getInstance("SHA256");      byte[] hashedPasswordBytes = 
md.digest(response.getBytes());StringBuffer sb = new StringBuffer();     for (int i=0;i<hashedPasswordBytes.length ; ++i)    {sb.append((char)(hashedPasswordBytes[i] & 255 | 248));      }
        u .setPassWord(response);                         //Send the hased password back to client          out.println ( sb.toString() );}catch{ e.printStackTrace();}} catch {e1.printStackTrace(); }}              finally{}   return;}  public static boolean isValidUserNamePasswordPair(String pair)
    tries a login with username and SHA256 hashed password separated by ":".        Returns true if valid, false otherwise      try{ StringTokenizer st = new StringTokenizer (pair);         User u =  users.get(st.nextToken());          //Compare the given hash from client to stored one
if (!MessageDigest.isEqual(u . getPassWord(), md.digest((st.nextToken()).getBytes()))) return false;  catch { e1.printStackTrace(); }}         }   finally {}    if (false) throw new Exception("AUTH_FAILURE");}}