import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_33848_XMLParser_A07 {

    public static void main(String[] args) {
        parseXML("input.xml");
    }

    public static void parseXML(String inputFile) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        EntityResolver entityResolver = new MyEntityResolver();
        saxParserFactory.setEntityResolver(entityResolver);

        try (SAXParser saxParser = saxParserFactory.newSAXParser(true)) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);
            xmlReader.parse(new File(inputFile));

            System.out.println("XML Parsed Successfully!");
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            // TODO: Implement your security-sensitive operations
        }
    }

    static class MyEntityResolver implements EntityResolver {

        @Override
        public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
            // TODO: Implement your security-sensitive operations
            return null;
        }
    }
}