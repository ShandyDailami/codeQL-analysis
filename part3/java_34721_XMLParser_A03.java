import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class java_34721_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            String expression = "/bookstore/book/title";
            NodeList nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            for (int temp = 0; temp != nodeList.getLength(); temp++) {
                Element element = (Element) nodeList.item(temp);
                System.out.println("Title : " + element.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Price : " + element.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("Author : " + element.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("---------------");
            }

            dBuilder = null;
            dbFactory = null;
            xpath = null;
            xPathFactory = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}