import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class java_11440_FileScanner_A07 {

    private static final String DIRECTORY = "/path/to/directory";
    private static final String EXTENSION = ".*\\.java$";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.matches(EXTENSION));
        if (files == null) return;

        List<String> authFailures = Arrays.stream(files)
                .map(AuthFailureChecker::findAuthFailures)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        if (authFailures.isEmpty()) {
            System.out.println("No security-sensitive operations found related to A07_AuthFailure.");
        } else {
            System.out.println("Security-sensitive operations related to A07_AuthFailure: " + authFailures);
        }
    }

    private static List<String> findAuthFailures(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    return Arrays.stream(line.split(" "))
                            .filter(s -> s.matches(".*\\bA07_AuthFailure\\b.*"))
                            .collect(Collectors.toList());
                }
            }
        }
        return Arrays.asList();
    }
}