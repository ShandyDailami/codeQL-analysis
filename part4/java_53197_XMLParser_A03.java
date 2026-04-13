import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
  
public class java_53197_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "example.xml";  // replace with your file path           
          
        DocumentBuilderFactory dbFactory;      
        InputSource is;     
         
        try {              
             dbFactory= (DocumentBuilderFactory) new SAXParserFactory();             
                        
                 System.out.println("Initializing Parser...");               
                    
                  //Create an instance of the parser        
            XMLReader xmlr = dbFactory.newSAXParser().getXmlReader(null, true);     
               is=new InputSource(new FileInputStream (xmlFile));          
             System.out.println("Parsing..."+is );                  
              Parser p =  new DocumentHandlerExample();  //replace with your class name         
            xmlr.setContentHandler((ContenHAndler)p);       
              
                    /* parse the XML file */        
                     xmlr.parse(is);                  }           catch (FileNotFoundException e1){     System.out.println("Couldn't find   " +xmlFile+".");  return;      }}catch    (SAXException ex) {ex . printStackTrace();}       finish:{         
            if (!DocumentHandlerExample.)exitStatus = EXIT_FAILURE;}        //replace with your class name           System.out.println ("Exit Status : " + exitstatus);  }      catch(ParserConfigurationException pce){System..printstacktrace ()} ;}};    ParserConfigu . setValidateOnthem();