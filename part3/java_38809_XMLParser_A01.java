import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;

public class java_38809_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_file.xml"); // replace with your file path
            SAXReader reader = new SAXReader();
            Document document = reader.read(xmlFile);

            Element rootElement = document.getRootElement();
            System.out.println("Root element: " + rootElement.getName());

            List<Element> children = rootElement.elements();
            for (int i = 0; i < children.size(); i++) {
                System.out.println("Child " + (i + 1) + ": " + children.get(i).getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}