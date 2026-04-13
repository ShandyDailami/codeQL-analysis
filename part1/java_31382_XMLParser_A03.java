import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_31382_XMLParser_A03 extends DefaultHandler {

    private List<String> nodes = new ArrayList<>();
    private String currentNode;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentNode = qName;
        nodes.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentNode = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentNode != null) {
            String content = new String(ch, start, length).trim();
            if (!content.isEmpty()) {
                nodes.add(content);
            }
        }
    }

    public static void main(String[] args) {
        String xmlFile = "example.xml";  // replace with your xml file
        MyXMLHandler handler = new MyXMLHandler();

        try {
            XMLParser parser = XMLReader.newSAXParser(new File(xmlFile));
            parser.setContentHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}