import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_52202_XMLParser_A03 {  // define a public static method named parseXML that takes an input File object and returns the Document node of it as DOM tree root element, ie., parent for all elements inside document body tag (<body>)  
    private final String xmlFile;                
    
    public java_52202_XMLParser_A03(String fileName) {          // constructor with argument to set path/filename 
        this.xmlFile = fileName ;              
                                  }             
                                  
                                                                            
public Document parseXML() throws ParserConfigurationException, IOException {   //method for parsing the xml and returning root element of type 'Document' (DOM tree)   
    
       FileInputStream fis =  new FileInputStream(this.xmlFile);  /* Create an input stream from file */             
       
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   //create a document builder factory         
                                                                                       
        
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();    //provides API to read the XML and parse it into DOM tree of objects          
      
//parse using DOM Builder from file (represents an actual HTML page) 
 Document doc =  dBuilder.parse(fis);                      /* Reads a document specified by its input stream, returns as Dom Tree */         
                                                                            return doc;             //return root element      }   },                  {}}}}}                   }}        ,,,,.         .'''.'',' ''', '',     '''