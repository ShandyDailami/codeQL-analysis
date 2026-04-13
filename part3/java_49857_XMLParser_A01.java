import java.nio.file.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.util.*;

public class java_49857_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerFactory.Error {
        XMLReader reader = XMLReaderBuilder.create();  // Using SAX parser (not recommended for large files as it's not thread safe and can cause memory issues). You may use StAX or DOM based parsing instead depending on your requirements.
        
        Path filePath= Paths.get("path_to_your_file");   // replace with the path to XML File 
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   
           DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();     
         
       try {       
             Document doc  =dBuilder.parse(filePath.toFile());    
             
               // Get all employee elements from the document  
            List<Element> employees = Arrays.asList(doc.getElementsByTagName("employee").item(0).getChildNodes()).stream()      .filter(node ->  node instanceof Element)   
                                                            .map(node-> (Element)  node )     // Convert to element for the next operations  
                                                                                          .collect(Collectors.toList());                 
             System.out.println("Employees:");        
                employees.stream().forEach((e)->  {                  
                 String name= e.getElementsByTagName("name").item(0).getTextContent();    // Get and print the names of all employee elements  
                                                         if (null !=  name &&  !"".equalsIgnoreCase(name))             System.out.println("\tEmployee Name: " + name);     });     
       } catch (Exception e1) {       
            e1.printStackTrace();         //Catch any exception that may occur during parsing and print the stack trace   })  ;}}}    },{}}}{{{{}");}