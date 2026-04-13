import javax.xml.*;
import org.apache.commons.digest.DigestUtils;    // Import Apache Digest for SHA-256 checksum calculation 

public class java_53004_XMLParser_A08 {    
	static String xmlString = 	"<note>\n" +  			// Input XML data string      
								"  <to>Tove</to>\n" + 			    // Receiver's email address        
                                "   <from>Jani</from>\n"+     	     // Sender’s Email Address         
                                 "   <heading>Reminder</heading> \n" +      	// Subject          
                                 	"  <body>Don't forget me this weekend.</body>\n" + 		   	   			 	       									           	 	     								  	     //Message body                    
								" </note>";                      						              				        	} ;        ";"// Close XML string                      }             ";      };          */;/**/}; /*Close of the program. The following comment was removed for brevity, but it's still there to close out a multi-line block in Java
 		                 	  	 								     // Calculate SHA256 checksum          			        									    System.out.println(DigestUtils.sha256Hex("<note><to>Tove</to> <from>Jani <heading>Reminder<body>Don't forget me this weekend.,coding: http://www..com"));
}