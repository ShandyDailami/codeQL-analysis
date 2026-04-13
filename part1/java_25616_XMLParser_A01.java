import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_25616_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File("sample.xml"));

            System.out.println("Document is parsed successfully.");

            // This code will throw an exception if the XML file is not accessible
            // You can replace "sample.xml" with your own XML file

            Transformer transformer = doc.getDOMConfigurator().getTransformerFactory().newTransformer();
            transformer.setOutputProperty(Transformer.OUTPUT_PROPERTY_OMIT_COMMENTS, "true");
            transformer.transform(new DOMSource(doc), new StreamResult(System.out));

        } catch (SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}