import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_15281_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
        parse(xml);
    }

    public static void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler(xml));
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {
        private StringBuilder builder;
        private boolean inElement;
        private String currentElement;

        public java_15281_XMLParser_A03(String xml) {
            this.builder = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            this.currentElement = qName;
            this.inElement = true;
            this.builder.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (this.currentElement != null && this.currentElement.equals(qName)) {
                this.inElement = false;
                this.currentElement = null;
            }

            if (this.inElement) {
                System.out.println(this.builder.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (this.inElement) {
                this.builder.append(ch, start, length);
            }
        }
    }
}