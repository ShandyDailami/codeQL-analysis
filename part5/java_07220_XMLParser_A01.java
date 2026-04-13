import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class java_07220_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");

        try {
            XmlSecurityManager xmlSecurityManager = new XmlSecurityManager(xmlFile);
            XmlParser xmlParser = new XmlParser(xmlSecurityManager);
            xmlParser.parseXmlFile(xmlFile);
        } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException | ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}