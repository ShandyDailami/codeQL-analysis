import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16480_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlString = "<bookstore><book category='fiction'><title>Harry Potter</title></book></bookstore>";
        
        try {
            // Create a factory for handling the new instances of the Document class
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Use the factory to obtain a new instance of the DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML from the string into a Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            
            // Access the root element of the document
            Element root = doc.getDocumentElement();
            
            // Iterate over all book elements in the document
            NodeList bookNodes = root.getElementsByTagName("book");
            for (int i = 0; i < bookNodes.getLength(); i++) {
                Element bookElement = (Element) bookNodes.item(i);
                
                // Get the category attribute of the book element
                String category = bookElement.getAttribute("category");
                System.out.println("Category: " + category);
                
                // Get the title attribute of the book element
                String title = bookElement.getAttribute("title");
                System.out.println("Title: " + title);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}