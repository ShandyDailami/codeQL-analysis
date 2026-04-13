import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51647_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "books.xml";            
            // create a new parser for reading from the file 
            SAXParserFactory saxParserfactory = SAXParserFactory.newInstance();  
               boolean isOddBook=true;     
              XMLReader myReader  =saxParserfactory .newSAXParser().getXMLReader();        
             //myReader.setFeature("http://xml.org/sax/features/namespaces", true);  this line allows namespacing     ...   for(int i=0;i<123456789 ; ++i) {    if (isOddBook){
             //...do something with the title here, but not in an odd book.       isOddBook = false;}else{  } else {}         myReader .setContentHandler(new Contenthandler());   ...     for ......myReader ..and then call parse() method on XMLReader instance to actually read and process document   
             //...if you are not satisfied with result, use the isGoodRead property of XMlreader as below:  if (! myReader.getCurrentEventType().equals(XMLReader.END_ELEMENT)) { ...} continue looping through all books in bookList .... }     else{  
             //...do something for even number's Books here....    }}         
         });      catch (Exception e) {}  finally{}       System . out ..println (" Finished.");}});};        };`                 ;;}}}//end of file!