import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;
public class java_45530_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        // Task: Find all employees with salary more than $50k in "employees.xml" file and print them out using DOM parser (no external libraries). 
         try {      
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
             XmlReader reader=factory.newSAXReader();     
              SAXHandler handler= new SAXHandler(true);   // Constructor with printSalary as true to show salary info on each employee 
               Reader xmlFile =  new FileReader("employees.xml");   
                reader.setContentHandler(handler);    
                 reader.parse(new InputSource(xmlFile));     
             } catch (IOException e) {       // Handle I/O exception if file not found, path or any other issue       
               System.out.println("Error: " +e );   
              }         
           /* Task 2 */     try{   DocumentBuilderFactory factory =DocumentBuilderFactory .newInstance();     
             XmlReader reader=factory.newSAXReader(false);       SAXHandler handler=  new SAXHandler(true) ; // Constructor with printSalary as true to show salary info on each employee 
                Reader xmlFile =  new FileReader("employees.xml");   
                 reader .setContentHandler (handler );    
                  reader.parse(new InputSource(XmlFile));      } catch (IOException e) {       // Handle I/O exception if file not found, path or any other issue 
                      System outprintln ("Error: " +e);   },    });});             };}};`}}}  `