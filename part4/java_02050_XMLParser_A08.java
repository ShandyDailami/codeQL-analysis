import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_02050_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParser saxParser = new SAXParser();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            saxParser.parse(reader, inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParser {
    public void parse(XMLReader reader, File inputFile) throws IOException, SAXException {
        reader.setContentHandler(new ContentHandler());
        reader.parse(inputFile);
    }
}

class ContentHandler implements javax.xml.parsers.ContentHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}