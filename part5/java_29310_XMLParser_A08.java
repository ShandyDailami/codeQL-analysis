import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_29310_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root Element : " + doc.getElementsByTagName("root"));

            Element rootElement = doc.getDocumentElement();

            System.out.println("Child Elements of root : ");

            for (int i = 0; i < rootElement.getChildNodes().getLength(); i++) {
                Element childElement = (Element) rootElement.getChildNodes().item(i);
                System.out.println("Child Element : " + childElement.getNodeName());
            }

            System.out.println("Attributes of root Element : ");
            for (int i = 0; i < rootElement.getAttributes().getLength(); i++) {
                System.out.println("Attribute : " + rootElement.getAttributes().item(i).getNodeName() + " : " + rootElement.getAttributes().item(i).getTextContent());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}