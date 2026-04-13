import javax.xml.parsers.*;
import org.w3c.dom.*;
// importing required java packages 
public class java_48346_XMLParser_A03 {  
    public static void main(String args[]) throws ParserConfigurationException, SAXException{       
            // create the factory for handling xml parsing    
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
                
             /* get document builder */        
              DocumentBuilder dbuilder=dbFactory.newDocumentBuilder();  
              
           /** parse using DOM parser and print data **/      
            try {        // root element of the documents   
                Documents doc = (Documents)dbuilder.parse( new SourceResolvingXmlReader("inputfileName") );     
                 }  catch (Exception e){                   System . out .println ("Can’t parse inputFile ");                  return;               }         
           //System.out.print("\nData read from file....\n");     });              dbuilder=null;    }, {, ,        "inputfileName" should be replaced by the actual xml document source (like a local or network path).  */   ); }} catch(Exception e){ System . out . println ("Error parsing XML: ", +e); }