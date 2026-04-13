import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class java_13686_XMLParser_A01 {

    public static void main(String[] args) {
        parseXML("example.xml");
    }

    public static void parseXML(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            InputStream inputStream = new FileInputStream(xmlFile);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            int data;
            while ((data = inputStreamReader.read()) != -1) {
                System.out.print((char) data);
            }

            inputStreamReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}