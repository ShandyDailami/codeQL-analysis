import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_21361_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // create SAX parser with strict error handling

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuffer buffer = new StringBuffer();
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);

        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
            return;
        }

        if (bName) {
            buffer.append("Name : ");
            bName = false;
        }

        if (bAge) {
            buffer.append("Age : ");
            bAge = false;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (bName) {
            buffer.append(new String(chars, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println(buffer.toString());
            return;
        }

        if (bName) {
            bName = false;
            System.out.print("Name : " + buffer.toString());
        }

        if (bAge) {
            bAge = false;
            System.out.println("Age : " + buffer.toString());
        }
    }
}