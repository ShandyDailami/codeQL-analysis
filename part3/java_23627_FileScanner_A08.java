import java.io.File;
import java.util.Scanner;

public class java_23627_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");

        // Use a recursive method to traverse directories.
        traverseDirectory(file, 0);
    }

    private static void traverseDirectory(File file, int indent) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        // Indent the directories.
                        for (int i = 0; i < indent; i++) {
                            System.out.print("|  ");
                       
                        }
                        System.out.println("+-- " + f.getName());
                        traverseDirectory(f, indent + 1);
                    } else {
                        System.out.println(String.join("",
                                List.of("|  ",
                                        repeat("|  ", indent),
                                        "+-- ",
                                        f.getName()
                                        )
                                )
                                );
                    }
                }
            }
        }
    }

    public static String repeat(String str, int times) {
        return new String(new char[times]).replace('\0', str.charAt(0));
    }
}