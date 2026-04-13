import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXParserFactory;
import org.xml.sax.parser.XMLParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class java_03441_XMLParser_A01 {

    private static final Map<String, String> PASSWORDS = new HashMap<>();

    static {
        PASSWORDS.put("user1", "password1");
        PASSWORDS.put("user2", "password2");
        PASSWORDS.put("user3", "password3");
    }

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";
        String password = "password_to_access_xml_file";

        if (!isPasswordValid(password)) {
            System.out.println("Access Denied!");
            return;
        }

        try {
            XMLParserExample.parseXML(xmlFilePath);
            System.out.println("Access Granted!");
        } catch (Exception e) {
            System.out.println("Access Denied!");
        }
    }

    private static boolean isPasswordValid(String password) {
        return PASSWORDS.containsKey(password);
    }

    private static void parseXML(String xmlFilePath) {
        XMLParser parser = SAXParserFactory.newInstance().newSAXParser(new MyHandler());
        parser.parse(new File(xmlFilePath));
    }

    private static class MyHandler extends DefaultHandler {

        @Override
        public void error(SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}