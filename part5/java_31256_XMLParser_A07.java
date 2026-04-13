import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XercesSAXParser;
import org.xml.sax.parser.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class java_31256_XMLParser_A07 {
    public static void main(String[] args) {
        String inputFile = "input.xml"; // Your XML input file

        // Create a new SAX parser
        SAXParserHandler handler = new SAXParserHandler();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new File(inputFile), handler);

        // Parse the XML file
        try {
            saxParser.parse(new File(inputFile));
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler extends DefaultHandler {
    private int depth = 0;

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
        printIndentation(depth);
        System.out.println("Start of element: " + qName);
        depth++;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        depth--;
        printIndentation(depth);
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        printIndentation(depth);
        System.out.println("Characters: " + new String(ch, start, length));
    }

    private void printIndentation(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
    }
}