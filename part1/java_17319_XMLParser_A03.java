import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_17319_XMLParser_A03 {

    private List<String> employeeNames = new ArrayList<>();

    public List<String> parse(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new EmployeeContentHandler(employeeNames));
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                try {
                    xmlReader.close();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        }
        return employeeNames;
    }

    public static void main(String[] args) {
        LegacyXMLParser parser = new LegacyXMLParser();
        List<String> employeeNames = parser.parse("src/main/resources/employees.xml");
        for (String name : employeeNames) {
            System.out.println(name);
        }
    }
}