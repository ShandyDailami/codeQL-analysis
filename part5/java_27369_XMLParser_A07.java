import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_27369_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            parseXML("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String fileName) throws IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(fileName));
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Element: " + nodeList.item(i).getNodeName());
        }

        // print out all attributes and values
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Attribute: " + nodeList.item(i).getAttributes().getLength());
            for (int j = 0; j < nodeList.item(i).getAttributes().getLength(); j++) {
                System.out.println("Value: " + nodeList.item(i).getAttributes().item(j).getTextContent());
            }
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
    }
}