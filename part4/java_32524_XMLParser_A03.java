import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_32524_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "path/to/your/xml/file.xml";  // replace with your actual file path

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();
            saxParser.setContentHandler(myHandler);

            xmlReader.setContentHandler(myHandler);

            xmlReader.parse(new File(xmlFile));

            System.out.println(myHandler.getParsedData());

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends javax.xml.parsers.SAXHandler {
    private StringBuilder parsedData;

    public java_32524_XMLParser_A03() {
        parsedData = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        parsedData.append("<").append(localName);

        // add attributes if any
        for (int i = 0; i < attributes.getLength(); i++) {
            parsedData.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
        }

        parsedData.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        parsedData.append("</").append(localName).append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        parsedData.append(new String(ch, start, length));
    }

    public StringBuilder getParsedData() {
        return parsedData;
    }
}