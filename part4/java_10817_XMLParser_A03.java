import org.jdom2.*;
import org.jdom2.input.*;
import java.net.*;

public class java_10817_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/books.xml");
            Document document = JDOMParser.parse(url.openStream(), DocumentType.load("application/xml"));

            Element root = document.getRootElement();

            System.out.println("Root element: " + root.getName());

            Iterator<Element> elements = root.getChildrenElements();
            while (elements.hasNext()) {
                Element element = elements.next();
                System.out.println("Child element: " + element.getName());
           
                Iterator<Element> subElements = element.getChildrenElements();
                while (subElements.hasNext()) {
                    Element subElement = subElements.next();
                    System.out.println("Grandchild element: " + subElement.getName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}