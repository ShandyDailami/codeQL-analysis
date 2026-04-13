import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_33489_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = input.nextLine();

        File directory = new File(".");

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.getName().equals(fileName)) {
                    try {
                        if (file.canRead()) {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                            }
                            fileScanner.close();
                        } else {
                            System.out.println("The file can't be read. Access rights are denied.");
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("The file cannot be found.");
                    }
                }
            }
        }
        input.close();
    }
}