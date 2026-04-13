import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLEventReader;
import org.xml.sax.parser.XMLEventWriter;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLWriter;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_15997_XMLParser_A01 extends DefaultHandler {
    private String currentElement;
    private List<String> tags;

    public java_15997_XMLParser_A01(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equalsIgnoreCase(tags.get(tags.size()-1))) {
            System.out.println(new String(ch, start, length));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> tags = Arrays.asList("root", "child1", "grandchild");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new InputSource(new File("input.xml")));
            MyXMLHandler myXMLHandler = new MyXMLHandler(tags);
            saxParser.setContentHandler(myXMLHandler);
            saxParser.parse("input.xml", myXMLHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}