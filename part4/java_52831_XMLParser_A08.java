import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
  
public class java_52831_XMLParser_A08 { 
    public static void main(String[] args) throws Exception{         
        try {        
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
           // Create a new document builder              
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();             
       // Parse the xml file into DOM object     
                Document doc = dBuilder.parse(new File("invalid_file.xml")); 
         } catch (ParserConfigurationException pce) {         
             System.out.println("Failed to parse configuration: " +pce);          
        return;   // exit program              
       }catch(IOException ie){    	           		             			   	 	   									      system out . println ("I/O Error"); 									return;}         	       							}else {                                          System.out.println("File Not Found!");}         }}`                                                             catch (SAXException saxe)                     
{                                                                                          a   s ax exception        }catch(Exception e){                 // generic Exception                  system . out      ("An Error Occurred");  return;}}