import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_28734_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // get the root element
            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getElementsByTagName("note").item(0).getTextContent());

            // store the result
            parseElement(doc.getElementsByTagName("note").item(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void parseElement(Element element) {
        System.out.println("tag name: " + element.getTagName());
        System.out.println("attributes: " + element.getAttributes().getLength());

        // recursively call parse method on child nodes
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE) {
                parseElement((Element) element.getChildNodes().item(i));
            }
        }
    }
}