import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.IOException;

public class java_21136_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // create a new factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // parse the document
            Document doc = builder.parse(new File("sample.xml"));
            
            // get all the elements
            NodeList nodeList = doc.getElementsByTagName("note");
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                
                // get the elements
                Element elementTo = node.getElementsByTagName("to").item(0);
                Element elementFrom = node.getElementsByTagName("from").item(0);
                Element elementHeading = node.getElementsByTagName("heading").item(0);
                Element elementBody = node.getElementsByTagName("body").item(0);
                
                // print the elements
                System.out.println("To: " + elementTo.getTextContent());
                System.out.println("From: " + elementFrom.getTextContent());
                System.out.println("Heading: " + elementHeading.getTextContent());
                System.out.println("Body: " + elementBody.getTextContent());
                System.out.println();
            }
            
            // close the document
            doc.close();
        } catch (IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}