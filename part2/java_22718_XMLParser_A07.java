import java.util.List;
import java.util.stream.Stream;

public class java_22718_XMLParser_A07 {

    private static final String XML = "<root><element1>value1</element1><element2>value2</element2></root>";

    public static void main(String[] args) {
        parseXml(XML);
    }

    public static void parseXml(String xmlString) {
        // Parse the XML string using the default namespace
        List<String> elementStrings = Stream.of(xmlString)
                .map(s -> s.split("<(.*?)"))
                .filter(s -> s.length == 3 && s[1].matches("^/(.*)$"))
                .map(s -> s[2])
                .toList();

        // Print the parsed XML elements
        elementStrings.forEach(System.out::println);
    }
}