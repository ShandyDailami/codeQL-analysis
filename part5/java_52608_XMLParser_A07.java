import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
public class java_52608_XMLParser_A07 {   
     public static void main(String[] args) throws ParserConfigurationException, SAXException 
        {      
            // Create a factory for the parsing engine  
             SAXParserFactory spf = SAXParserFactory.newInstance();     
             
               String xmlFilePath="securityData-file123456";    
                XMLReader xr=  spf .newSAXParser().getXMLReader( new InputSource(  // Read the file into input source  
                        new FileInputStream (xmlFilePath) ) );     
         /*    Create a Handler to handle start and end tags of all elements in xml */     DefaultHandler dh = new MyDefaultHandler();       xr.setContentHandler((ContenHandler,start,end)-> {dh .handleStartingElement(null,"xyz",start);});            // Set the handler for errors  
             System.out.println("Reading XML File: "+xmlFilePath );      String encoding ="UTF-8";       xr.setEncoding(encoding) ;    /* Read file with 20456 decoding */     try {xr .parse ( xmlFilePath , dh);} catch (Exception e){System .out .println ("Error parsing the XML: "+e ); }        
        }}   // End of main method.      MyDefaultHandler is a default handler class that will be used while reading    elements from your file