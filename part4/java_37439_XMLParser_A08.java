import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_37439_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("input.xml"));

            // Extract the value of a specific element
            NodeList nodeList = doc.getElementsByTagName("elementName");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String value = element.getAttribute("attributeName");

                // Write the value back to the XML file
                element.setTextContent(value);
           
            }

            // Write the modified document back to the file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("output.xml"));
            transformer.transform(source, result);

            System.out.println("Successfully parsed and modified the XML file.");

        } catch (ParserConfigurationException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }
}