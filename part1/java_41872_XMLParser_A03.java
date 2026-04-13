import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_41872_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Normalize the XML document
            doc.getDocumentElement().normalize();

            // Print the XML document
            System.out.println(doc.getElements().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}