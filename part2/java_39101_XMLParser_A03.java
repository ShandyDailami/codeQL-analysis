import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.xmlreader.XMLReader;
import org.xml.sax.xmlreader.XMLEventReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class java_39101_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            URL url = new File("sample.xml").toURI().toURL();
            XMLEventReader xmlr = SAXHelper.createXMLEventReader(url, 10000);

            SAXHandler handler = new SAXHandler();
            XMLParser parser = SAXHelper.getSAXParser(xmlr, handler, 10000);

            System.out.println("Parsing XML file...");
            parser.parse(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private int currentDepth = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
        currentDepth++;
        printIndentation(currentDepth);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        currentDepth--;
        printIndentation(currentDepth);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentDepth == 1) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    private void printIndentation(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }
}

class SAXHelper {
    public static XMLEventReader createXMLEventReader(URL url, int bufferSize) throws Exception {
        InputStream in = new FileInputStream(new File("sample.xml"));
        return SAXHelper.createXMLEventReader(in, bufferSize);
    }

    public static XMLEventReader createXMLEventReader(InputStream in, int bufferSize) {
        return SAXHelper.createXMLEventReader(new XMLEventReader(new InputStreamReader(in, "UTF-8"), bufferSize);
    }

    public static XMLParser getSAXParser(XMLEventReader reader, DefaultHandler handler, int bufferSize) {
        return SAXParserFactory.newSAXParser(reader, handler, bufferSize);
    }
}