import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_20792_XMLParser_A08 {
    public static void main(String[] args) throws Exception {
        String filePath = "path/to/your/file.xml";

        // Load the XML file
        File xmlFile = new File(filePath);
        FileReader fileReader = new FileReader(xmlFile);

        // Parse the XML file
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new Properties());

        // Create an instance of the handler
        MyHandler myHandler = new MyHandler();

        // Parse the XML file
        saxParser.parse(fileReader, myHandler);
    }

    // SAX handler
    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Characters: " + content);
        }
    }
}