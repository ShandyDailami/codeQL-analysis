import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class java_09846_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            String expression = "/Bookstore/Book";
            NodeList nodeList = (NodeList) xPath.evaluate(expression, doc, XPathConstants.NODESET);

            for (int temp = nodeList.getLength() - 1; temp >= 0; temp--) {
                Element element = (Element) nodeList.item(temp);
                String bookTitle = element.getElementsByTagName("Title").item(0).getTextContent();
                String bookAuthor = element.getElementsByTagName("Author").item(0).getTextContent();
                String bookPrice = element.getElementsByTagName("Price").item(0).getTextContent();

                System.out.println("Title: " + bookTitle);
                System.out.println("Author: " + bookAuthor);
                System.out.println("Price: " + bookPrice);
                System.out.println("---------------------");
            }

            dBuilder.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}