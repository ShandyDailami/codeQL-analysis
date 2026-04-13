import javax.xml.parsers.*;
import org.w3c.dom.*;

public class java_43936_XMLParser_A08 {  
    public static void main(String args[]) throws ParserConfigurationException, SAXException{      
        // Step1: Create a factory object for reading the xml file    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
         
        //Step2 : Get document builder from our factory  
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();          
            
        int lineNumber = 0; 
           
        try {             
               // Step3: Parse the file and construct DOM tree model of each element on a new thread for security      
                 Parser p = dBuilder .newParser();        
                  Document doc=p.getDocument();         
                   NodeList nl=doc.getElementsByTagName("tagname");        //replace "tagname" with your xml tag  
                     
                    System.out.println("\nStarting XML Parsing...");   
                       for(int i = 0;i < nl.getLength();++)       {           
                            Node node =nl.item(i);        //replace "tagname" with your xml tag         
                              lineNumber ++ ;             System.out.print("Line Number: ");     printIndentifier(lineNumber ); 
                               System.out.println("\tNode Name : "+node .getNodeName());   PrintElementDetails ( node);                  }                   return;         });    //end of try                    catch block          {System.err...        }}       ) ;      };     Stop the application, and then you can use these tools to help find faults in your code later on!