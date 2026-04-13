import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import sun.security.x509.*;
// Import X509Certificate (for certificate-related operations) and KeyStoreAccess (to access a key store from which the current user can be retrieved). 
public class java_47804_XMLParser_A01 {  
    public static void main(String[] args){    
        try{            
            SAXParserFactory spf = SAXParserFactory.newInstance();        
            //SAX Parser to parse an XML document     
            SAXParser saxParser=spf.newSAXParser();         
 
            MyHandler myHandler = new MyHandler();             
            
// Load the certificate from keystore          
CertStore store =  (CertStore) KeyStore.getInstance("JavaKeyStore");        
String keyStorePath  = "D:\\keystore"; // Path of your .jks file  	    	 		   			     	   				 					         	     	       ​              ​​            ‍                     ابنا أمروزً            ישוב              Βρήνα
KeyStore keystore = KeyStore.getInstance("JavaKeyStore");  	    	 		   			     	   				 					         	     	       ​              ​​            ‍                     ابنا أمروزً            ישוב              Βρήνα
// Assuming your jks file contains only one certificate (for simplicity)    	  		   			     	   				 					         	     	       ​              ​​            ‍                     ابنا أمروزً            ישוב              Βρήνα
String password = "password"; // Password for keystore    	  		   			     	   				 					         	     	       ​              ​​            ‍                     ابنا أمروزً            ישוב              Βρήνα
Certificate cert = CertFactory.getCertificate(keystore, password);    // Get the certificate from keystore 		    	 			     	   				 					         	     	       ​              ​​            ‍                     ابنا أمروزً            ישוב              Βρήνα
store.load(new FileInputStream (keyStorePath), password .toCharArray()); // Load keystore into key store 		    	 			     	   				 					         	     	       ​              ​​            ‍                     ابنا أمروزً            ישוב              Βρήνα
// Create an instance of XMLReader with the SAX parser and Handler.   		    	 			     	   				 					         	     	       ​              ​​            ‍                     ابنا أمروزً            ישוב              Βρήνα
XMLReader xmlr = saxParser .getSAXReader();  		    	 			     	   				 					         	     	       ​              ​​            ‍                     ابنا أمروزً            ישוב              Βρήνα
xmlr.setContentHandler(myHandler);         // Set Content Handler to Myhandler     		    	 			     	   				 					         	     	       ​              ​​            ‍                     ابنا أمروزً            ישוב              Βρήνα
// Start Parsing from file.xml        	  		   			     	   				 					         	     	       ​              ​​            ‍                     ابنا أمروزً            ישוב              Βρήνα      
saxParser .parse("D:\\file.xml", xmlr);     // Parse the XML file and start parsing     		   	 			 					         	     	       ​              ​​            ‍                     ابنا أمروزً            ישוב              Βρήνα
        }catch(Exception e){    	  	   				       // Catch any exception     		   	 			 					         	     	       ​              ​​            ‍                     النادي عذر,           י'sוב              Βρήνα
            System.out.println("Exception occured: "+ e);       // Print the Exception message    		   	 			 					         	     	       ​              ​​            ‍                     النادي عذر,           י'sוב              Βρήνα
        }           	  	   				     	}// End of Main method(End unique Vanilla Java XMLParser example program)    			 					         	     	       ​              ​​            ‍                     النادي عذر,           י'sוב              Βρήνα