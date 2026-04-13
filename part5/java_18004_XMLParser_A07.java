import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_18004_XMLParser_A07 {

    private File xmlFile;

    public java_18004_XMLParser_A07(String fileName) {
        xmlFile = new File(fileName);
    }

    public void parse() {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new AuthFailureContentHandler());
            reader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the XML file.");
        } catch (SAXException e) {
            System.out.println("An error occurred while parsing the XML file.");
        } catch (ParserConfigurationException e) {
            System.out.println("An error occurred while creating a parser.");
        }
    }

    public static void main(String[] args) {
        new XmlParser("authfailure.xml").parse();
    }
}