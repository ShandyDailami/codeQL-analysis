import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_19941_XMLParser_A03 {
    private Stack<String> stack = new Stack<>();

    public void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null);
        MyHandler handler = new MyHandler();
        saxParser.parse(xml, handler);
    }

    private class MyHandler extends DefaultHandler {
        private StringBuilder buffer = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            stack.push(qName);
            buffer.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
            buffer.append("<").append(qName);
            String[] attrs = localName.split("(?<=\\w{1})(?=UnwantedFragment$)", -1);
            for (String attr : attrs) {
                String name = attr.substring(attr.lastIndexOf(':') + 1);
                String value = attr.substring(attr.indexOf(':') + 1);
                buffer.append(" ").append(name).append("=\"").append(value).append("\"");
            }
            buffer.append(">").append(buffer.length() > 0 ? buffer.substring(0, buffer.length() - 1) : "").append("</").append(qName).append(">");
            System.out.println(buffer.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(ch, start, length);
        }
    }
}