import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_21254_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Modify the tags
            NodeList bookNodes = doc.getElementsByTagName("book");
            for (int i = 0; i < bookNodes.getLength(); i++) {
                Element bookElement = (Element) bookNodes.item(i);
                bookElement.setAttribute("publisher", "Modified Publisher");

                NodeList authorNodes = bookElement.getElementsByTagName("author");
                for (int j = 0; j < authorNodes.getLength(); j++) {
                    Element authorElement = (Element) authorNodes.item(j);
                    authorElement.setAttribute("email", "Modified Email");
                }
            }

            // Write the modified document back to the file
            dBuilder.setExpandEmptyElements(false);
            dBuilder.setValidation(false);
            dBuilder.save(new File("modified_input.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}