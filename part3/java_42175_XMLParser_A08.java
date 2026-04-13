import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
 
public class java_42175_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        //Create a factory object and set it to parse XML file      
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
         try (InputStream fis = new FileInputStream("inputfile")) {         
            DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();            
               javax.xml.parsers.SAXParser saxParser=dBuilder .newSAXParser(new Properties());      
              SAXHandler shandler  =   new  SAXHandler ();     //Create a handler object   	        		     			       	   									                 } catch IOException e1) {             System.out.println("Error parsing the XML file" +e );}          
               saxParser .setContentHandler(shandler ) ;  	       	 								                                                             }}     //Create a SAX parser and set Content Handlers     		   	        			 									                                                                                      }}};catch (Exception e) {                     System.out.println("Parsing error in file " + f);                   
                catch(ParserConfigurationException p){                          println ("the provided XML Parser is not found ");             }}   Catch block for Exception Handling   	    		         	}  }}};catch (IOException e) {                     System..out.println("Error reading the input file");                  try{saxparser=dBuilder .newSAXParser();} catch(ExceptionE){System outprinting "Parsing error in File";}}}