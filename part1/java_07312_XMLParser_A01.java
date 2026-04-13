import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07312_XMLParser_A01 {
    private String xPath;
    private String password;
    private String expectedPassword;

    public java_07312_XMLParser_A01(String xPath, String password) {
        this.xPath = xPath;
        this.password = password;
    }

    public void parse() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null);

            saxParser.parse(new File(xPath), new MyHandler(xPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MyHandler extends DefaultHandler {
        private StringBuilder builder;
        private String path;

        public java_07312_XMLParser_A01(String path) {
            this.path = path;
            this.builder = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (path.equals(xPath)) {
                if (attributes.getLength() > 0) {
                    expectedPassword = attributes.getValue("password");
                } else {
                    expectedPassword = "";
                }
            }
            builder.append("<").append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                builder.append(" ").append(attributes.getQName(i)).append("=").append(attributes.getValue(i));
            }
            builder.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            builder.append("</").append(qName).append(">");
       
            if (path.equals(xPath) && verifyPassword()) {
                System.out.println("Access granted");
                return;
            }

            System.out.println(builder.toString());
            path = "";
            builder.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (path.equals(xPath)) {
                builder.append(ch, start, length);
            }
        }

        private boolean verifyPassword() {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] hashPassword = md.digest(password.getBytes());
                byte[] hashExpected = md.digest(expectedPassword.getBytes());
                return Arrays.equals(hashPassword, hashExpected);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}