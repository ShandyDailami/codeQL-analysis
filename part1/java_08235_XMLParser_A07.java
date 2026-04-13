import java.util.XML.*;

public class java_08235_XMLParser_A07 {

    public static void main(String[] args) {
        Document document;
        try {
            // Load the XML file
            document = new DocumentBuilder().newDocument();
            document.load("input.xml");

            // Print out the element names and their attributes
            printElementsAndAttributes(document);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println("Element: " + element.getNodeName());
            NamedNodeMap attributes = element.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                System.out.println("  Attribute: " + attributes.item(j).getNodeName() + " = " + attributes.item(j).getTextContent());
            }
        }
    }

}