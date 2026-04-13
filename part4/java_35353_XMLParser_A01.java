import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_35353_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxFactory.newSAXParser(true);
            SAXHandler saxHandler = new SAXHandler();

            saxParser.parse(new File("input.xml"), saxHandler);
            printList(saxHandler.getDataList());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printList(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}