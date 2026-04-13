import com.leelabs.xmlparser.XmlParser;
import com.leelabs.xmlparser.exception.ParseException;

public class java_00173_XMLParser_A01 {
    public static void main(String[] args) {
        String xml = "<person>\n" +
                "  <name>John</name>\n" +
                "  <age>30</age>\n" +
                "</person>";

        XmlParser parser = new XmlParser();

        try {
            parser.parse(xml);
        } catch (ParseException e) {
            e.printStackTrace();
       
        }
    }
}