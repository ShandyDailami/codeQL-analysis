import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_13052_XMLParser_A08 {
    public static void main(String[] args) {
        String fileName = "example.xml";
        parseXML(fileName);
    }

    private static void parseXML(String fileName) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(fileName));

            // Get the root element
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            // Security sensitive operations
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}