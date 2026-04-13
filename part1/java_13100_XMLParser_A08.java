import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13100_XMLParser_A08 {
    private static final String FILE_PATH = "/path/to/your/xml/file"; // replace with your actual file path

    public static void main(String[] args) {
        try {
            File xmlFile = new File(FILE_PATH);
            if (!xmlFile.exists()) {
                throw new SecurityException("File does not exist: " + FILE_PATH);
            }
            if (xmlFile.length() == 0) {
                throw new SecurityException("File is empty: " + FILE_PATH);
           
            }

            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            parser.parse(xmlFile, myHandler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
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
            String value = new String(ch, start, length);
            System.out.println("Character data: " + value);
        }
    }
}