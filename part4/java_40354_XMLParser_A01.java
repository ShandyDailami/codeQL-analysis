import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_40354_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            FileInputStream fis = new FileInputStream(inputFile);

            SAXHandler handler = new SAXHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(fis);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a password:");
            String password = scanner.nextLine();

            // Check if password is correct
            if (password.equals("correctPassword")) {
                System.out.println("Access granted.");
            } else {
                System.out.println("Access denied.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (SAXException e) {
            System.out.println("SAX Exception: " + e.getMessage());
        }
    }

    private static class SAXHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                org.xml.sax.Attributes attributes) throws SAXException {
            // Do not process elements
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // Do not process elements
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Do not process characters
        }
    }
}