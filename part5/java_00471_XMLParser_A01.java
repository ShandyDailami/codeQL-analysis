import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_00471_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private boolean isInElement = false;
    private StringBuilder text = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (!qName.equals("element")) {
            for (int i = 0; i < elementStack.size(); i++) {
                if (elementStack.get(i).equals("element")) {
                    elementStack.remove(i);
                    break;
                }
            }
        } else {
            elementStack.push(qName);
        }
        isInElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            elementStack.pop();
        }
        isInElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            text.append(new String(ch, start, length));
        }
    }

    public String getResult() {
        return text.toString();
    }

    public static void main(String[] args) {
        SecureXmlHandler handler = new SecureXmlHandler();
        javax.xml.parsers.SAXParserFactory factory = javax.xml.parsers.SAXParserFactory.newInstance();
        try {
            javax.xml.parsers.SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("your_xml_file").getResourceAsStream("your_xml_file"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(handler.getResult());
    }
}