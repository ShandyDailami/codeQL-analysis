import org.xml.sax.*;   // Import SAX Parsers    
import javax.xml.parsers.*;   
public class java_44136_XMLParser_A08 {        
 public static void main(String[] args) throws Exception{            
      XMLReader reader = XMLReaderFactory.createXMLReader();          
       String xmlFile="inputfile_A08IntegrityFailure.xml";   // Set your input file here               
          try 
            {        
               SAXParser saxp=SAXParserFactory.newInstance().newSAXParser();       
              AContentHandler handler = new AContentHandler ();   
             reader.setContentHandler(handler) ;      
           // parse the file     
                saxp.parse(xmlFile,handler );     }  catch (Exception e){          System.out.println("Error parsing XML: "+e )}           
               });   }}`;