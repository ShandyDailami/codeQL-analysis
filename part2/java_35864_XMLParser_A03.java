import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_35864_XMLParser_A03 {
    private String filePath;

    public java_35864_XMLParser_A03(String filePath) {
        if (!filePath.endsWith(".xml")) {
            throw new InvalidParameterException("File path must be an XML file.");
        }
        this.filePath = filePath;
    }

    public void parseFile() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return;
        }

        document.getDocumentElement().normalize();
        NodeList elements = document.getElementsByTagName("element");

        for (int i = 0; i < elements.getLength(); i++) {
            Element element = (Element) elements.item(i);
            String tag = element.getTagName();
            System.out.println("Tag: " + tag);
        }
    }

    public static void main(String[] args) {
        String filePath = "/path/to/your/xml/file.xml";
        SecureXMLParser parser = new SecureXMLParser(filePath);
        parser.parseFile();
    }
}