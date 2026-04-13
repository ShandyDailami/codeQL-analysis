import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_41739_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "sample.xml";
        parseXml(fileName);
    }

    public static void parseXml(String fileName) {
        FileInputStream fis = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            fis = new FileInputStream(new File(fileName));
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fis);

            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}