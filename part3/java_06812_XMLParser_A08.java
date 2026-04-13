import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_06812_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader = null;
        
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setEntityResolver(new MyEntityResolver());
            
            XMLParserImpl parser = new XMLParserImpl();
            parser.setXMLReader(xmlReader);
            parser.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                xmlReader.close();
            }
        }
    }
}