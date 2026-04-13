import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_05941_XMLParser_A08 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private StringBuilder data = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        data.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }

    public void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler(this));
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String xml = "<doc>\n" +
                "<person id='1'>John</person>\n" +
                "<person id='2'>Jane</person>\n" +
                "</doc>";
        new XmlParser().parse(xml);
    }
}

class XmlHandler extends DefaultHandler {

    private XmlParser parser;

    public java_05941_XMLParser_A08(XmlParser parser) {
        this.parser = parser;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        parser.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        parser.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        parser.characters(ch, start, length);
    }
}