import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_07274_XMLParser_A01 {

    public static void main(String[] args) {
        String inputFilePath = "/path/to/input.xml";
        String outputFilePath = "/path/to/output.xml";
        secureRemoveFirstLine(inputFilePath, outputFilePath);
    }

    private static void secureRemoveFirstLine(String inputFilePath, String outputFilePath) {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new FileReader(inputFile));

            document.getDocumentElement().normalize();
            document.getDocumentElement().getFirstChild().getNextSibling().getRemoveChildNodes();

            try(OutputStream outputStream = new FileOutputStream(outputFile)) {
                document.write(outputStream);
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}