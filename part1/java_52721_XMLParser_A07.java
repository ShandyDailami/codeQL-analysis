import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
 
public class java_52721_XMLParser_A07 {    
    public static void main(String[] args) throws Exception{        
        String xml = "<notebook><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></notebook>";              
 
        boolean isLockedOut=false;   //flag for lockout        
       DefaultHandler handler = new DefaultHandler() {            
           public void startDocument() throws SAXException{                  
              System.out.println("Start of document");}                     
            @Override   
               public void endDocument(){                
                  if(isLockedOut){                      
                     throw new SecurityException("Account is locked out, maximum login attempts exceed.");                }       
             }}      //End DefaultHandler    
       SAXParserFactory spf = SAXParserFactory.newInstance();         
           try{           
               SAXParser saxp =spf.newSAXParser(true);                     
                   System.out.println("Parsing complete");        }                catch (Exception e) {e.printStackTrace()};    //Catch the exception  });      end of main method   };        
           try{            saxp = spf .newSAXParser();                     }          finally{}     return;}              }}                  End Main Method                          );             if(isLockedOut){throw new SecurityException("Account is locked out, maximum login attempts exceed");}};    catch (final Exception e) {e.printStackTrace()};