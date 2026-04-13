import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_26889_XMLParser_A01 extends DefaultHandler {
    private List<String> securityIssues = new ArrayList<>();
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("security")) {
            // check for broken access control
            if (securityIssues.contains("Broken Access Control")) {
                System.out.println("Security issue found: " + currentElement + " has Broken Access Control");
            }
        } else if (qName.equals("access")) {
            if (securityIssues.contains("Broken Access Control")) {
                System.out.println("Security issue found: " + currentElement + " has Broken Access Control");
            }
        } else if (qName.equals("control")) {
            if (securityIssues.contains("Broken Access Control")) {
                System.out.println("Security issue found: " + currentElement + " has Broken Access Control");
            }
        } else {
            currentElement = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            String value = new String(ch, start, length).trim();
            if (!value.isEmpty()) {
                if (currentElement.equals("access")) {
                    // check for sensitive operations related to access control
                    if (value.contains("sensitive operations")) {
                        securityIssues.add(currentElement);
                    }
                } else {
                    // check for sensitive operations related to security
                    if (value.contains("sensitive operations")) {
                        securityIssues.add(currentElement);
                    }
                }
            }
        }
    }
}