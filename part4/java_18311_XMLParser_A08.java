import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;
import java.io.*;

public class java_18311_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            Document document = loadXMLFile("src/main/resources/sample.xml");
            
            // Extract the security-sensitive operations related to A08_IntegrityFailure
            Element root = document.getRootElement();
            Element integrityFailureElement = root.getChild("A08_IntegrityFailure");
            
            // Perform security-sensitive operations
            if (integrityFailureElement != null) {
                String operation = integrityFailureElement.getChildText("operation");
                String argument = integrityFailureElement.getChildText("argument");
                
                // Here, we assume the operation and argument are valid and perform them.
                // In a real-world scenario, you would need to add code to handle errors and edge cases.
                System.out.println("Performing security-sensitive operation: " + operation + ", with argument: " + argument);
            }
            
            // Save the modified XML back to the file
            saveXMLFile(document, "src/main/resources/sample_modified.xml");
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
    }

    // Load XML file
    private static Document loadXMLFile(String filepath) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new File(filepath));
        return document;
    }

    // Save XML file
    private static void saveXMLFile(Document document, String filepath) throws IOException {
        PrettyPrintWriter writer = new PrettyPrintWriter(new OutputStreamWriter(new FileOutputStream(filepath), "UTF-8"));
        writer.write(document);
        writer.close();
    }
}