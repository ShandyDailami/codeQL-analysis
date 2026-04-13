import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_38681_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element : " + doc.getElementsByTagName("tagname").item(0).getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}