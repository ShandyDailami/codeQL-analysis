import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_07347_XMLParser_A03 {

    public void parseXml(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(Class.forName(fileName).getResourceAsStream(fileName));

            // Security-sensitive operation: Injecting an arbitrary XPath expression
            String injection = "//element_name[@attribute_name='" + fileName + "']";

            // Use the injected XPath expression to select an element
            doc.evaluate(injection, doc, null, XPathConstants.NODESET);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}