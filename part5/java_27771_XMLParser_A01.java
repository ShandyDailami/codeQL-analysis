import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_27771_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("example.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean isName = false;
        private boolean isAge = false;
        private boolean isSalary = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("Employee")) {
                return;
            }

            if (qName.equals("Name")) {
                isName = true;
                return;
            }

            if (qName.equals("Age")) {
                isAge = true;
                return;
            }

            if (qName.equals("Salary")) {
                isSalary = true;
                return;
            }

            // other elements you want to parse
            // e.g.,
            // if (qName.equals("Department")) {
            //     isDepartment = true;
            //     return;
            // }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("Employee")) {
                return;
            }

            // check if element was parsed
            // e.g.,
            // if (isDepartment) {
            //     System.out.println("Department: " + content);
            //     isDepartment = false;
            //     return;
            // }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                System.out.println("Name: " + new String(ch, start, length));
                isName = false;
            } else if (isAge) {
                System.out.println("Age: " + new String(ch, start, length));
                isAge = false;
            } else if (isSalary) {
                System.out.println("Salary: " + new String(ch, start, length));
                isSalary = false;
            }
        }
    }
}