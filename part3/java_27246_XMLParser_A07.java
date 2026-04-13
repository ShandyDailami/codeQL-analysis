import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_27246_XMLParser_A07 {
    private DefaultHandler defaultHandler;
    private boolean bElement;
    private String currentData;

    public java_27246_XMLParser_A07() {
        defaultHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                bElement = true;
                currentData = "";
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (bElement) {
                    currentData = new String(ch, start, length);
                    bElement = false;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                // Handle end element
                // For example, print the data
                System.out.println(qName + ": " + currentData);
            }
        };
    }

    public void parse(String xml) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, defaultHandler);
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String xml = "<root><element>data1</element><element>data2</element></root>";
        new XMLParser().parse(xml);
    }
}