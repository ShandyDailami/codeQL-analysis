import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_09227_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        buffer.append("End of ");
        buffer.append(qName);
        System.out.println(buffer.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    public static void main(String[] args) {
        String xml = "<root><element1>Content1</element1><element2>Content2</element2></root>";
        XMLParser parser = new XMLParser();
        org.xml.sax.SAXParserFactory saxFactory = org.xml.sax.SAXParserFactory.newInstance();
        try {
            org.xml.sax.SAXParser saxParser = saxFactory.newSAXParser(true);
            saxParser.parse(new StringReader(xml), parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}