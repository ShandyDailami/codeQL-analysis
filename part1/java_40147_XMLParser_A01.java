import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class java_40147_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("input.xml"));

            doc.getDocumentElement().normalize();
            System.out.println("Root Element : " + doc.getElementsByTagName("category").item(0).getTextContent());

            NodeList nList = doc.getElementsByTagName("product");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element eElement = (Element) nList.item(temp);

                System.out.println("Product ID : " + eElement.getElementsByTagName("id").item(0).getTextContent());
                System.out.println("Product Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Product Price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}