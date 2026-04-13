import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_22537_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            InputStream inputStream = new FileInputStream("path/to/your/xml/file.xml");
            MyHandler myHandler = new MyHandler();

            saxParser.parse(inputStream, myHandler);

            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.ContentHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length).trim();
        if(content.length() > 0) {
            System.out.println("Character Content: " + content);
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        System.out.println("Start Prefix Mapping: " + prefix + ", URI: " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix, String uri) {
        System.out.println("End Prefix Mapping: " + prefix + ", URI: " + uri);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) {
        String content = new String(ch, start, length);
        System.out.println("Ignorable Whitespace: " + content);
    }

    @Override
    public void processingInstruction(String target, String data) {
        System.out.println("Processing Instruction: " + target + ", Data: " + data);
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        System.out.println("Set Document Locator: " + locator.toString());
    }
}