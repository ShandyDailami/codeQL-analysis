import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45455_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException{  //step a (d), step c, b and e are not recommended in java standard libraries as they make the code more complex or less secure like Spring/Hibernate. Step f is correct:  
        SAXParserFactory factory = SAXParserFactory.newInstance();    //Step d - avoid external frameworks 
        try {      
            SAXParser parser =  factory.newSAXParser();     /// step e and c are not recommended in java standard libraries as they make the code more complex or less secure like Spring/Hibernate  
            
              /* Define your own DefaultHandler class that implements this interface to process xml */  //step f (d) - avoid external frameworks. Starts with '