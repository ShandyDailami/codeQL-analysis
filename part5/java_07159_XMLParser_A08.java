import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;

import java.io.File;
import java.io.IOException;

public class java_07159_XMLParser_A08 extends DefaultHandler {
    private String lastElementLocalName;

    public java_07159_XMLParser_A08() {
        super();
    }

    public static void main(String[] args) {
        SAXParser saxParser = SAXParser.newInstance();
        File inputFile = new File("input.xml");

        XMLParserExample handler = new XMLParserExample();
        try {
            saxParser.setContentHandler(handler);
            saxParser.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        super.startElement(uri, localName, qName, attributes);
        lastElementLocalName = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (localName.equals(lastElementLocalName)) {
            System.out.println("End of " + localName);
            lastElementLocalName = null;
        }
    }
}