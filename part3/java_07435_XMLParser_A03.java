import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;

public class java_07435_XMLParser_A03 {
    public static void main(String[] args) {
        DefaultHandler dh = new DefaultHandler();
        SAXParserFactory spf = SAXParserFactory.newInstance();
        XMLReader xr = null;
        
        try {
            xr = spf.newSAXParser().getXMLReader();
            xr.setContentHandler(dh);
            xr.parse("example.xml", dh);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}