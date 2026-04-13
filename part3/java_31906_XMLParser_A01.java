import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_31906_XMLParser_A01 extends DefaultHandler {
    private String lastTag;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastTag = qName;
        System.out.println("Start of element " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (lastTag != null) {
            System.out.println("Character data in " + lastTag + ": "
                    + new String(ch, start, length));
            lastTag = null;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End of element " + qName);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyXMLHandler());

            // parse the XML file
            File inputFile = new File("input.xml");
            parser.parse(inputFile, MyXMLHandler.class);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}