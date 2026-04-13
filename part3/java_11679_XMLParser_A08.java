import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_11679_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(new InputSource(new FileInputStream(new File(xmlFile))));
            saxParser.parse(new InputSource(new FileInputStream(new File(xmlFile)) , new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startDocument() {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of Document");
        }

        @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if (qName.equals("person")) {
                    bName = true;
                    bAge = true;
                    System.out.println("Person");
                    return;
                }
                if (bName) {
                    System.out.println("Name : " + localName);
                    bName = false;
                }
                if (bAge) {
                    System.out.println("Age : " + localName);
                    bAge = false;
                }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("person")) {
                bName = false;
                bAge = false;
                System.out.println("End of Person");
                return;
            }
        }
    }
}