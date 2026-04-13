import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_26154_XMLParser_A03 extends DefaultHandler {

    private String currentElement;
    private List<Map<String, String>> studentRecords;

    public List<Map<String, String>> getStudentRecords() {
        return studentRecords;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equals("students")) {
            studentRecords = (List<Map<String, String>>) (Map<String, String>) attributes.getValue("students");
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null && currentElement.equals("student")) {
            Map<String, String> student = (Map<String, String>) studentRecords.get(studentRecords.size() - 1);
            student.put(qName, new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLParser handler = new XMLParser();

        parser.parse(new File("src/main/resources/students.xml"), handler);

        for (Map<String, String> student : handler.getStudentRecords()) {
            System.out.println(student);
        }
    }
}