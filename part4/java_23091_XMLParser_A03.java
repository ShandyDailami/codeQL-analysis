import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_23091_XMLParser_A03 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml"));

            printElementNamesAndAttributes(doc, "");
        } catch (ParsingException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElementNamesAndAttributes(Document document, String indent) {
        NodeList nodes = document.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            printElementNamesAndAttributes(nodes.item(i), indent);
        }

        for (int i = 0; i < document.getElementsByTagName("*").getLength(); i++) {
            printElementNamesAndAttributes(document.getChildNodes().item(i), indent + "  ");
        }
    }
}