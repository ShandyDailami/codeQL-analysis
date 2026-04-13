import javax.servlet.*;
import java.io;
import com.sun.net.httpserver.*;
  
public class java_48235_CredentialValidator_A08 implements HttpHandler { // Change this according your actual needs, make sure you've import the necessary libraries/classes in Java file at top of program (like io for input and output streams) 
    private static final String VALID_USERNAME = "test";    
    private static final String CORRECT_PASSWORD ="password123!"; // Change this with actual password, not hardcoded.  
      
public void handle(HttpExchange exchange) throws IOException {  /* Method for processing HTTP requests */       
        
      if ("POST".equals(exchange.getRequestMethod())){   
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");   // Read the request body and handle it as a String 
             try (BufferedReader br =  new BufferedReader(isr)) {     /* Using buffering reader for better performance */          
                System.out.println("Received: ");       
                   PrintWriter pw = exchange.getResponseHeaders().get("Content-Type"); // Set the response content type to text/plain  which is required in this case, if not provided default will be 'text/html'    
              String line= br.readLine();      /* Read one HTTP request at a time */   
                  while(line !=  null) {       /** Break when you reach the end of input stream (EOF).*/  //Break loop on Eof reached, if not break then read more data from client and send error back to it.          
                      line = br.readLine();      /* Read next request */  	               	   	       	     		          }    				   
                  String usernameAndPassword =  new String(line);  // Decoding the received input (username:password) .			           	 					       };             });              catch { throw exception; }}               do{try}while{}catch(){throw;}`}}};//Catch block to handle exceptions where ever there is any error, as we are not interested in those.
                  if(!validateUser(usernameAndPassword)){ // Checking the validity of received credentials 		   	  	   	       	 									       }else{ sendErrorResponse("Authentication failed", exchange); return;} };        }}          });               finally {            pw .println ("Invalid Credentials");}}};
         if (exchange.getRequestMethod().equalsIgnoreCase(“OPTIONS”)){ // Handling the ‘options’ request to enable cross domain requests from browsers with a given origin or *;   };             }});           }}    catch{ throw exception;} });            try {httpserver .createContext("/creds", this);}}catch({throw})};