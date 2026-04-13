import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_01027_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_xml_file");
            InputStream inputStream = new FileInputStream(file);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Parsing code goes here

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}