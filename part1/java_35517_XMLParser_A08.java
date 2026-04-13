import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_35517_XMLParser_A08 {
    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            } else if (bName && qName.equals("name")) {
                bName = false;
            } else if (bName && qName.equals("age")) {
                bAge = false;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                if (!bName || !bAge) {
                    System.out.println("Invalid XML: missing name or age!");
                }
                bName = false;
                bAge = false;
            }
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());

            FileInputStream fis = new FileInputStream("src/main/resources/sample.xml");
            parser.parse(fis, null);
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}