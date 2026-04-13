import java.io.FileInputStream;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_30198_XMLParser_A03 extends DefaultHandler {

    private boolean isInElement = false;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInElement = true;
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            String content = new String(ch, start, length).trim();
            if (!content.isEmpty()) {
                // Here you can add your security-sensitive operation, e.g., injection
                // If the content contains a pattern related to injection, throw an exception
                if (Pattern.matches(".*\\b(injection)\\b.*", content)) {
                    throw new IllegalArgumentException("Injection detected in XML content");
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
        currentElement = null;
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(true);

            InputStream inputStream = new FileInputStream("sample.xml");

            MyXMLParser myXMLParser = new MyXMLParser();
            saxParser.parse(inputStream, myXMLParser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}