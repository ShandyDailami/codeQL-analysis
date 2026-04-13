import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36065_XMLParser_A07 {
    private List<String> values;
    private String currentElement;

    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // path to your xml file
        new XMLParserExample().parse(xmlFile);
    }

    public void parse(String xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(xmlFile, new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    currentElement = qName;
                    values = null;
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    currentElement = null;
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (currentElement != null) {
                        String value = new String(ch, start, length).trim();
                        if (!value.isEmpty()) {
                            if (values == null) {
                                values = new java.util.ArrayList<>();
                            }
                            values.add(value);
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (values != null) {
            for (String value : values) {
                System.out.println(value);
            }
        }
    }

    private class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // your code here
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // your code here
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // your code here
        }
    }
}