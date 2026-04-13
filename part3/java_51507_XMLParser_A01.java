import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.apache.xerces.jaxp.validation.ValidatorSupport;
public class java_51507_XMLParser_A01 {    
    public static void main(String[] args) throws Exception{        
        XMLReader reader = null;            
            try 
           // Using StAX (SAX): Simple API for XML reading and parsing, with the ability to use DOM events etc.  
          {                     
                reader =  XMLReaderFactory.createXMLReader();                
                  reader.setValidationMode(ValidatorSupport.VALIDATION_STRICT);                         
            }  // End of StAX initialization                   
           catch (ParserConfigurationException e)            
              {                   System.out.println("Caught ParserConfigExc: " +e );       return;   }               
                  DocumentBuilderFactory dbFactory = null ;                    
          try                       
         /*Using DOM Builder API*/ 
            //DOM3, is an extension to the basic XML DOM and XSLT domains which provides a full subset of HTML4/XHTML1.                 Default Parameter Value: false              
             {                    dBuilder =  DocumentBuilderFactory.newInstance();                  }                catch (Exception e2)                    
              {                   System.out.println("Caught DB Factory Exc " +e ); return;   };                        try  // Root element of the document is required as argument for createDocument method                     
               {                       d = dbFactory .newDocumentBuilder().newDocument(); }                  catch (Exception e3)                    
              {                   System.out.println("Caught DB Document Exc " +e ); return;   };                        try  // Root element of the document is required as argument for createElement method                     
               {                       nRoot = d .createElement(root_element); }                  catch (Exception e4)                    
              {                   System.out.println("Caught DB Element Exc " +e ); return;   };                        try  // Root element of the document is required as argument for setElementText method                     
               {                       nRoot .setTextContent(content_element); }                  catch (Exception e5)                    
              {                   System.out.println("Caught DB TextExc " +e ); return;   };                        reader.parse(new File("sample.xml") , new SAXHandler());               
        }}// End of Main Method  //XML parsing ends here                    }    catch (Exception e){System . out . println (" Caught Exception: ");return ;}            System.. err . Print_StackTrace();   return;}}}}}                     };                   try {reader.close()};catch(Exception ex)