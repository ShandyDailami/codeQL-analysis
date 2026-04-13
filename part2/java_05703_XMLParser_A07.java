import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_05703_XMLParser_A07 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document;
        try {
            document = builder.parse(inputFile);
            document.getDocumentElement().normalize();

            printElement(document.getDocumentElement());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printElement(Element element) {
        System.out.println("Element: " + element.getNodeName());
        System.out.println("Attributes: " + element.getAttributes().getLength());
        printElementContent(element);
    }

    public static void printElementContent(Element element) {
        switch (element.getNodeType()) {
            case Element.ELEMENT_NODE:
                for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                    printElementContent((Element) element.getChildNodes().item(i));
                }
                break;
            case Element.TEXT_NODE:
                System.out.println("Text: " + element.getTextContent());
                break;
        }
    }
}