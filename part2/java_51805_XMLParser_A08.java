import java.io.*; // Import Input/Output Streams Package in order to read file content  
import org.xml.sax.*; // Imports classes of Java's Simple API for XML (SAX) package   
import org.xml.sax.helpers.DefaultHandler;  // For handling unprocessed data - not necessary if you are using SAX only, but can be used in general  

public class java_51805_XMLParser_A08 extends DefaultHandler {    
       File file = new File("C:\\testfile.txt");     
        try{          
            SAXParserFactory saxpf=SAXParserFactory.newInstance();          // Create a factory for parsing the XML document   
            
              /* Read content from xml */ 
                SAXParser sp =saxpf.newSAXParser();    
               BufferedReader br  = new BufferedReader(new FileReader("C:\\testfile.txt"));          
                 String line;            // Declare a string variable for reading file     
                      while((line=br.readLine()) !=  null){          // While loop to read the content of XML from files  
                         sp.parse( new InputSource(new StringReader(line)) ,this);    } 
            
        /* Implement methods */    
         public void startDocument(){System.out.println("start document");}     
           ..... (Implements for other events) ....       // Continue this process with all your implementation of 'events'  
          /**/public void endDocument() { System. out . println ("end the document") ; }     public …..(more methods if needed like startElement,endElement etc.)        /* */    });        
              br.close();      // Close file reader      
            
            catch (Exception e)   {e.printStackTrace()}         
               };