import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11961_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            saxParser.parse(new File("data.xml"), handler);

            System.out.println("Parsing completed successfully.");

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private int depth;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        depth++;
        printIndentation(depth);
        System.out.println("Start of " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        depth--;
        printIndentation(depth);
        System.out.println("End of " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        printIndentation(depth);
        System.out.println(new String(ch, start, length));
    }

    private void printIndentation(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }
}