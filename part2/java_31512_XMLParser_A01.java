import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_31512_XMLParser_A01 {
    public static void main(String[] args) throws Exception {
        String xmlFilePath = "path_to_your_xml_file";  // Insert your xml file path here
        parseXMLFile(xmlFilePath);
    }

    public static void parseXMLFile(String xmlFilePath) throws Exception {
        File xmlFile = new File(xmlFilePath);
        InputStream inputStream = new FileInputStream(xmlFile);
        if (!xmlFile.exists()) {
            System.out.println("The xml file does not exist!");
            return;
        }

        int content;
        while ((content = inputStream.read()) != -1) {
            System.out.print((char) content);
        }

        inputStream.close();
    }
}