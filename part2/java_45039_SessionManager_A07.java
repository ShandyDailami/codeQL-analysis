import java.net.*;  // Import the required classes for HTTP URL connection  

public class java_45039_SessionManager_A07 {   
     public static boolean authenticate(String url, String username, String password) throws Exception{      
           HttpURLConnection conn = null;       
            try {            
                URL myUrl= new URL("http://"+url);             
                 // Open a connection to the server 
                    conn  = (HttpURLConnection)myUrl.openConnection();  
                     /* Define property headers */   
                   if(!username.equals("") && !password.equals("")) {       
                      String userpass = username + ":" +  password;     
                       String encodedPass= Base64.getEncoder().encodeToString(userpass.getBytes());  // convert the string into bytes and then encode it with base-64   
                        conn.setRequestProperty("Authorization", "Basic "+encodedPass);     }        return true;      catch (Exception e) {         System.out.println ("Failed to connect : " +e );       try{conn=(HttpURLConnection)myUrl.openConnection();}catch(Exception ex){System.out.println("Caught Exception: Failed to open the connection");return false;}  } finally {     if ( conn !=  null )   
                      ((HttpURLConnection) conn).disconnect();      }} catch (MalformedURLException e1) {}          try{conn=(HttpURLConnection)myUrl.openConnection();}catch(Exception ex){System.out.println("Caught Exception: Failed to open the connection");return false;} } 
     public static void main(String[] args ) {      System.getProperties().list(System.out);       try{authenticate ("www.google.com", "testuser","password" );}catch (Exception e) {}   }}    // end of class A07_AuthFailure