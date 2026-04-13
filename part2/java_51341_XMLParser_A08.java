import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51341_XMLParser_A08 {  
    public static void main(String[] args){    
        try{      
            SAXParserFactory saxpfactory=SAXParserFactory.newInstance();     
            
              // Create a new instance of the parser 
               SAXParser saxparser =saxpfactory.newSAXParser(true);  
                
                MyHandler myhandler  = new MyHandler ( );      
                 
                    // Parse an XML file and invoke handler methods for each element, attribute or text node .   
                   saxparser.parse("src/test.xml",myhandler) ;     }      catch(Exception e){          System.out.println ("Error: "+e);   }}  Exception handling is used to capture errors in the code.. For instance if an xml file cannot be found then it will print a message error on console which can handle this at run-time and not hardcoded anywhere else .