import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_15251_XMLParser_A03 extends DefaultHandler {
    private String currentElement;
    private List<String> injectionList = new ArrayList<>();

    public List<String> getInjectionList() {
        return injectionList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = null;
        if (currentElement != null && currentElement.equals("injection")) {
            // You can add your security-sensitive operations here, such as checking if the input is harmful.
            // For example, you can check if it contains SQL statements:
            String input = qName; // The input to check
            if (input.contains("SELECT") || input.contains("INSERT") || input.contains("UPDATE")
                    || input.contains("DELETE") || input.contains("DROP") || input.contains("CREATE")
                    || input.contains("ALTER") || input.contains("GRANT") || input.contains("REVOKE")) {
                injectionList.add("Suspicious input detected in injection tag: " + input);
            }
        }
    }
}