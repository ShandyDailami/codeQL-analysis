import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

public class java_33944_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            DefaultHandler dh = new DefaultHandler();
            xr.setContentHandler(dh);

            // Set the input file. Replace 'input.xml' with your input file.
            xr.parse("input.xml");

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}