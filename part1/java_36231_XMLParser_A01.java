import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_36231_XMLParser_A01 extends DefaultHandler {
    // Private member of a different class
    private int privateMember;

    // Method to set the private member
    public void setPrivateMember(int privateMember) {
        this.privateMember = privateMember;
    }

    // Handling the start of an element
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("element")) {
            // Break access to the private member
            System.out.println("Breaking access to private member!");
            privateMember = 100; // This will cause a runtime error
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXHelper helper = new SAXHelper();
        helper.setDefaultHandler(new BrokenXMLParser());

        // Wrapper to catch SAX exceptions
        try {
            helper.parse("broken.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}