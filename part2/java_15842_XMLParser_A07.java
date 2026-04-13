import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_15842_XMLParser_A07 {

    public static void main(String[] args) {

        String xmlFile = "src/main/resources/sample.xml";  // your xml file path

        SAXDriver driver = new SAXDriver();
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            driver.setContentHandler(reader);
            driver.parse(xmlFile);

            System.out.println("Parsing Completed Successfully!");

        } catch (SAXException e) {
            e.printStackTrace();
       
        }
    }
}