import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;
import java.net.URL;
import java.security.CodeSource;

public class java_42106_XMLParser_A03 {

    public static void main(String[] args) throws Exception {

        // Obtain the security context of the classloader
        CodeSource codeSource = XmlParser.class.getClassLoader().getCodeSource();

        // Get the context path
        URL contextPath = codeSource.getLocation().toURI().toURL();

        // Load the document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(contextPath.openStream());

        // Use XPath to extract information
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = "/root/element"; // Assuming '/root/element' is the path to the element
        Object result = xpath.evaluate(expression, document, XPathConstants.NODE);

        System.out.println("Extracted Node: " + result);
    }
}