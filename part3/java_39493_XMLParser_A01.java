import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_39493_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();

        MyHandler myHandler = new MyHandler();
        xmlReader.setContentHandler(myHandler);

        try {
            xmlReader.parse(new File("input.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        }

        System.out.println("Name(s): " + myHandler.getNames());
    }
}

class MyHandler implements javax.xml.parsers.ContentHandler {
    private StringBuilder builder;
    private boolean bName;
    private boolean bContent;
    private StringBuilder nameBuilder;
    private StringBuilder contentBuilder;
    private String name;

    public java_39493_XMLParser_A01() {
        builder = new StringBuilder();
        bName = false;
        bContent = false;
        nameBuilder = new StringBuilder();
        contentBuilder = new StringBuilder();
    }

    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            bName = true;
            nameBuilder = new StringBuilder();
        } else if (qName.equals("content")) {
            bContent = true;
            contentBuilder = new StringBuilder();
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            name = nameBuilder.toString();
            bName = false;
        } else if (qName.equals("content")) {
            bContent = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            nameBuilder.append(ch, start, length);
        } else if (bContent) {
            contentBuilder.append(ch, start, length);
        }
    }

    public String getNames() {
        return name;
    }
}