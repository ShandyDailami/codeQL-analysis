import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_18568_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);
        List<File> files = new ArrayList<>(List.of(directory.listFiles((dir, name) -> name.endsWith("." + fileExtension))));

        files.stream().forEach(file -> System.out.println(file.getName()));
    }
}