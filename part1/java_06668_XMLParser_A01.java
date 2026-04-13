import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class java_06668_XMLParser_A01 {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read("src/main/resources/example.xml");
            Element root = document.getRootElement();
            System.out.println("Root Element: " + root.getName());
            
            List<Element> list = root.elements();
            for (int i = 0; i < list.size(); i++) {
                Element elem = list.get(i);
                System.out.println("Element " + (i + 1) + ": " + elem.getName() + " - " + elem.getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}