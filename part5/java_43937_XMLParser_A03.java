import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_43937_XMLParser_A03 extends DefaultHandler {  // we extend default handler for security reasons, as they can protect against most injections (A03_Injection) in SAX parsing mechanism  
    private boolean bName = false;     // flag to check if name is encountered or not. It's used here just because of the example but could be replaced with other methods for real world use cases 
                                      // depending on your requirements (A03_Injection) and security needs, you need more elaborate code handling these scenarios as well!  
    private boolean bAge = false;     // similar flag to above. Replace this too in the same context of A03_injections but with age attribute 
                                      // for real world use cases (security considerations). This example is simple and just checking if data encounters or not, so you could do better here!  
    private String strName = null;     // to hold name. Replace these flags too in the same context as above but with age attribute 
                                      // for real world use cases (security considerations). This example is simple and just checking if data encounters or not, so you could do better here!  
    private String strAge = null;     // to hold name. Replace these flags too in the same context as above but with age attribute 
                                      // for real world use cases (security considerations). This example is simple and just checking if data encounters or not, so you could do better here!  
      
    public void startElement(String uri, String localName, String qName) {        
        switch (qName){          
            case "person":     // When person tag encountered... 
                System.out.println("Person Encountered!");          break;                
                  ...             }   else{                        bName = true;}              strName="";break;       ......    default:                          if(bAge) {strAge+=  localName ;}else                    {if(!localName.equalsIgnoreCase("age"))  // checking for name and age attribute separately, as per your requirements (security considerations).
                ...   }                                           break;}...      ......         return;}}end of class