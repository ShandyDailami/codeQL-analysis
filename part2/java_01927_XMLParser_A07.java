import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_01927_XMLParser_A07 {

    public static void main(String[] args) throws ParserConfigurationException {
        String filePath = "path/to/xml/file.xml";
        parseFile(filePath);
    }

    public static void parseFile(String filePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(new InputSource(new File(filePath)));

            // Using SAX handler to handle errors
            MyHandler handler = new MyHandler();
            parser.parse(new InputSource(new File(filePath)), handler);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Parsing error: " + e.getMessage());
        }
    }

    private static class MyHandler extends DefaultHandler {
        @Override
        public void error(SAXException e) {
            System.out.println("Authentication failure: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal authentication failure: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) {
            System.out.println("Warning during authentication: " + e.getMessage());
        }
    }
}