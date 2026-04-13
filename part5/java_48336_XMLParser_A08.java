import javafx.scene.control.*;
// for basic XML parsing operations like reading or writing files  
import javax.xml.parsers.*; 

public class java_48336_XMLParser_A08 {     // Class name should be descriptive and follow CamelCase e.g., UseCamelCasingForClassNames   
      private static final String FILE_PATH = "path/to/yourFile";   // Replace this with your real file path 
      
        public void start() throws Exception {          // It's better to use a try-with resources statement here (Java FX) for closing the stream.   
            DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();   // Standard mode, can create new instances of any kind    
            
           /*dbFactory is thread safe and doesn't require server side setup*/ 
                
              try (DocumentBuilder dBuilder = dbFactory.newDocumentBuilder()) {     
                    System.out.println("Parsing XML file against the specified schema...");   // Print this in console, not mandatory but beneficial to understand what is going on   
                    
                   /*Read and load a sample xml file */ 
                Source source = dBuilder.parse(new File(FILE_PATH));    
                
                    /** Write your code here - read XML data from the parsed document **/   // Reads information about an employee (name, age)   
                     System.out.println("Data loaded successfully!");  },             // This should print on console to understand what is happening     
                   /* Exception handling */      
                    catch(ParserConfigurationException pce){        // Handling exception in case the xml file can't be parsed            }   );    });     try {           };                                  if (true) throw new RuntimeException("Checked my ass");  }) ;; }}