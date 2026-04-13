import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_26952_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("path/to/your/file.xml");
            InputStream inStream = new FileInputStream(inputFile);
            InputStreamReader inStreamReader = new InputStreamReader(inStream);
            
            // Create a DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // Parse the input file
            Document doc = dBuilder.parse(inStreamReader);
            
            // TODO: Add code here to handle the document as per requirements
            // Example: print the document title
            System.out.println(doc.getDocumentElement().getNodeName());
            
            inStreamReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}