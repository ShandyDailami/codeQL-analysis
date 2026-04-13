import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_20402_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(inputFile, new MyHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder sb;
    private int depth;

    MyHandler() {
        this.sb = new StringBuilder();
        this.depth = 0;
    }

    @Override
    public void startDocument() {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        depth++;
        printIndentation();
        System.out.println(qName);
        sb.append("Start of " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        depth--;
        printIndentation();
        System.out.println("End of " + qName);
        sb.append("End of " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        printIndentation();
        sb.append(ch, start, length);
    }

    private void printIndentation() {
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        throw e;
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void endPrefixMapping(String prefix, String uri) throws SAXException {
        throw new UnsupportedOperationException();
    }
}