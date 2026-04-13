import java.security.InvalidParameterException;
import java.util.Stack;
import java.util.HashMap;

public class java_16725_XMLParser_A08 {

    private Stack<String> tags = new Stack<>();
    private HashMap<String, String> tagsAttributes = new HashMap<>();

    private enum State {
        OUTSIDE,
        INSIDE_TAG,
        INSIDE_TAG_WITH_ATTRIBUTES
    }

    private State state = State.OUTSIDE;

    public void parse(String xml) {
        char[] chars = xml.toCharArray();
        for (char c : chars) {
            if (c == '<') {
                if (state == State.OUTSIDE) {
                    state = State.INSIDE_TAG;
                    tags.push("");
                } else if (state == State.INSIDE_TAG) {
                    state = State.INSIDE_TAG_WITH_ATTRIBUTES;
                    tagsAttributes.put("", "");
                }
            } else if (c == '>') {
                if (state == State.INSIDE_TAG_WITH_ATTRIBUTES) {
                    int space = tags.peek().indexOf(' ');
                    if (space != -1) {
                        String tag = tags.pop();
                        String attribute = tagsAttributes.get(tag.substring(0, space));
                        tagsAttributes.remove(tag);
                        // Here you would typically perform the security-sensitive operation.
                        // For example, you may check if the attribute contains sensitive information.
                        // If it does, you may reject the connection or change the attribute.
                    }
                    state = State.OUTSIDE;
                } else if (state == State.INSIDE_TAG) {
                    tags.pop();
                    state = State.OUTSIDE;
                }
            } else if (state == State.INSIDE_TAG_WITH_ATTRIBUTES) {
                int space = tags.peek().indexOf(' ');
                if (space != -1) {
                    String tag = tags.pop();
                    String attribute = tagsAttributes.get(tag.substring(0, space));
                    tagsAttributes.remove(tag);
                    // Here you would typically perform the security-sensitive operation.
                    // For example, you may check if the attribute contains sensitive information.
                    // If it does, you may reject the connection or change the attribute.
                }
            }
            if (state == State.OUTSIDE && c != '<') {
                throw new InvalidParameterException("Unclosed tag");
            }
            if (state == State.INSIDE_TAG_WITH_ATTRIBUTES && c != '>') {
                throw new InvalidParameterException("Unclosed attribute");
            }
            if (state == State.INSIDE_TAG && c != '>') {
                throw new InvalidParameterException("Unclosed tag");
            }
            if (state != State.OUTSIDE && c != ' ') {
                tags.peek() += c;
            }
        }
        if (state != State.OUTSIDE) {
            throw new InvalidParameterException("Unclosed tag");
        }
    }
}