import java.io.*;
import javax.xml.*;
import org.apache.xerces.parsers.*;
public class java_51545_XMLParser_A07 {    
    public static void main(String[] args) throws Exception{     
        XMLReader parser = null;      
         try  // for handling exception  
          {            
            ParserConfiguration conf =  new ParserConfiguration();          
              conf.setValidating(true);              
                conf.setNamespaceAware(false);                 
                 parsersEnabledSecurityCheck  = true ;    // Enable Security check     
                   parser = XMLReaderFactory .newInstance().getXMLReader((String) null,conf );            
            SAXSource sax =  new SAXSource (  new AuthHandler() ,   false )       ;         
                  parser.setFeature( "http://apache.org/xml/features/nonvalidating/load-dtd",false);     // Disable DTD validation   
                   parser .parse(sax );                }           catch (Exception e) {             System . err   . println (" Error parsing the XML file: ",e ) ;  return;         }}        class AuthHandler implements SAXHandler{ public void startElement      ...     #1$ of methods remain...