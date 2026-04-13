import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_22073_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("books.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList bookList = doc.getElementsByTagName("book");
            for (int i = 0; i < bookList.getLength(); i++) {
                System.out.println("Book " + (i + 1) + ":");
                Node bookNode = bookList.item(i);
                NodeList attrList = bookNode.getChildNodes();
                for (int j = 0; j < attrList.getLength(); j++) {
                    System.out.println("   " + attrList.item(j).getNodeName() + ": " + attrList.item(j).getTextContent());
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}