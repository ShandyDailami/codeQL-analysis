import java.security.Permission;
import java.security.SecurityPermission;
import java.util.Iterator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_22561_XMLParser_A08 extends DefaultHandler {

    private boolean bName;
    private boolean bAge;
    private String currentElement;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        bName = true;
        bAge = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bName){
            String value = new String(ch, start, length);
            if(currentElement.equals("Name")){
                // process name here, e.g., add to a list or check for integrity
            }else if(currentElement.equals("Age")){
                int age = Integer.parseInt(value);
                // process age here, e.g., add to a list or check for integrity
            }
            bName = false;
        }else if(bAge){
            int age = Integer.parseInt(new String(ch, start, length));
            // process age here, e.g., add to a list or check for integrity
            bAge = false;
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyXMLParser myXMLParser = new MyXMLParser();
            saxParser.parse(Class.forName("org.xml.samples.Books").getResourceAsStream("books.xml"), myXMLParser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}