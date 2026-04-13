import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParserFactory;

public class java_35614_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("note");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                doc = builder.parse(new File("example.xml"));
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("note");
                for (int i = 0; i < nList.getLength(); i++) {
                    Node node = nList.item(i);
                    System.out.println("Note #" + (i + 1));
                    System.out.println("-----------------------------------------------");
                    System.out.println("Book Title: " + node.getChildNodes().item(1).getNodeValue());
                    System.out.println("Book Author: " + node.getChildNodes().item(3).getNodeValue());
                    System.out.println("Book Publication Date: " + node.getChildNodes().item(5).getNodeValue());
                    System.out.println("Book Summary: " + node.getChildNodes().item(7).getNodeValue());
                    System.out.println("");
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}