import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_34898_XMLParser_A01 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currElement = "";
    private int currDepth = 0;

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        parser.parse(new File("src/sample.xml"));
    }

    public void parse(File file) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
            reader.parse(file.toURI().toString());
        } catch (IOException | SAXParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currElement = qName;
        bName = true;
        bAge = true;
        currDepth++;
        printIndentation(currDepth);
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        currElement = qName;
        currDepth--;
        printIndentation(currDepth);
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }

    private void printIndentation(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }
}