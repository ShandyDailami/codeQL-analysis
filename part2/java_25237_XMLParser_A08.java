import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import org.xml.sax.SAXException;

public class java_25237_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElementsAndContent(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndContent(Document doc) {
        NodeList nlist = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nlist.getLength(); temp++) {
            Element element = (Element) nlist.item(temp);
            String elementName = element.getNodeName();
            String elementContent = element.getTextContent();
            if (elementContent.contains("<script>") || elementContent.contains("</script>")) {
                elementContent = elementContent.replace("<script>", "<cscript>").replace("</script>", "</cscript>");
            }
            System.out.println("Element: " + elementName + ", Content: " + elementContent);
        }
    }
}