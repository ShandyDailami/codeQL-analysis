import java.io.File;
import java.io.IOException;
import java.security.CodeSignature;
import java.security.Permission;
import java.security.Policy;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_31548_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new Policy() {
            public Permission getPermission(CodeSignature codeSignature) {
                return null;
            }
        });

        DefaultHandler defaultHandler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length)
                    throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        File inputFile = new File("sample.xml");
        try {
            saxParser.parse(inputFile, defaultHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}