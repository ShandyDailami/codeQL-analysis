import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_02762_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Step 2: Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Use the builder to parse the XML document
            InputStream inputStream = new FileInputStream(new File("src/main/resources/example.xml"));
            Document document = builder.parse(inputStream);

            // Step 4: Use the DOM (Document Object Model) to extract data
            Element rootElement = document.getDocumentElement();

            System.out.println("Root element: " + rootElement.getNodeName());

            List<Element> list = document.getElementsByTagName("element");
            for (int i = 0; i < list.getLength(); i++) {
                Element element = list.item(i);
                System.out.println("Element " + (i+1) + ": " + element.getNodeName());
                System.out.println("Attribute 'name': " + element.getAttribute("name"));
                System.out.println("Attribute 'id': " + element.getAttribute("id"));
            }

            // Close the input stream
            inputStream.close();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}