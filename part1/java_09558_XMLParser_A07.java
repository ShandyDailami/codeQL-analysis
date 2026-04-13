import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_09558_XMLParser_A07 extends DefaultHandler {

    private String currentElement;
    private String currentValue;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        currentValue = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equals("authFailure")) {
            checkAuthFailure(currentValue);
        }
    }

    private void checkAuthFailure(String authFailure) {
        // Create a MessageDigest instance for MD5
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // Handle exception
            return;
        }

        // Add password to MessageDigest
        md.update(authFailure.getBytes());

        // Get the hash's bytes 
        byte[] bytes = md.digest();

        // Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        String encryptedPassword = sb.toString();

        // Compare the hashed password with the stored password
        if (encryptedPassword.equals("hashedPassword")) {
            System.out.println("AuthFailure detected!");
        } else {
            System.out.println("AuthFailure not detected!");
        }
    }

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_file.xml");

            // Create a SAXParser factory
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Create a SAXParser
            SAXParser saxParser = factory.newSAXParser(new FileInputStream(xmlFile));

            // Parse XML file
            saxParser.setContentHandler(new MyXMLParser());
            saxParser.parse(new File(xmlFile.getAbsolutePath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}