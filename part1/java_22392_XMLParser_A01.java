import java.awt.List;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_22392_XMLParser_A01 {
    
    private static final String FILE_PATH = "path_to_your_xml_file";

    public static void main(String[] args) {
        try {
            checkFileAccessibility(new File(FILE_PATH));
            System.out.println("File is accessible.");
        } catch (Exception e) {
            System.out.println("File is not accessible.");
            e.printStackTrace();
        }
    }

    private static void checkFileAccessibility(File file) throws Exception {
        if (!file.exists()) {
            throw new Exception("File does not exist!");
        }

        if (!file.canRead()) {
            throw new Exception("File is not readable!");
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(new FileInputStream(file));
        doc.getDocumentElement().normalize();

        System.out.println("Document has been loaded.");
    }
}