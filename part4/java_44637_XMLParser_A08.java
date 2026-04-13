import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
        
public class java_44637_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{          
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     // step 1       
            
			try (XMLReader reader=dbFactory.newDocumentReader(Main.class.getResourceAsStream("/sample_maliciously.xml"))) {      //step3      
                System.out.println("Using Document Builder factory");        
                
				// Step 4: Process the XML file using DOM parser   
	            for (int count = 0; count < 15 ; count++ ){    		          									  	   	 
                  reader.nextElement();       //step2            								         							      }              catch(Exception e){ System.out.println("Caught an exception: " +e);} 			   		}            finally {System.out.println ("Closing document...");}}    		          									  	   	 
                    });        	       
                reader=dbFactory.newDocumentReader((Main.class.getResourceAsStream("/sample_safe.xml")))); //step5          catch(Exception e){ System.err .print("Caught an exception: "+e);}        }}} 		  	           	 				}