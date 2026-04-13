import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_01857_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<person>\n" +
                "  <name>John</name>\n" +
                "  <age>30</age>\n" +
                "</person>";
        XMLReader xr = SAXParser.newInstance().getXMLReader();
        MyHandler handler = new MyHandler();
        xr.setContentHandler(handler);
        xr.parse("data.xml", new StringSource(xml));
        System.out.println(handler.getResult());
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder content;

        @Override
        public void startDocument() {
            content = new StringBuilder();
        }

        @Override
        public void endDocument() {
            System.out.println(content.toString());
        }

        @Override
        public void startElement(String uri, String localName, String qName)
                throws SAXException {
            content.append(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            content.append("</").append(qName).append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            content.append(new String(ch, start, length));
        }

        String getResult() {
            return content.toString();
        }
    }
}