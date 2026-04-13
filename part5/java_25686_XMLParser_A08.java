import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXParseException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_25686_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);

            saxParser.setEntityResolver(new MyEntityResolver());

            xmlReader.parse(new File("sample.xml")); // replace with your xml file

            for (String element : myHandler.getElements()) {
                System.out.println(element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private List<String> elements = new ArrayList<>();

    public List<String> getElements() {
        return elements;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elements.add(qName);
    }
}

class MyEntityResolver extends DefaultEntityResolver {
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXParseException {
        // This method is used to handle security sensitive operations related to A08_IntegrityFailure
        // You can add your code here to handle these operations
        // For instance, you can add a check to see if the systemId is null or not
        if (systemId == null) {
            throw new SAXParseException("Null System ID");
        }

        // You can also add your code here to handle other security sensitive operations
        // For instance, you can add a check to see if the publicId is null or not
        if (publicId == null) {
            throw new SAXParseException("Null Public ID");
        }

        // If everything is fine, return null
        return null;
    }
}