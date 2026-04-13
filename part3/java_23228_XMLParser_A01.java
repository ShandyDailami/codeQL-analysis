import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_23228_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            String filePath = "your_file_path.xml"; // replace with your file path
            parseXMLFile(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            InputStream inputStream = new FileInputStream(new File(filePath));
            Document document = builder.parse(inputStream);

            document.getDoctype();

            Element root = document.getDocumentElement();
            printElementNames(root);

            inputStream.close();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Element element) {
        if (element.hasChildNodes()) {
            NodeList childNodes = element.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);
                if (node.getNodeType() == Node.TEXT_NODE && node.getTextContent().trim().isEmpty()) {
                    continue;
                }
                System.out.println(node.getNodeName());
                if (node.hasChildNodes()) {
                    printElementNames((Element) node);
                }
            }
        }
    }
}