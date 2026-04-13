import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52266_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    	
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  // Step A1: Create a document builder Factory        
        factory.setValidating(true);                                         // Set validation mode to true for error checking  
                                                                         
       try (DocumentBuilder builder=factory.newDocumentBuilder()) {      // Try with resources - closeable and auto-flushed    	
            Document doc = builder.parse( new SourceResource("input.xml") ); 	// Step A2: Parse the document from input file		  									   			              } catch (Exception e) {} finally{}                  	 	       								        // We don't have to close resources or auto-flush streams here as they are handled by try with resource	
            doc.getDocumentElement().normalize();    	// Step A3: Normalise the document  									   		 			         } catch (Exception e) {} finally{}                      });           // We don't have to close resources or auto-flush streams here as they are handled by try with resource	
                    NodeList nodes = doc.getElementsByTagName("name");            	// Step A4: Query the document for a list of all 'node name’ elements			   		 									       catch (Exception e) {} finally{}               }}                   // We don't have to close resources or auto-flush streams here as they are handled by try with resource	
            System.out.println("Found " + nodes.getLength()+" node");                   	// Step A5: Print the number of 'node name’ found in xml file			   		 									       catch (Exception e) {} finally{}               }}                   // We don't have to close resources or auto-flush streams here as they are handled by try with resource	
        }                                                           	       	// Step A6: Close the document and XML reader  									});                    };                });                 			        		 	 	};                        									   	}    	   	      }}                                                                           {{{{          // We don't have to close resources or auto-flush streams here as they are handled by try with resource