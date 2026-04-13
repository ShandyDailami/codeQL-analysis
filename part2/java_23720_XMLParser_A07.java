import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_23720_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElementsByTagName("category").item(0).getTextContent());

            // Here, we are assuming we have a category and subcategory tag and we want to print them
            NodeList nList = doc.getElementsByTagName("category");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);
                String categoryName = element.getElementsByTagName("categoryName").item(0).getTextContent();
                String subcategoryName = element.getElementsByTagName("subcategoryName").item(0).getTextContent();
                System.out.println("Category : " + categoryName + ", SubCategory : " + subcategoryName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}