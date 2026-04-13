import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_30398_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("input.xml"));

            // Get the root element
            doc.getDocumentElement().normalize();

            // Print the XML file title
            System.out.println("XML File Title : " + doc.getElementsByTagName("title").item(0).getTextContent());

            // Print all the movie titles
            NodeList movieList = doc.getElementsByTagName("movie");

            System.out.println("\nMovie Titles: ");

            for (int temp = 0; temp < movieList.getLength(); temp++) {
                Node node = movieList.item(temp);
                System.out.println(node.getChildNodes().item(0).getNodeValue());
            }

            // Print all the actor names
            System.out.println("\nActor Names: ");

            NodeList actorList = doc.getElementsByTagName("actor");

            for (int temp = 0; temp < actorList.getLength(); temp++) {
                Node node = actorList.item(temp);
                System.out.println(node.getChildNodes().item(0).getNodeValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}