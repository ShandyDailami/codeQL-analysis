import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_02506_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");

        //Create a factory for building DOM tree
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            //Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Parse the XML file
            Document doc = builder.parse(xmlFile);

            //Get the root element
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("element");

            //Iterate through each node
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Element " + (i + 1) + ": " + nodeList.item(i).getTextContent());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}