import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // Import Input/Output Stream classes  
    
public class java_42686_XMLParser_A08 {   
        public static void main(String[] args) throws ParserConfigurationException, IOException{     
            String xmlFile = "invalidXMLFile"; /* Replace this with your file */         
             try (InputStream inputStream =  new FileInputStream("src/main/" +xmlFile+".xml")) {       // Read XML content into a Stream    	  		   			 	 									             	     	   								      } catch(Exception e)        {}            finally{}         return;                 
               ParserFactory.newInstance().setFeature("http://xml.org/sax/features/external-parametric-entity", true); // Enable external parametric entity for SAX  		   			 	 									             	     	   								      } catch(Exception e)        {}            finally{}         return;                 
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      	    						         							                                                             	}catch (ParserConfigurationException pce){ System.out.println("Failed to parse configuration: " +pce);} 									     	 			   		   } catch(Exception e)        {}            finally{}         return;                     
             try {DocumentBuilder builder = dbFactory.newDocumentBuilder();	    								         							                                                             	}catch (ParserConfigurationException pce){ System.out.println("Failed to parse configuration: " +pce);} 									     	 			   		   } catch(Exception e)        {}            finally{}         return;                     
             Document doc = builder.parse(inputStream);              	    								         							                                                             	}catch (SAXParseException spxe){ System.out.println("Parsing failed: " +spxe);} 									     	 			   		   } catch {} finally{}         return;                     
             // Your code here                   	    });                    	        };                  }}	                   );          	};    	}}}}}}`          /* end of your snippet */