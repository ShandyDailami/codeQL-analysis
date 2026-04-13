import java.io.*;   // Import Java I/O classes needed such as FileInputStream, BufferedReader etc...   
import javax.xml.parsers.*;     // To parse the xml document using DOM parser (requires JDK12 or above)      
public class java_43920_XMLParser_A08 { 
      public static void main(String[] args){  
          try{        
              FileInputStream fis = new FileInputStream("samplefile");    /* Read file from your location */     // Create a input stream to read the xml data.       
               DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      // Creating factory object for reading XML content  
                  DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();           // getting instance of document builder   
                
              InputSource is = new InputSource(fis);     /*Creates a source representation using the specified input stream*/ 
              
             System.out.println("Parsing complete.");      */ Reads an XML file and creates corresponding DOM objects (like tree, fragment etc.) in memory   // Parser object to parse document from sources like streams or files            dBuilder .parse(is , null);     /*Specify the DocumentHandler*/
             System.out.println("XML fully read");        }                     catch (Exception e) {                      ConsoleLogger consoleLog = new ConsoleLogger();  Elements element =  ...;   // handle exception if any */    }}