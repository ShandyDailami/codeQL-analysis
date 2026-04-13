import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_40747_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);
        MyHandler handler = new MyHandler();
        parser.setContentHandler(handler);

        try {
            parser.parse(new File("path_to_your_file.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            if (e.getLineNumber() == handler.getCurrentLineNumber()) {
                System.out.println("Integrity failure detected at line " + e.getLineNumber());
            } else {
                System.out.println("Unexpected SAXException at line " + e.getLineNumber());
            }
        }
    }
}

class MyHandler extends DefaultHandler {
    private int currentLineNumber = -1;

    @Override
    public void startDocument() {
        currentLineNumber = -1;
    }

    @Override
    public void endDocument() {
        // No action required in this case
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
        currentLineNumber++;
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) {
        currentLineNumber++;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentLineNumber++;
    }

    public int getCurrentLineNumber() {
        return currentLineNumber;
    }
}