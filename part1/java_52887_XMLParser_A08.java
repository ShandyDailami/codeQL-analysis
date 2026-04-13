import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52887_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url = "file:///path_to_yourFile";  // Provide your file path here        
      
            getXmlContent(url);          
      }             
            
private static void getXmlContent (String inputUrl) {   
          try   {                  
               SAXParserFactory spfactory = SAXParserFactory.newInstance();    
               SAXParser saxparser=spfactory.newSAXParser();       
                MyContentHandler mchandler=  new  MyContentHandler();       //Declare the content handler   
                 
              InputSource source  =null;  
            
                 if(inputUrl != null && inputUrl.length() > 0){         
                      XMLReader myreader =saxparser .getXMLReader();     
                       source =  new FileInputStreamSource (new File  (inputUrl));        //File Source      
                  }    else {          
                         System.out.println("Invalid URL");   return;            
                 }    
              saxparser.setContentHandler(mchandler);          if (!myreader .getUseCircularParse())      myreader  .setFeature("http://xmlpull.org/v1/doc/features/external-general", true );    else        myreader .setFeature("http://apache.org/xml/features/nonvalidating/strict", false);         
               saxparser   .parse( source ) ;     }            catch (FileNotFoundException e) {       System.out.println ("Xml file not found :" +e );    return;  }, Exception{        //Error handling in the parsing process                  println("XML Parsing Failed");         
               if ((parser != null)) parser .setContentHandler(null);   }                      catch (ParserConfigurationException e) {      System.out.println ("Failed to create SAX Parser :" +e ); return;}}  finally{       //Closing the file resource             try     {if((inputUrl!= 
        null)) source .getFile().close();}catch(IOException e){System out . println("Error in closing File:"+ e);}}}      }