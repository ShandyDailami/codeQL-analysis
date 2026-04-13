import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_32233_XMLParser_A08 {
    public static void main(String[] args) {
        String directory = "."; // Change this to the directory where the XML files are stored
        File dir = new File(directory);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Error: " + directory + " is not a valid directory.");
            return;
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        for (File file : dir.listFiles()) {
            if (!file.isFile() || !file.getName().endsWith(".xml")) continue;

            try {
                Document document = builder.parse(file);
                System.out.println("Parsed: " + file.getName());
                // TODO: Add code to parse the document.
                // You can use document.getElementsByTagName() or similar methods to parse the XML document.

            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}