import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19745_XMLParser_A08 {

    private static final String MD5 = "MD5";
    private static final String MESSAGE_DIGEST = "MessageDigest";
    private static final String FILE = "File";

    public static void main(String[] args) {

        String fileName = "test.xml";
        String filePath = "src/main/resources/" + fileName;

        File file = new File(filePath);

        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            DocumentBuilderFactory dbcf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbcf.newDocumentBuilder();
            SAXParser saxParser = spf.newSAXParser(db.getDocumentBuilder().getFeatures());

            MyHandler handler = new MyHandler();
            saxParser.parse(new FileInputStream(file), handler);

            System.out.println("File Integrity Verified: " + verifyFileIntegrity(file));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean verifyFileIntegrity(File file) {

        if (null == file) {
            return false;
        }

        MessageDigest md;
        byte[] buffer = new byte[8192];
        int bytesNumRead = 0;

        try {
            md = MessageDigest.getInstance(MESSAGE_DIGEST);

            InputStream fis = new FileInputStream(file);

            while ((bytesNumRead = fis.read(buffer)) != -1) {
                md.update(buffer, 0, bytesNumRead);
            }

            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        byte[] digest = md.digest();

        return true;
    }

    private static class MyHandler extends DefaultHandler {

        private boolean isElement = false;
        private String currentElementName = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            isElement = true;
            currentElementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isElement = false;
            currentElementName = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElement) {
                System.out.println("Element: " + currentElementName + ", Text: " + new String(ch, start, length));
            }
        }
    }
}