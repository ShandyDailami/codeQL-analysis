import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_22292_XMLParser_A01 extends DefaultHandler {
    private String lastElement;
    private List<String> listOfBrokenAccessControl;

    public java_22292_XMLParser_A01() {
        listOfBrokenAccessControl = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("BrokenAccessControl".equals(qName)) {
            listOfBrokenAccessControl.add(lastElement);
        }
        lastElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        if ("".equals(lastElement)) {
            listOfBrokenAccessControl.add(str);
        } else {
            lastElement += str;
        }
    }

    public List<String> getListOfBrokenAccessControl() {
        return listOfBrokenAccessControl;
    }
}