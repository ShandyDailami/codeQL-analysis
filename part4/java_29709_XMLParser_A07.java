import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_29709_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            parse(xmlFile);
        } catch (Exception e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }

    public static void parse(File xmlFile) throws Exception {
        InputStream inputStream = new FileInputStream(xmlFile);
        int content;

        while ((content = inputStream.read()) != -1) {
            System.out.print((char) content);
        }

        inputStream.close();
    }
}