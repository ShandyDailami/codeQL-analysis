import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_18545_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("yourfile.xml"); // Replace with your XML file
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setEntityResolver(new SecurityResolver());
            xmlReader.parse(xmlFile);

            System.out.println("XML parsing complete.");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                xmlReader.close();
            }
        }
    }
}