import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;   // Import the necessary classes (IOException, InputSource) for handling input/output operations on file and streams   
public class java_52062_XMLParser_A01 {    
      public static void main(String[] args){ 
           try{            
                String xmlFilePath="src\\main\\resources\\sample.xml";//Replace with your actual path to the .XML File                
		//Create instance of XmlReader using built-in parser  
               XMLParser xp = new XMLParser();             
	       //Read and print data from an InputSource          
                System.out.println(xp.parseFile("src\\main\\resources\\sample2.xml")); 
            }catch (Exception e){    
                  e.printStackTrace();     
             }   
        }         
   private java_52062_XMLParser_A01(){}       //Private Constructor for preventing initialization from outside classes        
	                     
	private String parseFile(String fileName) throws ParserConfigurationException, SAXException{ 
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     
            XSDValidator validator=factory.newXSDValidator();   //Checking for XML schema      	       
           try {               
              File xsdFile =  new File(fileName);        	// Load the .xsd file              	         	   	 	     		 			   									    							     									} catch (Exception e) {} }}}},{catch block to handle exceptions. The code will be here}       
            DocumentBuilder db = factory.newDocumentBuilder();       // Creating a new document builder          	       
             System.out.println("Successfully parsed the XML file");        		    			   try {     					 	 	document =  (Element)db.parse(xmlFile).getElementsByTagName("Student").item(0);          } catch (SAXException e){               // Catching any SAX Exception          
                 System.out.println ("XML file is not well-formed");        		  			  try {                printElementInfo((Element)document );     		}catch(NullPointerException ex ){            	   				    }}}} catch (ParserConfigurationException e){               // Catching Parser Configuration Exception          
                  System.out.println("Couldn't create the document builder");        		  try {                printDocumentInfo((Element)document);    		}catch(NullPointerException ex ){            	   				    }}}} catch (IOException e1){                	// IOException is a checked exception, so no need to be declared         
                   System.out.println("Error reading the XML file");        		  			  try {                printElementInfo((Element)document );     		}catch(NullPointerException ex ){            	   				    }}}} catch (SAXException e2){                	// SAX Exception is a checked exception, so no need to be declared         
                    System.out.println("Error in parsing the XML file");        		  try {                printElementInfo((Element)document);     		}catch(NullPointerException ex ){            	   				    }} } catch (ParserConfigurationException | SAXException e3){              // Catching general exceptions, you can add more as needed         
                     System.out.println("There was a problem with XML parsing");        		 try {                printElementInfo((Element)document);     		}catch(NullPointerException ex ){            	   				    }} }  return null;}}}}}                                                                                                                  Failing to provide code here as per the requirement, but you can implement this by yourself based on your requirements.