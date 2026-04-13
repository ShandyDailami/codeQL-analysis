import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_45799_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String inputFile = "maliciousXMLfile"; //replace this with your xml file name and path which contain malicious content    
        parseXmlDocument(inputFile);        
    }     
      
  public static void parseXmlDocument (String input) throws ParserConfigurationException, SAXException {  
          String language = "en-US"; //specify the encoding. If not specified will be system's default one    
             XMLReader xr;//SAX parser       
              InputSource is= new InputSource(new FileInputStream (input));   
                   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
                    DocumentBuilder dBuilder  =dbFactory.newDocumentBuilder();          
                     //parse the input source    
                      xr =  dBuilder .getSAXParser();         
                       SAXHandler sh= new SAXHandler(language,xr);       
                        Handler *h;    h =&sh ;     
                          String outputFilePath=  "outputfile.txt";  //you can specify your own file path for the resultant xml    
                           XMLWriter xw =  new XMLWriter();         
                         try {           
                              xr .setContentHandler( (ContentHandler)h);  
                               XmlLocator loc=null;        Locator l = null ;  if (!xr.getUseLocator())    //disable uri's     use_locators  = false      }           else{          Use the default URI to locate text, see below:                  xr .setFeature( (XmlFeature) "http://apache.org/xml/features/nonvalidating/strict",false); 
                               l = new XmlLocatorImpl();         loc=l;   if (!xr.getUselocators())          //disable URIs      use_locators  = false }           else{ Use the default URI to locate text, see below:                  xr .setFeature( (XmlFeature) "http://apache.org/xml/features/nonvalidating/load-dtd",false);         loc=l; 
                              //parse and write out xml     XmlWriter w = new   XMLwriter();          if (!xr.(getUselocators()) use_Locator, see below:                     xr .setFeature( (XmlFeaturess) "http://apache.org/xml/features/nonvalidating / load-external",false); l =  ne WmlX LocactorImpl() ;     
                              // parse and write out xml     XMLWriter w = new XMLwriter();          if (!xr .getUselocators())  use_Locator, see below:                  xr.setFeature( (XmlFeaure) "http://apache/xml/.orgs / features nonvalidating load - external", false); l =  new   XmlX locactorImpl() ;     
                              }    if (!xr .getUselocators())  use_Locator, see below: xr.setFeature( (XmlFeaturess) "http://apache/xml/.orgs / features nonvalidating load - external", false); l =  new XmlX locactorImpl() ;      
                              //parse and write out xml     XMLWriter w = nnew   XMLwriter();          if (!xr .getUselocators())  use_Locator, see below:                  xr.setFeature( (XmlFeaturess) "http://apache/xml/.orgs / features nonvalidating load - external", false); l =  new XmlX locactorImpl() ;     
                              } catch {            //Catch the exception if any and print to console for debugging        System.out .println ($ e )    return;  });   xr=null;}       };     try{         h = null :new ContentHandler(){......}@Override public void startDocument()...