import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_36267_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        SAXParserHandler handler = new SAXParserHandler();

        try {
            javax.xml.parsers.SAXParserFactory saxParserFactory = javax.xml.parsers.SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser(xmlFile.toURI().toURL());

            saxParser.setContentHandler(handler);
            saxParser.parse(xmlFile, handler);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler extends DefaultHandler {

    private String lastNodeName;

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        lastNodeName = qName;
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
        lastNodeName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String nodeContent = new String(ch, start, length);
        if (lastNodeName != null) {
            System.out.println("Content of node " + lastNodeName + ": " + nodeContent);
        }
    }
}