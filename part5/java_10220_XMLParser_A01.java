import org.xmlparser.CustomSecurityException;
import org.xmlparser.XMLParser;
import org.xmlparser.core.Document;
import org.xmlparser.core.NodeList;
import org.xmlparser.core.element.Element;
import org.xmlparser.core.element.Text;
import org.xmlparser.core.type.Attr;
import org.xmlparser.util.XMLUtil;

public class java_10220_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser();
            Document doc = parser.parse("src/test.xml"); // Assuming the file is named 'test.xml'

            // Print all elements and their attributes
            NodeList nodes = doc.getAllElements();
            for (int i = 0; i < nodes.getLength(); i++) {
                Element elm = nodes.item(i).getParent().getParent();
                System.out.println("Element: " + elm.getTagName());
                AttrList attrs = elm.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    System.out.println("Attribute: " + attrs.item(j).getName() + " = " + attrs.item(j).getValue());
                }
                Text text = (Text) elm.getFirstChild();
                if (text != null) {
                    System.out.println("Text: " + text.getData());
                }
            }

        } catch (CustomSecurityException e) {
            e.printStackTrace();
        }
    }
}