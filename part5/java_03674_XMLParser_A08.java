import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_03674_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "example.xml"; // Specify your XML file here

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(fileName));

            // Here you can handle the parsed XML document, for example, print out all element names:
            document.getDocumentElement().normalize();
            System.out.println("Root Element: " + document.getDocumentElement().getNodeName());

            // Iterate over children and print their names:
            for (int i = 0; i < document.getElements().getLength(); i++) {
                System.out.println("Child " + (i + 1) + ": " + document.getElements().item(i).getNodeName());
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}