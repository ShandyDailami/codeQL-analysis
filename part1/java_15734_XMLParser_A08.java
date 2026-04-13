import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;

public class java_15734_XMLParser_A08 {

    private static final String DIGEST_ALGORITHM = "SHA-256";
    private MessageDigest digest;

    public java_15734_XMLParser_A08() {
        try {
            digest = MessageDigest.getInstance(DIGEST_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No algorithm for digest: " + DIGEST_ALGORITHM, e);
        }
    }

    public byte[] getFileDigest(File file) throws Exception {
        try (InputStream in = new FileInputStream(file)) {
            byte[] buffer = new byte[8192];
            int bytesNumRead = 0;
            while ((bytesNumRead = in.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesNumRead);
            }
            return digest.digest();
        }
    }

    public void parse(File file) throws Exception {
        XMLParser parser = org.apache.xerces.jaxp.SAXParserImpl.newInstance();
        parser.setFeature("http://xml.apache.org/xerces/jaxp/validation", true);
        parser.setFeature("http://apache.org/xml/features/nonvalidating/strict", false);
        parser.setFeature("http://xml.apache.org/xerces/jaxp/extensions", true);
        parser.setFeature("http://apache.org/xml/features/default-handler", false);

        SAXErrorHandler errorHandler = new SAXErrorHandler() {
            public void warning(SAXParseException e) {
            }

            public void error(SAXParseException e) {
                throw e;
            }

            public void fatalError(SAXParseException e) {
                throw e;
            }
        };

        parser.setErrorHandler(errorHandler);
        parser.parse(file, new XMLHandler());
    }

    private class XMLHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qualifiedName);
        }

        public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
            System.out.println("End element: " + qualifiedName);
        }
    }

    public static void main(String[] args) {
        try {
            new XMLParserExample().parse(new File("sample.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}