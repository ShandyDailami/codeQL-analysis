import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.FileHandler;

public class java_40718_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("employees.xml");
        FileHandler fileHandler = new FileHandler(xmlFile);
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setContentHandler(fileHandler);

        try {
            xmlReader.parse(new java.io.FileInputStream(xmlFile));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Employee Names:");
        for (String name : fileHandler.getEmployeeNames()) {
            System.out.println(name);
        }
    }
}