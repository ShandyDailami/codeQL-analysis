import java.security.InvalidParameterException;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_21746_XMLParser_A07 {

    public static void main(String[] args) {
        parse("<token>A123456789</token>");
    }

    public static void parse(String xmlString) {
        if (!isValidXml(xmlString)) {
            throw new InvalidParameterException("Invalid XML");
        }

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new StringReader(xmlString), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidXml(String xmlString) {
        try {
            new X509CertificateFactory().generateCertificate(new StringReader(xmlString));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static class MyHandler implements SAXHandler {
        @Override
        public boolean startElement(String uri, String localName, String name,
                SAXAttributes attributes) throws SAXException {
            System.out.println("Start element: " + name);
            return false;
        }

        @Override
        public boolean endElement(String uri, String localName, String name)
                throws SAXException {
            System.out.println("End element: " + name);
            return false;
        }

        @Override
        public boolean characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
            return false;
        }
    }
}