import java.util.Stack;
import java.util.StringTokenizer;

public class java_09498_XMLParser_A07 {

    private final String xml;
    private final StringTokenizer st;
    private Stack<String> tags = new Stack<>();

    public java_09498_XMLParser_A07(String xml) {
        this.xml = xml;
        st = new StringTokenizer(xml);
    }

    public void parse() {
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("<")) {
                if (st.hasMoreTokens()) {
                    if (st.nextToken().equals("/>")) {
                        if (!tags.isEmpty()) {
                            tags.pop();
                        }
                    } else {
                        if (!tags.isEmpty()) {
                            System.out.println(tags.peek() + ">");
                        }
                    }
                } else {
                    System.out.println("/>");
                }
            } else if (token.startsWith("</")) {
                if (tags.isEmpty()) {
                    System.out.println("Error: /> found outside of tags");
                    return;
                }
                String tag = tags.pop();
                if (tag.length() == 0) {
                    System.out.println("/>");
                } else {
                    System.out.println(tag + ">");
                }
            } else if (!tags.isEmpty()) {
                tags.push(token);
                System.out.print(token + " ");
            } else {
                System.out.print(token);
            }
        }
        if (!tags.isEmpty()) {
            System.out.println("Error: </> tags mismatch");
        }
    }

    public static void main(String[] args) {
        String xml = "<root><name>John</name><age>25</age><city>New York</city></root>";
        new XMLParser(xml).parse();
    }
}