import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34797_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/input.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // This line is susceptible to an SQL injection attack.
            // An attacker can manipulate the SQL statement by injecting SQL code.
            // For example, if line contains a SQL statement like "select * from users where name = 'attacker'",
            // then the attacker can change the 'attacker' to a SQL statement like "delete from users where name = 'attacker'".
            System.out.println("Line: " + line);
        }

        scanner.close();
    }
}