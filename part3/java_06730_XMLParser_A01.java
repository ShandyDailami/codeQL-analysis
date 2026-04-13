import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.enters.XMLReader;

public class java_06730_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // replace with your XML file
        parse(xmlFile);
    }

    private static void parse(String xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start element: " + qName);
            }
            public void endElement(String uri, String localName, String qName) {
                System.out.println("End element: " + qName);
           
            }
        };

        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser(new InputSource(new File(xmlFile)));
            XMLReader xr = saxParser.getXMLReader();
            xr.setContentHandler(handler);
            xr.parse(new File(xmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}