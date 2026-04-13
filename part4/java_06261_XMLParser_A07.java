import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class java_06261_XMLParser_A07 {

    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        File xmlFile = new File("input.xml");

        try {
            Document document = reader.read(xmlFile);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();

            for (Element element : elements) {
                String elementName = element.getName();
                String elementValue = element.getStringValue();
                System.out.println("Element Name: " + elementName);
                System.out.println("Element Value: " + elementValue);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}