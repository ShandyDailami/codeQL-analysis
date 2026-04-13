import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_23507_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file.xml"; // replace with your xml file path
        String xsdFile = "path_to_your_xsd_file.xsd"; // replace with your xsd file path

        try {
            File schemaFile = new File(xsdFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidate(true);
            factory.setSchemas(schemaFile);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlFile));

            System.out.println("XML file is valid according to schema " + schemaFile.getName());
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.println("XML file is not valid according to schema " + ((XmlResourceResolver)null).getSystemId());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to parse XML file " + xmlFile);
        }
    }
}