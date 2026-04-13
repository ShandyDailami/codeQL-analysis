import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_08962_XMLParser_A03 {
    private static final String XPATH_EXPR = "/bookstore/book[price>50]";

    public static void main(String[] args) throws Exception {
        // Step 1: Create a factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Step 2: Use factory to create a document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 3: Parse the XML file
        Document document = builder.parse("src/main/resources/books.xml");

        // Step 4: Create a transformer
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // Step 5: Set the output (in this case, a file called books.xml)
        transformer.transform(new DOMSource(document), new StreamResult("target/books.xml"));
    }
}