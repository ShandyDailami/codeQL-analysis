import java.net.*;
import java.io.*;
public class java_52371_CredentialValidator_A03 {  
    public static void main(String[] args) throws Exception{       
         // Create a new URL object for the remote server's IP address and port number:    
          String urlStr = "http://user123456789:@localhost/";  // change your user name, password here.      
           int port = 80;   ##If it is different on other ports##     
         URL url= new URL("http",urlStr ,port);       
          HttpURLConnection http = (HttpURLConnection) url.openConnection();   
            // Set up the request method and headers:    
           String userCredential =  "user123456789";  ##Change your username here##      
         final String USER_CREDENTIALS = userCredential;  
          http.setRequestMethod("GET");     
            // If you want to set additional headers, uncomment the following line:    
           /*http.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT)");*/   
          http.setDoOutput(true);     
         // Send request to URL      
            System.out.println("\nSending 'GET' request to URL : " + urlStr );    
        String responseCode =  http.getResponseMessage();  ##It will return a code like OK or Not Found##   
          BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));     
         // Get the stream of the object and write it to a file (e.g., saved as 'response')    
           String inputLine;  ##It will print out your response##    FileWriter writer=null;  
          try {      
            /*writer = new FileWriter("path_to/yourfile");*/      //Replace path with correct one for the file.       
              while ((inputLine = in.readLine()) != null)  ##It will print out your response##    writer.write(inputLine);    
               } catch (Exception e){      
             System.out.println("Error: " + e);      //Caught exception is printed here   }) ;        };          try {}};`}))))){});}  ##It will print out your response##    });}; finally {};}}}**/)}))) ){System... /*more code*/ }}