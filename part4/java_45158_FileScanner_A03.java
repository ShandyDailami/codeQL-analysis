import java.io.*; // Import necessary Java classes such FileInputStream etc...   

public class java_45158_FileScanner_A03 {    

// main method begins execution of the program        

static void scanDirectory(File directory) throws IOException     

{            

try (Stream<Path> paths = Files.newStream(directory.toPath()))       // Use a new input stream for our files and directories       

    {                

     Path file;                 

         while ((file=paths.next()) != null)     

            {                        

             if (Files.isDirectory(file, LinkOption.NOFOLLOW_SYMLINKS))       // Check whether the path is a directory or not         

                scanDirectory(file.toFile());                          // Recursive call for directories        

              else                           

                 {                            

                  String fileName = file.toString();                   // Get File Name from Path       

                        if (fileName.endsWith(".txt"))                      // Check whether the files end with .txt or not           

                           System.out.println(fileName);                     // Print out names of Text Files            

                 }                         

           }}catch (Exception e){e.printStackTrace();}                  // Catch any exception                            };                });  Try-Catch block to handle exceptions              This is the end method     static void main Method      Main Takes no arguments and calls scanDirectory on a directory named "myDir" which contains txt files in this case       

try {Main.scanDirectory(new File("MyFolder"));} catch (Exception e)          // Catch block for Exception            System error: IOException, NullPointerChecker    }  This is the end Main method     main Method      The program calls it on an argument of "myDir" which contains text files in this case