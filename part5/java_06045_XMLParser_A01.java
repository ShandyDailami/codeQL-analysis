import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLValidator;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_06045_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        SAXParserImpl saxParser = new SAXParserImpl();

        try {
            XMLReader xmlReader = saxParser.getSAXParser().getReader();
            xmlReader.setContentHandler(saxParser);
            xmlReader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserImpl extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!elementStack.isEmpty()) {
            String elementName = elementStack.peek();
            System.out.println(elementName);
        }
    }

    public XMLParser getSAXParser() {
        return XMLParser.newInstance();
    }
}