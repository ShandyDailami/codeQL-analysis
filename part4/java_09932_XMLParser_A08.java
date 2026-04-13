import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_09932_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            parse(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void parse(File inputFile) throws FileNotFoundException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputFile);

        // print the document elements
        doc.getElementsByTagName("*").item(0).getFirstChild().toString();
    }
}