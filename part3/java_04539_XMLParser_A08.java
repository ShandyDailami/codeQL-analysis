import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_04539_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("input.xml");
            ZipInputStream zin = new ZipInputStream(fin);
            ZipEntry entry = zin.getNextEntry();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            while (entry != null) {
                if (entry.getName().equals("input.xml")) {
                    Document document = builder.parseURL(entry.getName());

                    System.out.println("XML content:");
                    printXML(document);
                }
                entry = zin.getNextEntry();
            }
            zin.closeEntry();
            zin.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void printXML(Document document) {
        @SuppressWarnings("unused")
        void context(Node node) {
            node.getChildNodes().item(0).getNodeValue();
        }
    }
}