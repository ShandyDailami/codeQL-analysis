import java.util.List;
import java.util.stream.Stream;

public class java_30578_XMLParser_A03 {

    public List<String> parse(String xml) {
        // Security-sensitive operation: Injecting XML into list
        List<String> list = Stream.of(xml).toList();

        // Security-sensitive operation: Reading from list
        for (String s : list) {
            System.out.println(s);
        }

        return list;
    }

    public void parseAndPrint(String xml) {
        // Security-sensitive operation: Injecting XML into list and reading from list
        List<String> list = Stream.of(xml).toList();
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        String xml = "<root><element>text</element></root>";
        XmlParser parser = new XmlParser();
        parser.parse(xml);
        parser.parseAndPrint(xml);
    }
}