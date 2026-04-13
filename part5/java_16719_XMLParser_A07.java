import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParser;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_16719_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // replace with your xml file
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null);

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SAXHandler handler = new SAXHandler();
            saxParser.parse(new File(xmlFile), handler);
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new File(xmlFile));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {

    private boolean elementName = false;
    private boolean elementContent = false;
    private StringBuilder content;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        elementName = true;
        content = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementName) {
            content.append(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        elementName = false;
        System.out.println(qName + ": " + content.toString());
    }
}