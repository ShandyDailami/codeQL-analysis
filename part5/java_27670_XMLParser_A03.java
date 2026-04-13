import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_27670_XMLParser_A03 extends DefaultHandler {
    private String currentElement = "";
    private Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/test.xml");

        try {
            XMLParser parser = XMLParserFactory.fromFile(xmlFile);
            MyXMLParser handler = new MyXMLParser();
            parser.setContentHandler(handler);
            parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        stack.push(currentElement);
        printIndentation();
        System.out.println("Start of " + currentElement);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        currentElement = qName;
        stack.pop();
        printIndentation();
        System.out.println("End of " + currentElement);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String elementContent = new String(ch, start, length).trim();
        if (!elementContent.isEmpty()) {
            printIndentation();
            System.out.println("Content: " + elementContent);
        }
    }

    private void printIndentation() {
        for (int i = 0; i < stack.size(); i++) {
            System.out.print("    ");
        }
    }
}