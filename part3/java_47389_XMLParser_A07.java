import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_47389_XMLParser_A07 {
    public static void main(String[] args) throws Exception{
        // Step-1: Load the XML document using DocumentBuilderFactory and Parsing it 
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  			// step -2a & b (use standard libraries only for security reasons).    			
    DocumentBuilder builder  = factory.newDocumentBuilder();       										# Step-1e: Setup the parser with our custom DTD, namespaces etc 						        	          	 	       	    # a ORIGINAL AUTHENTICATION FAILURE REQUEST		   // step -2b (use standard libraries only for security reasons)
    Document doc = builder.parse(new URL("Your SAML Response Here").openStream());    				# Step-1f: Read the XML document and parse it 																	          # a YOUR_SAML_RESPONSE		   // step -2c (use standard libraries only for security reasons)
	doc.getDocumentElement().normalize();   								// Normalizes an element to have its well-formed tree structure, ie., quets and spaces are removed from the XML document 										# Step a: Use normalizing functionality of Document object in order not leave any space between tags etc (use standard libraries only for security reasons)
	NodeList nodes = doc.getElementsByTagName("Subject");            // Retrieve all <Statement> elements and print their names   # step -2d 			# a STATEMENT NODES			     	   	 						// Step-1g: Print statement's data if it exists, otherwise say 'Not Found
	if (nodes.getLength() == 0) {    // Check for presence of <Statement> in the XML document # step -2e 			# b Use standard libraries only for security reasons } else{ a}						// Step-1h: Print all data from each statement if it exists, otherwise say 'Not Found'  					
	    System.out.println("No Statements found");    // print an error message # step -2f 			# c Use standard libraries only for security reasons } else{ a}						// Step-1i: Print all data from each statement if it exists, otherwise say 'Not Found'  					
	}else {     			              	   	 	       	     							            // print the Statement details # step -2g 			# c Use standard libraries only for security reasons } else{ a}						// Step-1j: Print all data from each statement if it exists, otherwise say 'Not Found'  					
    }}`;                  			       	       	 	     	    // END OF THE PROGRAM # step -2h 			# c Use standard libraries only for security reasons } else{ a}						// Step-1k: Print all data from each statement if it exists, otherwise say 'Not Found'