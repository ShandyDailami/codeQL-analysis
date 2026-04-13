import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_07801_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/sample.xml";
        parseFile(xmlFile);
    }

    private static void parseFile(String xmlFile) {
        try {
            XMLReader reader = XMLReader.newInstance();
            FileInputStream fis = new FileInputStream(xmlFile);
            SAXParser saxParser = SAXParser.newInstance();
            XMLReaderHandler handler = new XMLReaderHandler(saxParser.getSAXParser());

            reader.setContentHandler(handler);
            reader.parse(new InputSource(fis));

            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class XMLReaderHandler implements ContentHandler {
    private SAXParser saxParser;

    public java_07801_XMLParser_A03(SAXParser saxParser) {
        this.saxParser = saxParser;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        str = str.replace("\n", "").trim();

        if (str.length() > 0) {
            System.out.println("Characters: " + str);
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length).trim();

        if (str.length() > 0) {
            System.out.println("Ignorable Whitespace: " + str);
        }
    }
}