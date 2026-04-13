import org.xml.sax.*;
import javax.xml.parsers.*;  // Import SAXParserFactory, InputSource and XMLReader interfaces from java xml parsing library  
public class java_51970_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException{            
        try {                    
            String fileName = "src/main.xml"; // change it with your desired .XML filename                        
                          
                SAXParserFactory spf =  SAXParserFactory.newInstance();          
                        XMLReader xr  =spf.newSAXParser().getXmlReader(  new InputSource(fileName),true);              
                    MyHandler mh =   new MyHandler ( );                      // create handler instance               
                     XmlParser parser =  spf .newSAXParser();          
                          try {                                                 
                                xr.setContentHandler((Handler)mh);      
                                  System.out.println("Start Parsing");        
                                   while(xr.hasNext());                   // continue parsing until end of document                      
                                        } catch (Exception e1){                             printf ("Error in parser: %s",e );   };          });                    }) ;                      try {             xr .setEntityResolver  ((EntityResolver) mh);     }}catch(Throwable t ){         System.out.println("Caught "+t;}}finally     
                        {{        finally    if (parser != null){ parser  =  spf。close();} };}}} ; println ("End Parsing");  } catch       // parse the xml document end                     }}catch( Exception e) {printStackTrace()};});             });                    })     try{ MyHandler mh = new       
Myhandler ();      SAXParserFactory spf = SAXPArserFactoR.newInstance();   InputSource is=  new InPutSourcE("src/main_xml") ;       Xmlparser p= sfp .newsaxparseer()     try{ 
                    setContentHandler ((handler)mh);    while(is..hasNext());}}catch (Throwable t){      printf ("Error in parser %S",t );}finally {if          // parse the xml document end                     }} catch                      };; printStackTrace();`}})   }};