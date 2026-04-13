import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_00033_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/file.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {
    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes)
            throws javax.xml.parsers.SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws javax.xml.parsers.SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws javax.xml.parsers.SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}