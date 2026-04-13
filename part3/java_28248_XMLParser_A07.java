import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_28248_XMLParser_A07 {

    public static class EmployeeHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bSalary = false;
        private String currentElement = "";

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("employee")) {
                return;
            }

            if (qName.equals("name")) {
                bName = true;
            }

            if (qName.equals("salary")) {
                bSalary = true;
            }

            currentElement = qName;
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equals("employee")) {
                return;
            }

            if (currentElement.equals("name")) {
                bName = false;
            }

            if (currentElement.equals("salary")) {
                bSalary = false;
            }

            currentElement = "";
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bName) {
                System.out.print("Name: ");
                System.out.println(new String(ch, start, length));
                bName = false;
            }

            if (bSalary) {
                System.out.print("Salary: ");
                System.out.println(new String(ch, start, length));
                bSalary = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        saxParser.parse("src/main/resources/employees.xml", new EmployeeHandler());
    }
}