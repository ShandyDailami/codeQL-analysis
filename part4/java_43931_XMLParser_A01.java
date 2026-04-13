import javax.xml.parsers.*;  
import org.w3c.dom.*;   
 
public class java_43931_XMLParser_A01 {    
       public static void main(String[] args) throws ParserConfigurationException, SAXException{     
             DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();       
              XMLReader reader=factory.newXMLReader();  
               String xmlFile ="input.xml";    // File to parse    
                try { 
                    System.out.println("Parsing...");      
                  Parser p= factory.newParser();     
                   Document doc=  (Document)p.parse( new InputSource(  
                            new StringReader( fileToString(xmlFile))) ;         reader .setContentHandler((Handler)doc );  //setting content handler    };          catch (IOException e){System.out.println("error in reading the input");};      }           });            try {       System. out . println("\nEmployee's data : ");     parseElement( doc , "employees" ) ;}  
                  finally 
                {}    };               catch (Exception e)          {};        }}