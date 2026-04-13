import java.io.File;
import java.io.FilenameFilter;
import java.io.FileVisitor;
import java.io.IOException;

public class java_00375_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        String targetFile = "targetFile.txt";

        Main fileVisitor = new Main();
        directory.accept(fileVisitor, targetFile);
    }

    public void visit(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    f.accept(this, f.getName());
                }
            }
        } else {
            visitFile(file);
        }
    }

    public void visitFile(File file) {
        if (file.getName().equals("targetFile.txt")) {
            System.out.println("Target file found!");
        }
    }
}