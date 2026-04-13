import javax.xml.parsers.*;
import org.xml.sax.*;

public class java_46314_XMLParser_A03 { 
     public static void main(String[] args) throws ParserConfigurationException, SAXException{   
          // Create a new instance of the DocumentBuilderFactory to parse xml   file using default values (security-sensitive operations related A03_Injection):          
         XmlDocumentBuilderFactory docFactory = new  XmlDocumentBuilderFactory();    
            System.out.println("Using XML parser and SAX");    // print message for understanding the purpose of parsing   in xml:SAX, CDATA etc mode     
        /* create a instance (new) Document */               
         final DocTypeDecl docType = new  DocTypeDecl(null,"generated.dtd" );     false;          int lineNumber=0 ;             null            "http://www..com/xmlns/"   true   592671834      };        // create the instance of XmlDocument:
         DocumentBuilder db = docFactory .newDocumentBuilder();  boolean replayable=  false;           int lineNumber=0 ;             null            "http://www..com/xmlns/"   true   592671834      };        // create the instance of XmlLocator:
         System.out.println("Done");     }  catch (Exception e) {                      Exception          ParserConfigurationException(String NamespaceURI, String suggestedName);              XMLSecurityException   null   592671834      };           true           $null   $false    $0        ;                   false         $true      $-1       ""                       "http://www..com/xmlns/"