import java.io.*; // Import File I/O utilities here for file handling, path manipulation etc...

    

public class java_48574_FileScanner_A01 {  

    public static void main(String[] args) throws IOException{

        String directoryPath = "path_to_directory";  // Replace with your actual Directory Path. Example: "/home/user/" or similar depending on OS and requirements...

        

        File folder = new File (directoryPath);  

            

        System.out.println("Scanning all files in " + directoryPath );   

  // Prints the names of all files present within this director..      

              for(String fileName:folder.list()) {    

            if (!fileName.endsWith(".txt")) continue;  

           File currentFile = new File (directoryPath + "/"+ fileName);  // Create a `current` or temp object to read the files..   

             try(BufferedReader br = 

                 new BufferedReader(new FileReader(currentFile))) {    

                  String line;   while ((line = br.readLine()) != null)      {}  // Do nothing with each file's content here...       }              catch (IOException e){}    }}            finally{}        );}}}          };}}};});                ;);}))}]);}},)))));,