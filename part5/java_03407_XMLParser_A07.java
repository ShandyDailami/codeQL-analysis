import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_03407_XMLParser_A07 {
    private static final String PASSWORD_FILE = "password.txt";
    private static final String PASSWORD_FILE_PATH = "/path/to/password/file";

    public static void main(String[] args) {
        File passwordFile = new File(PASSWORD_FILE_PATH);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            saxParser.parse(passwordFile, new PasswordHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class PasswordHandler extends DefaultHandler {
        private String password;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            if (qName.equals("password")) {
                password = attributes.getValue("password");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (!password.equals(getPasswordFromFile())) {
                throw new SAXException("Incorrect password!");
            }
        }

        private String getPasswordFromFile() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter password:");
            return scanner.nextLine();
        }
    }
}