import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
public class java_44734_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        // Create a new factory instance  
        SAXParserFactory spf = SAXParserFactory.newInstance();     
         try (SAXParser saxp = spf.newSAXParser()) {         
            MyHandler myhandler  = new MyHandler() ;   
             /* parse the xml file */    
              saxp.parse("testXMLfile2016_modified-draftsman+alexaforums.xml",myhandler);  }   catch (ParserConfigurationException | SAXException e){          //Catch any configuration or parsing errors    return;      }}    
 class MyHandler extends DefaultHandler {           @Override public void startDocument(DocumentIndicator di)             System.out.println("XML Start Document");       break ;              case "book":                   super.startElement ("", "", “book”, attributes);          // Opening tag book has been encountered         return;