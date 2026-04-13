import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_30244_XMLParser_A01 {

    public static void main(String[] args) {
        String filePath = "/path/to/your/xml/file.xml";
        parseAndPrintXML(filePath);
    }

    private static void parseAndPrintXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));

            // Traverse XML tree and print all element names and their attributes
            printXML(document);

            // Save the XML to a new file with transformed stylesheet
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("output.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printXML(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println("Element: " + element.getTagName());
            System.out.println("Attributes: ");
            NodeList attributeList = element.getAttributes();
            for (int j = 0; j < attributeList.getLength(); j++) {
                System.out.println("Attribute: " + attributeList.item(j).getNodeName() + " = " + attributeList.item(j).getTextContent());
            }
        }
    }
}