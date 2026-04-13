import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_04401_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/xml/file.xml"); // replace with your xml file path
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("name");

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Name: " + nodeList.item(i).getTextContent());

                nodeList = document.getElementsByTagName("age");

                System.out.println("Age: " + nodeList.item(i).getTextContent());
           
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}