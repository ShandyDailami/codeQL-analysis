import org.jdom2.*;
import org.jdom2.input.*;
import java.io.*;

public class java_05903_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/file.xml");
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(xmlFile);
            printDocumentInfo(document);
        } catch (JDOMException | IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }

    private static void printDocumentInfo(Document document) {
        System.out.println("Root element: " + document.getRootElement().getName());
        System.out.println("Element count: " + document.getRootElement().getChildCount());

        // Security-sensitive operations related to A01_BrokenAccessControl
        // ...
    }
}