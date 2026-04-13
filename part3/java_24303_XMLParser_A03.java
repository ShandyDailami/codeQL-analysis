import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import sun.security.x509.X509Subject;

public class java_24303_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserHandler handler = new SAXParserHandler();
        javax.xml.parsers.SAXParserFactory factory = javax.xml.parsers.SAXParserFactory.newInstance();
        try {
            org.xml.sax.parsers.SAXParser saxParser = factory.newSAXParser(new File("test.xml"), handler);
            saxParser.parse(new File("test.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class SAXParserHandler extends DefaultHandler {

    private String indent = "";
    private boolean insideLinkElement = false;
    private String linkElementData = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(indent + "<" + qName + ">");
        indent += "    ";

        if ("link".equals(localName)) {
            insideLinkElement = true;
            String link = attributes.getValue("href");
            if (link == null) {
                System.out.println("Missing href in link element");
            } else {
                System.out.println("href=\"" + link + "\"");
            }
        } else {
            insideLinkElement = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (insideLinkElement) {
            System.out.println(indent + "</" + qName + ">");
            indent = indent.substring(0, indent.length() - 2);
            insideLinkElement = false;
        } else {
            System.out.println(indent + "<" + qName + "/>");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (insideLinkElement) {
            linkElementData = new String(ch, start, length);
            System.out.println(indent + "content=\"" + linkElementData + "\"");
        }
    }

}