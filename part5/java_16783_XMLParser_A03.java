// import required libraries
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

// SAX Parser Handler
class java_16783_XMLParser_A03 extends DefaultHandler {
    
    private String thisElement;
    private StringBuilder data;

    // Call when start element
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
        data = new StringBuilder();
    }

    // Call when end element
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(thisElement.equalsIgnoreCase("person")) {
            System.out.println("Name: " + data.toString());
        }
    }

    // Call when character data
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}

public class Main {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());

            parser.parse(inputFile, MyHandler.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}