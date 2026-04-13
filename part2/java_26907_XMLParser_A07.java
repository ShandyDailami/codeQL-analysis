import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.InvalidParameterException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_26907_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            String xmlFile = "path/to/your/file.xml"; // replace with your actual file path
            parseXMLFile(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXMLFile(String xmlFilePath) throws Exception {
        File xmlFile = new File(xmlFilePath);
        if (!xmlFile.exists()) {
            throw new InvalidParameterException("The specified file does not exist: " + xmlFilePath);
        }

        InputStream inputStream = new FileInputStream(xmlFile);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("element"); // replace "element" with the actual tag name

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;

            String value = element.getFirstChild().getNodeValue(); // replace "element" with the actual tag name
            System.out.println("Value for element " + (i + 1) + ": " + value);
        }

        inputStream.close();
    }
}