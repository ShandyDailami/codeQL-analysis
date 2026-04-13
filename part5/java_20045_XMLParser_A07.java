import java.io.File;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_20045_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_xml_file");
        System.out.println(parseXmlFile(xmlFile));
    }

    public static String parseXmlFile(File xmlFile) {
        String xmlString = "";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(false);
        factory.setXInclude(false);
        factory.setXSI(false);

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // perform security sensitive operations here
            // For example, check if AuthFailure is implemented in the XML
            xmlString = doc.getElements().toString();

        } catch (SAXException | KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }

        return xmlString;
    }
}