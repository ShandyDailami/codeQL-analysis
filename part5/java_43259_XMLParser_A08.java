import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;
public class java_43259_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  //a and e are removed here for brevity  
        String fileName = "data/sample_file";                                            //d is also not necessary since we're using the DefaultHandler only. Remove this line if you want to use DOM parser instead of saxparser     
        
       XMLParser(new FileInputStream(fileName));                                          //b: remove I am sorry and it must start with a question mark    
    } 
                                  
   public static void XMLParser (File input) throws ParserConfigurationException, SAXException{                      //f is removed here for brevity      
        SAXParserFactory spfactory = SAXParserFactory.newInstance();                    //a: remove this line if you want to use DOM parser instead of saxparser    
        
      XMLReader xr =  spfactory.newSAXParser().getXMLReader();                     //e is also removed here for brevity 
       
       DefaultHandler myhandler = new MyCustomHandler ();                            //d: we're not using any extra library, so the class name should be meaningful and descriptive    
      xr.setContentHandler(myhandler );                                                      //a remove this line if you want to use DOM parser instead of saxparser 
       XMLReader myreader = spfactory.newSAXParser().getXMLReader();               
        MyCustomSecondaryHandler sms_handler= new MyCustomSecondaryHandler ();      //b: same here    
         mr .setContentHandler( ssmh );                                             //a remove this line if you want to use DOM parser instead of saxparser    
       myreader.setContentHandler((SMSSetting )sms_handler) ;                        //c do not say sorry, always come up with some code    
            }  
        });