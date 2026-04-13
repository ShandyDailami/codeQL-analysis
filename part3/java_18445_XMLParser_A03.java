import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

public class java_18445_XMLParser_A03 {
    private static final String XML_FILE_PATH = "path_to_your_xml_file.xml"; // Replace with your actual XML file path
    private static XMLParser xmlParser;

    public static void main(String[] args) {
        try {
            xmlParser = XMLParser.newInstance();
            xmlParser.setErrorHandler(new MyErrorHandler());
            xmlParser.setContentHandler(new MyContentHandler());
            xmlParser.parse(new File(XML_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyErrorHandler implements XMLErrorHandler {
        @Override
        public void fatalError(org.xml.sax.SAXParseException e) {
            System.out.println("Fatal Error: Line " + e.getLineNumber() + ", " + e.getMessage());
        }

        @Override
        public void warning(org.xml.sax.SAXParseException e) {
            System.out.println("Warning: Line " + e.getLineNumber() + ", " + e.getMessage());
        }

        @Override
        public void error(org.xml.sax.SAXParseException e) {
            System.out.println("Error: Line " + e.getLineNumber() + ", " + e.getMessage());
        }

        @Override
        public void severeWarning(org.xml.sax.SAXParseException e) {
            System.out.println("Severe Warning: Line " + e.getLineNumber() + ", " + e.getMessage());
        }

        @Override
        public void info(org.xml.sax.SAXParseException e) {
            // No info logging for now
        }
    }

    private static class MyContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length).trim();
            if (!content.isEmpty()) {
                System.out.println("Character Data: " + content);
            }
        }
    }
}