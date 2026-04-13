import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
  
public class java_44027_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String url = "http://example-corporate/filepath"; // replace with your URL here           
          
          System.out.println("Parsing the XML file...\n");  
             
          DocumentBuilderFactory dbFactory = 
                  DocumentBuilderFactory.newInstance();    
        
        try {            
               XmlParserLegacy parser = new XmlParserLegacy(dbFactory);    // your class name may vary          
               
               URL xmldocument  = new URL (url ); 
              System.out.println ("URL : "+xmldocument);        
          Parser p =  dbFactory .newDocumentBuilder();     
             Document doc =   p.parse(xmldocument.openStream());       
                 
               readXMLFile(doc,"",0 );     // function to traverse through the file and print elements   
            }  catch (Exception e) {              System.out.println("Error in loading XML document ");         return;             }  
      }      
           private void readXMLFile(Node elem, String indent, int depth){          Document doc = null ;        NodeList nodes  =null , node=null     ;    try{            if (doc == null) {              //create a DOMDocument object               DocTypeDecl type;             XMLHandler.getDocHandler().startDTDDecl();                     }        
      else  parsElements(elem,indent,"",depth);        return;}   catch (Exception e){       System . out .println("Error in loading Document :"+e );          throw ;            }}              public void readXMLFile2() {           try{     if ((doc = XMLHandler.getDoc()) == null) 
      beginDTDDecl();                    }catch(SAXParseException e){                     System..out .println ( " Parse exception at line :"+e );                   return;         }}              public static void main(){             //calling the above methods     try{          startApp13_SecuritySensitiveOperationsAgainstA08IntegrityFailure();       }catch(Exception e){            System.out .println (" Error in starting app :"+e );                   return;      }}