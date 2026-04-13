import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_12028_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");  // Change this to your XML file

        if (!xmlFile.exists() || xmlFile.isDirectory()) {
            System.out.println("Invalid or no XML file provided.");
            System.exit(1);
        }

        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            SAXParser sp = spf.newSAXParser(null);
            MyHandler mh = new MyHandler();

            XMLReader xr = sp.getXMLReader();

            xr.setContentHandler(mh);
            xr.parse(xmlFile.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {

        boolean nameFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                nameFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (nameFound) {
                System.out.println("Name found!");
                nameFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (nameFound) {
                System.out.println(new String(ch, start, length));
            }
        }
    }
}