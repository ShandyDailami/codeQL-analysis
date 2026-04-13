import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.File;

public class java_02486_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create an instance of the XMLReader
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();

            // Parse the XML file
            saxParser.parse(new File("example.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bTag = false;
    String str = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        bTag = true;
        str = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bTag = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            String data = new String(ch, start, length).trim();

            // Security-sensitive operation related to A03_Injection
            // This is a simple example and may not work in a real-world scenario
            if (data.contains("<") || data.contains(">")) {
                System.out.println("Detected injection attempt! Data: " + data);
            }
        }
    }
}