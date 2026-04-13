import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52604_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String xmlFile = "sample_file"; //replace with your actual file name or location of the .XML document     
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
        SAXParserFactory spFactory = SAXParserFactory.newInstance();   
          
       /* Using this parser to parse XML into DOM tree */  
        SAXParser saxParser =spFactory.newSAXParser(true);    
         
      //Setting the content handler for parsing 
         MyContentHandler myContentHandler= new MyContentHandler();           
              
           DocumentBuilder documentBuilder  = dbFactory .newDocumentBuilder ( );   
        XMLReader xmlreader =  saxParser.getXMLReader() ;  
            
       /* Recommended way of processing a file */    
          System.out.println("Parsing complete");     
            }  catch(Exception e){           //In case any error occurs               
                    System.out.println (e);   
                      }        }}