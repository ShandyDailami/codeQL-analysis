import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_51008_XMLParser_A08 {  
    public static void main(String args[]) throws ParserConfigurationException, SAXException{    
        String url = "http://example/path"; //Replace with your URL here 
         try {     
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();      
             XMLReader reader=factory.newSAXReader();         
              Handler handler  = new Handler() ;  
               Reader rd=null;    
                try{   
                    URL u = new URL(url);  //Replace with your url here     
                     rd=  new InputStreamReader(u.openStream());        }catch (Exception e){          System.out.println("Failed to load the data!"+e );   return;}}         reader .setContentHandler((SAXHandler) handler ) ;    
                   try {  // Parse XML from a URL or File in memory     
                      DocumentBuilder db=factory.newDocumentBuilder();      
                       Document doc =db.parse(rd);          }catch (Exception e){              System.out.println("Failed to parse the data!"+e );   return;}}     reader .setContentHandler((SAXHandler) handler ) ;  // Parse XML from a URL or File in memory      
        }} catch (Exception ex) {System.err.println(ex);}    }//End of Main Method      private static class SAXHandler extends DefaultHandler{   @Override public void startElement     (?xmlcharset*?, ?_namespace_URI_,?name_) throws SAXException {}@ Overridepublicvoidendelement()throwsSAXexception {}}