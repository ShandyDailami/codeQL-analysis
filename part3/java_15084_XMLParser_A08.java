import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_15084_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "your_xml_file.xml";
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(String xmlFile) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(xmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        XMLReader xr = XMLReaderFactory.createXMLReader();
        SAXHandler sh = new SAAXHandler();
        xr.setContentHandler(sh);
        xr.setErrorHandler(sh);

        try {
            xr.parse(fis);
        } catch (SAXParseException e) {
            e.printStackTrace();
            return;
        }
    }

    static class SAAXHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                if (qName.equalsIgnoreCase("name")) {
                    bName = false;
                }
            } else if (bAge) {
                if (qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("End of person element");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                String s = new String(ch, start, length);
                System.out.println("Name: " + s);
            } else if (bAge) {
                String s = new String(ch, start, length);
                System.out.println("Age: " + s);
            }
        }
    }
}