import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_15927_XMLParser_A08 extends DefaultHandler {
    private boolean isInStudent = false;
    private boolean isInGrade = false;
    private Student currentStudent;
    private String currentValue;
    private List<Student> students = new ArrayList<>();

    public class Student {
        public String name;
        public List<Integer> grades = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("student")) {
            currentStudent = new Student();
        } else if (qName.equals("grade")) {
            isInGrade = true;
        } else if (qName.equals("name")) {
            isInStudent = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("student")) {
            students.add(currentStudent);
            currentStudent = null;
            isInStudent = false;
        } else if (qName.equals("grade")) {
            isInGrade = false;
        } else if (qName.equals("name")) {
            isInStudent = false;
        } else if (isInStudent) {
            currentStudent.name = currentValue;
        } else if (isInGrade) {
            currentStudent.grades.add(Integer.parseInt(currentValue));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue = new String(ch, start, length);
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        // Parse your XML here and use parser to parse it
        // Example: parser.parse("path/to/your/xml/file.xml");
    }
}