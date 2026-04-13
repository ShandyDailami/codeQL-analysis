import java.security.*;   // Import for all security related features 
// import javax..;    --> For any other necessary library, uncomment and replace '...' with actual class java_50112_XMLParser_A07 if applicable otherwise keep it as is (use * to select most common)

public final public class XmlSecurityParser {    
	boolean authenticated = false ; // default value for all non-authenticated users.  It will be overwritten by the authentication process on login attempt  
    String userName;               	// This could also come from a secure way to store/retrieve username, password etc...for now we just declare it here as boolean variable    	      
     	   		           			 // and use later when authenticating against database or other realms (like OAuth) 					  				   	     	 						        								              	// Incomplete due the constraints of this exercise. Please replace '....' with actual code etc...                      	}        public XmlSecurityParser(String user){this.userName = user;}
    		     	      	    // Parse method, SAX style handler – similar to DOM but simpler  				   	       	 						// Incomplete due the constraints of this exercise and more details can be found in Oracle's official Java tutorial on XML Parsing with a Handler.               	}        public void parse(InputStream input) { }
	     // Here is where we set up our SAX handlers, but it gets too complex for so many examples to go into – you might want consider using an external library or even defining your own parser based on the DOM approach if performance and complexity requirements are high.  				       	 						// Incomplete due constraints of this exercise
}