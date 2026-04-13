import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40103_XMLParser_A08 extends DefaultHandler {
    boolean bElement = false;
    String strElement = "";
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bElement = true;
        strElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bElement)
            strElement += new String(ch, start, length);
    }
}

public class MySAXParser {
    public static void main(String[] args) {
        File inputFile = new File("sample.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(inputFile, MyHandler.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}