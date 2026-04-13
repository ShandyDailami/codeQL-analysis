import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
   import sun.security.x509.*;
    // Importing required classes for XML parsing, SAX and certificate validation:
    
public class java_47751_XMLParser_A01 { 
      public static void main(String[] args) throws ParserConfigurationException, SAXException{
          String inputFile = "/path_to/yourfile.xml";   // replace with your file path here;       
           parseAndValidateXmlUsingSAX(inputFile);      
     }   
      private static void parseAndValidateXmlUsingSAX (String inputFileName) throws ParserConfigurationException, SAXException { 
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   // creating a factory for XML document:
           XmlReader reader;              
            try{                  
                DBConfig dbConfig =  new DBConfig( "SunX509", null );     // defining the provider, no passwords needed and set it to load certificates from file system.   
                
                    DocumentBuilder docBuilder =dbFactory .newDocumentBuilder( 
                        new org.w3c.dom.Documents(), dbConfig ,null);            
                     reader=docBuilder.getXmlReader();                      // Create XML Reader:     
            }catch (Exception e){                        
                System.out.println("Failed to create DocumentBuilder." +e );   /// catching the exception if any    
                  return; 
              }              
           try{                
             reader = new org.xml.sax.SAXReader();    // Create SAX Reader:                  
          }catch (Exception e){                       // Catching exceptions           
                System.out.println("Failed to create Xmlreader." +e );  /// Print error if any  
                  return;      
           }       
               try{                    
                 XMLValidator validator = new XMLValidator(new CertificateHelper(), null,null);      // Creating a certificate Validtor:   
                       Document doc =  reader.getDocument();    
                        System.out.println("Loading the document..." +doc .toString());          /// Load and print xml content  :  
                          validator = new XMLValidator(new CertificateHelper(), null,null);      // Re-initializing certificate Validtor   
                           if (!validator.validate( doc , "CertFile" )){         // Checking the validity of document using a cert file (replace with your .cer or PEM)  :  
                                 System.out.println("Invalid XML Document ");          /// If invalid print this message     
                                   return;       }                else             {               /* Valid xml, now do something */             
                                //...//       
                               };            reader_.close();                     try{                      __