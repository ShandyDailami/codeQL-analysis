import javax.xml.parsers.*;
import org.w3c.dom.*;  // Standard W3C DOM API (for parsing XML)  
// Importing only these specific classes, not all of them are required in full security environment   
    
public class java_45662_XMLParser_A01 {      
      public static void main(String[] args){       
           try{         
               DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();             // Step 1: Create a factory instance  
               
               SchemaFactory sfFactory = dbFactory.getSchemaLanguageParserFactory();                 // Use the new parser and schema language from DBFACTORY, not all of them will be used if only parsing is required      
           
              /* Load your XML file using schemas */ 
             Document doc=sfFactory.newDocumentBuilder().parse(args[0]);    		   	   // Step: Parse the xml document from given source (file or http url)     									       			              	   	 	     
                                                                                                       	       								                            sdfactory;          }                     catch XMLException e1){            System . out. println ("Invalid Syntax - " +e);         return;}catch(ParserConfigurationException pce ) {System..println("Error in parsing configuration- ",pce) ;return}               					
                                                                                                                       if (doc != null && doc.hasChildNodes()  /*if it has child nodes*/){             // Step: Validate the XML Document    	   }                    catch(DOMException de ) {System..println("Error in DOM parsing - ",de) ;return}                  return;
              System . out. println ("Parsing Successful");                                     	// If no exceptions thrown, then we can be sure that our xml document is well-formed (valid), so do something useful  		    } catch(Exception e){System..println("Unexpected Error - ",e) ;return;}    	
            }}  // end of main method          	       	   									       			              	     	 	}//end try and Catch block.          A security sensitive operation, you should handle this exception in your production environment as well                      }   catch (Exception e){System..println("Unexpected Error - ",e) ;return;}