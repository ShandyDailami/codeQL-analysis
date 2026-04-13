import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_40140_XMLParser_A03 extends DefaultHandler {
    private static final String NS_PREFIX = "ns";
    private static final String NS_URI = "http://www.w3.org/2001/XMLSchema-instance";
    private static final String INPUT_XML = "input.xml";
    private static final String OUTPUT_XML = "output.xml";

    private Stack<String> elementStack;
    private StringBuilder elementContent;
    private boolean bInput;

    public java_40140_XMLParser_A03() {
        elementStack = new Stack<>();
        elementContent = new StringBuilder();
        bInput = false;
    }

    public void parse() {
        // Parse the XML file using the SAX parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(false);
        factory.setXIncludeAware(false);
        SAXParser saxParser = factory.newSAXParser(null);
        saxParser.parse(INPUT_XML, this);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        elementContent.setLength(0);
        bInput = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        if (bInput) {
            bInput = false;
            return;
        }
        // Process the element here. You can use a SAXParser to generate the output XML file.
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bInput) {
            elementContent.append(ch, start, length);
        }
    }
}