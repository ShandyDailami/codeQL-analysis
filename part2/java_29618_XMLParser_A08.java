import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_29618_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();

            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(myHandler);

            saxParser.setEntityResolver(new MyEntityResolver());

            File inputFile = new File("input.xml");
            xmlReader.parse(new SAXSource(new FileReader(inputFile)));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean element;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        element = false;
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element) {
            System.out.println(currentElement + " : " + new String(ch, start, length));
        }
    }
}

class MyEntityResolver extends EntityResolver {
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
        return new InputSource(new StringReader("<error>"+systemId+"</error>"));
    }
}