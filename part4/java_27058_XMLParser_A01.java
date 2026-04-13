import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class java_27058_XMLParser_A01 {

    private List<String> fileNames = new ArrayList<>();

    public java_27058_XMLParser_A01() {
        fileNames.add("A01_BrokenAccessControl/A01_BrokenAccessControl.xml");
        fileNames.add("A01_BrokenAccessControl/A02_BrokenAccessControl.xml");
        fileNames.add("A01_BrokenAccessControl/A03_BrokenAccessControl.xml");
    }

    public void parseXMLFiles() {
        for (String fileName : fileNames) {
            parseXMLFile(fileName);
        }
    }

    private void parseXMLFile(String fileName) {
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("entry");
            Iterator<Element> iterator = nList.iterator();
            while (iterator.hasNext()) {
                Element node = iterator.nextElement();
                String accessLevel = node.getAttribute("accessLevel");
                if ("read".equals(accessLevel) || "write".equals(accessLevel)) {
                    System.out.println("Invalid access level: " + accessLevel + " in file: " + fileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.parseXMLFiles();
    }
}