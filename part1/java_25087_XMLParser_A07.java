import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_25087_XMLParser_A07 extends DefaultHandler {

    private String lastElementLocalName = null;
    private String lastElementValue = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElementLocalName = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals(lastElementLocalName)) {
            System.out.println("End element: " + localName);
            lastElementLocalName = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElementLocalName != null) {
            lastElementValue = new String(ch, start, length);
            System.out.println("Character data: " + lastElementValue);
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/main/resources/example.xml");
            SAXReader reader = XMLReaderFactory.createSAXReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(inputFile);
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}