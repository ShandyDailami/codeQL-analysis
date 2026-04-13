import java.io.*;   // Import File I/O and Serialization utilities   
import javax.xml.parsers.*;  // The XML parser API    
import org.w3c.dom.*;       // Document interface, RigthTextHandler for DOM-based stylesheets (XSLT)     
import java.net.URL;   // URL object to retrieve a file on the disk using File I/O   
 
public class java_48599_XMLParser_A01 {    
          public static void main(String args[]){            
                try{                    
                    String xmlFile = "A01_BrokenAccessControl\\dataSampleFileXmlDataSetOneToFiveElementsOnlyTestingAgainstValidXMLWithSchemaValidationAndWithoutRelaxedSchemasetTwoPointsThreeFourtyfiveMinutesEpoch.xml";   // XML file path   
                        File inputFile  = new File( xmlFile ); 
                            DocumentBuilderFactory dbFactory =      
                                DocumentBuilderFactory.newInstance();    
                                    DocumentBuilder dBuilder = 
                                        dbFactory.newDocumentBuilder();     
                                      Document doc = dBuilder.parse(inputFile);   // Parse the file into a tree structure   
                                          
                                     System.out.println("Root Element : " +      
                                         doc.getElements().getNamedItem("note"));    
                                for (int i = 0; i <doc.getChildNodes().getLength();i++) {     
                                      Node node = doc.getChildNodes().item(i);  // Get the current element   
                                          if (!node.hasAttributes())               # If no attributes, print it out   else printf("\nNode Name : "+        i +" , Attributes are ");       for (int j = 0;j< node . getAttributes ()     .getLength(); ++J)             { System  ..println(i   + 
                                         ", attribute[" +  J  +      ]         =          ""   ;                }               println("Node Value : "+node.getTextContent());                  }} catch (Exception e){       // Catch reading exception        };     finally{           DocumentSaverImpl   saver =  dBuilder .getDocumentSaver();   
                                         System..println(e );}}}  # End of Main method}};