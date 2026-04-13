import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16862_XMLParser_A08 {

    private static final String XML_FILE_EXTENSION = ".xml";

    public void parseXMLFiles(String directoryPath) throws Exception {
        File directory = new File(directoryPath);
        File[] xmlFiles = directory.listFiles((File dir, String name) -> name.endsWith(XML_FILE_EXTENSION));

        if (xmlFiles == null) {
            throw new Exception("No XML files found in the directory: " + directoryPath);
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        for (File xmlFile : xmlFiles) {
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(xmlFile);

                // Here you can add your security-sensitive operations related to A08_IntegrityFailure

            } catch (Exception e) {
                System.out.println("Failed to parse XML file: " + xmlFile.getAbsolutePath());
            }
        }
    }

}