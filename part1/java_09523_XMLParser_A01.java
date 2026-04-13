import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_09523_XMLParser_A01 {
    private Stack<String> elementStack = new Stack<>();

    public void parse(String xml) {
        SAXHandler handler = new SAXHandler();
        try {
            org.xml.sax.SAXParserFactory spf = org.xml.sax.SAXParserFactory.newInstance();
            org.xml.sax.SAXParser saxParser = spf.newSAXParser(null);
            saxParser.parse(xml, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class SAXHandler extends DefaultHandler {
        private boolean element = false;
        private StringBuilder sb = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            element = true;
            sb.setLength(0);
            elementStack.push(qName);
            printXmlElement(qName, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            elementStack.pop();
            if (element) {
                printXmlElement(qName, null);
                element = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (element) {
                sb.append(ch, start, length);
            }
        }

        private void printXmlElement(String qName, Attributes attributes) {
            for (int i = 0; i < elementStack.size(); i++) {
                System.out.print(elementStack.elementAt(i) + (i < elementStack.size() ? " > " : ""));
            }
            System.out.println(qName + (attributes != null ? " (" + attributes.getValue("name") + ")" : ""));
            if (attributes != null) {
                System.out.print("Attributes: ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println(attributes.getLocalName(i) + "=" + attributes.getValue(i));
                }
            }
            System.out.println("Content: " + sb.toString());
        }
    }
}