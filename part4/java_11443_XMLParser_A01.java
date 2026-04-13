import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_11443_XMLParser_A01 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse("src/data.xml"); //replace with your xml file

            //print out the data
            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            System.out.println("Child elements: ");
            printElement(document.getDocumentElement());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(org.w3c.dom.Element element) {
        List<org.w3c.dom.Element> children = element.getChildNodes();
        for (int i = 0; i < children.size(); i++) {
            org.w3c.dom.Element child = (org.w3c.dom.Element) children.item(i);
            System.out.print("Child element: " + child.getNodeName());
            printElement(child);
        }
    }
}