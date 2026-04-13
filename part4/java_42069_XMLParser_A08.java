import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_42069_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml"); // replace with your XML file path
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setFeature("http://xml.org/sax/features/namespaces", true);
        factory.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
       
        } catch (IOException e) {
            e.printStackTrace();
        }

        // print the content of the document
        printDocument(document);
    }

    private static void printDocument(Document document) {
        // print the content of the document
        document.getDocumentElement().normalize();
        System.out.println("Root element: " + document.getDocumentElement().getNodeName());
        System.out.println("-----------");
        printElement(document.getDocumentElement());
    }

    private static void printElement(org.w3c.dom.Node element) {
        System.out.print("Start element: " + element.getNodeName());
        if (element.hasAttributes()) {
            System.out.print(" Attributes: ");
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                System.out.print(element.getAttributes().item(i).getNodeName() + "='" + element.getAttributes().item(i).getTextContent() + "' ");
            }
        }
        System.out.println();

        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).getNodeType() == Node.COMMENT_NODE) {
                System.out.println("Comment: " + element.getChildNodes().item(i).getNodeValue());
            } else if (element.getChildNodes().item(i).getNodeType() == Node.TEXT_NODE && ((Text) element.getChildNodes().item(i)).getNodeValue().trim().length() > 0) {
                System.out.println("Text: " + ((Text) element.getChildNodes().item(i)).getNodeValue());
            } else {
                printElement((Node) element.getChildNodes().item(i));
            }
        }
        System.out.println("End element: " + element.getNodeName());
        System.out.println("-----------");
    }
}