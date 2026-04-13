import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_00037_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try(InputStream inputStream = new FileInputStream("example.xml")){ //replace "example.xml" with your xml file
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getElementsByTagName("name").item(0).getTextContent());

            Element element = doc.getElementsByTagName("country").item(0); //replace "country" with your tag name
            System.out.println("Country: " + element.getAttribute("name"));

            NodeList nodes = doc.getElementsByTagName("city");
            for(int i=0; i<nodes.getLength(); i++){
                System.out.println("City " + i + ": " + nodes.item(i).getTextContent());
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}