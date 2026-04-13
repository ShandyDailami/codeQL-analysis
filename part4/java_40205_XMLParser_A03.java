import java.io.FileInputStream;
import java.io.InputStream;
import java.xml.XMLConstants;
import java.xml.парсери;

public class java_40205_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            String xmlFile = "/path/to/your/xml/file.xml";
            parseXMLFile(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXMLFile(String xmlFile) throws Exception {
        InputStream inputStream = new FileInputStream(xmlFile);
        parseXMLContent(inputStream);
    }

    public static void parseXMLContent(InputStream inputStream) throws Exception {
        XMLParser parser = new XMLParser();
        parser.parse(inputStream);
    }

    public void parse(InputStream inputStream) throws Exception {
        try {
            XMLParserFactory factory = XMLParserFactory.newInstance();
            XMLParser xmlParser = factory.newParser();

            xmlParser.setContentHandler(new MyContentHandler());

            xmlParser.parse(new InputSource(inputStream));
        } finally {
            inputStream.close();
        }
    }

    private static class MyContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}