import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_39778_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Step 1: Create an InputStream from a file
            InputStream inputStream = new FileInputStream("example.xml");

            // Step 2: Create a SAXParser using SAXParserFactory
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Step 3: Create an instance of the handler and feed it to the parser
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputStream, myHandler);

            // Clean up
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class MyHandler implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes)
            throws javax.xml.parsers.SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws javax.xml.parsers.SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

}