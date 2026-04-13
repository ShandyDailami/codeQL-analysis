import com.machinezorg.xmlparser.SimpleXMLElement;
import com.machinezorg.xmlparser.XMLParser;

public class java_14791_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlDocument = "<root><name>Value</name></root>";

        try {
            SimpleXMLElement root = new SimpleXMLElement(xmlDocument);

            // Extracting the name element
            SimpleXMLElement name = root.getChild("name");

            // Printing the name
            System.out.println("Name: " + name.getValue());

            // Security-sensitive operation: Accessing the name element
            // In this operation, we're using a well-known pattern that involves
            // directly accessing the inner text of an XML element
            String innerText = name.getInnerXML();
            System.out.println("Inner XML: " + innerText);

            // Security-sensitive operation: Direct modification of the inner text
            // This operation involves modifying the XML directly, which is not recommended
            innerText = "Modified " + innerText;
            name.setInnerXML(innerText);
            System.out.println("Modified Inner XML: " + innerText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}