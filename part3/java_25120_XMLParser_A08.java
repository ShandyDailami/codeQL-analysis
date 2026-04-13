import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_25120_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            String inputFilePath = "/path/to/your/xml/file.xml"; // replace this with your actual file path
            InputStream inputStream = new FileInputStream(inputFilePath);

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyContentHandler contentHandler = new MyContentHandler();
            saxParser.parse(inputStream, contentHandler);

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends javax.xml.parsers.ContentHandler {

        private StringBuffer buffer = new StringBuffer();

        @Override
        public void startDocument() {
            buffer.setLength(0);
        }

        @Override
        public void endDocument() {
            System.out.println(buffer.toString());
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                javax.xml.parsers.Attributes attributes) {
            buffer.append("<");
            buffer.append(qName);
            buffer.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            buffer.append(buffer.subSequence(buffer.length() - 2, buffer.length() - 1));
            buffer.append("</");
            buffer.append(qName);
            buffer.append(">");
        }

        @Override
        public void characters(String characters, int start, int length) {
            buffer.append(characters);
        }
    }
}