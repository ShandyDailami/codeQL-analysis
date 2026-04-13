import javax.xml.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_52895_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{       
       URL url = new URL("http://example.com/config.xml");  // replace with your xml file location        
           XMLReader xr =  null;         
            try {             
                System.out.println ("Creating a SAX parser...");                 
                   DocumentBuilderFactory dbFactory  =   DocumentBuilderFactory .newInstance ();                
                    DBconfigHandler myHandler = new  DBconfigHandler();      // your handler to handle the XML tags       
                       xr =  dbFactory.newSAXParser().getXMLReader();            
                        MyHandler mh=myHandler;   
                         XmlFilterImpl xmlf=  null ;         
                    try {                    
                      System .out .println ("Parsing...");              
                          EventHandler evt = new   StartEndEvent (m  h );                // event handler     
                       xr.setContentHandler(evt)    ;             
                                                   xmlf=new XmlFilterImpl();          
                  try {           
                      System .out .println ("Parsing XML file " + url);              
                           mh = new Myhandler ( );          // your handler to handle the events    
                          xr.setFeature("http://xml.org/sax/features/namespace-prefixes",true)    ; 
                       xmlf .addAllowedPrefix ("xsd","http://www.w3.org/2001/XMLSchema");              // allow XSD Namespace Prefix       
                        xr.setFeature("http://xml.org/sax/features/validation", true);              
                          System  .out .println   ( "Using the following namespace for validation" );    
                         xmlf   += new ValidationEventHandler() {                //Validation handler        
                            public void warning(SAXException e)          {}           protected       void info (String s ){}             };              }catch      .......            catch        ...   ..  .                   finally{..............................}//finally blocks.....}};}}}); }} ; throw    axioms     because         the only way to prevent exceptions is for them.