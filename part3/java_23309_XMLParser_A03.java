import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_23309_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // create SAXParser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // create InputStream
            InputStream inputStream = new FileInputStream("sample.xml");

            // parse the XML file
            saxParser.parse(inputStream, new XMLHandler());

            // close the inputStream
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}