import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_35500_XMLParser_A03 {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.xml";
        parseFile(filePath);
    }

    public static void parseFile(String filePath) {
        File file = new File(filePath);

        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(file, myHandler);
        } catch (SAXParseException e) {
            System.out.println("Parsing error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        }
    }

    private static class MyHandler extends DefaultHandler {
        private static final StringBuilder stringBuilder = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            stringBuilder.setLength(0);
            stringBuilder.append("Start element: ");
            stringBuilder.append(qName);
            System.out.println(stringBuilder.toString());
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stringBuilder.setLength(0);
            stringBuilder.append("End element: ");
            stringBuilder.append(qName);
            System.out.println(stringBuilder.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            stringBuilder.setLength(0);
            stringBuilder.append("Characters: ");
            stringBuilder.append(new String(ch, start, length));
            System.out.println(stringBuilder.toString());
        }
    }
}