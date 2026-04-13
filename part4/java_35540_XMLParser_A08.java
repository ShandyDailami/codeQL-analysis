import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_35540_XMLParser_A08 {

    private String referenceMD5;

    public java_35540_XMLParser_A08(String referenceFile) {
        try {
            File file = new File(referenceFile);
            MessageDigest md = MessageDigest.getInstance("MD5");
            InputStream fis = new FileInputStream(file);

            byte[] buffer = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = fis.read(buffer)) != -1) {
                md.update(buffer, 0, numBytesRead);
            }
            fis.close();

            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
            }
            referenceMD5 = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validateXML(String xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null);
            XmlHandler handler = new XmlHandler();
            saxParser.parse(xmlFile, handler);
            return handler.isValid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private class XmlHandler extends DefaultHandler {

        private boolean isValid = true;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // No operation here
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // No operation here
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // No operation here
        }

        public void setValid(boolean valid) {
            isValid = valid;
        }

        public boolean isValid() {
            return isValid;
        }
    }
}