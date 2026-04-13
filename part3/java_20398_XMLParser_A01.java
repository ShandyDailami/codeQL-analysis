import com.example.xmlparser.XMLElement;
import com.example.xmlparser.XMLParser;
import com.example.xmlparser.XMLParserException;

public class java_20398_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser();
            XMLElement root = parser.parse("resources/broken_access_control.xml");
            printElement(root);
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(XMLElement element) {
        System.out.println("Element: " + element.getTagName());
        List<XMLElement> children = element.getChildren();
        for (XMLElement child : children) {
            printElement(child);
        }
    }

}