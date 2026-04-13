import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import java.io.File;
import java.io.IOException;

public class java_09086_XMLParser_A08 {
    private int depth = 0;
    private String lastElement = "";

    public void parse(String fileName) throws IOException, SAXException {
        SAXHelper saxHelper = new SAXHelper() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAIXMLError {
                depth++;
                printElement(localName, attributes);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                depth--;
                printElement(qName);
            }
        };
        saxHelper.parse(new File(fileName));
    }

    private void printElement(String localName, Attributes attributes) {
        printIndentation();
        System.out.println(localName + " (" + attributes + ")");
    }

    private void printElement(String qName) {
        printIndentation();
        System.out.println(qName);
    }

    private void printIndentation() {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        System.out.println(">");
    }

    public static void main(String[] args) throws IOException, SAXException {
        new XMLParser().parse("input.xml");
    }
}