import java.io.*;
import javafx.scene.control.Alert;
import javax.swing.filechooser.FileSystemView;  
class java_43903_FileScanner_A01 {    
    public static void main(String[] args) throws Exception{     
        File file = new File(".");  // The current directory is selected as the initial path      
         try (DirectoryStream<Path> stream =  Files.newDirectoryStream(file.toPath(), "*.java"))   {    
            for (Path entry : stream){   
                System.out.println("\nProcessing: ");     
               File fileToCheck =entry.toFile();  // Constructs a `BasicFileAttributes` instance from the given path's attributes         
             if (!fileToCheck .canRead() ) {   } else{    
                  Alert alert=new Alert(Alert.AlertType.INFORMATION);   
                 alert.setHeaderText("Access Denied");      //Sets header text for the pop-up window  message         
                String details = "You do not have read access to this file: \n" +fileToCheck .getAbsolutePath();       
                  alert.setContentText(details);            //Set content of Alert box             
                 alert.showAndWait();                      //Display the pop-up message  and wait for user's response          }    }}       catch (Exception e){ System.out.println("Error: "+e );}     
        FileSystemView fsv =FileSystemView.getFileSystemView();    
         String sdi=fsv .getHomeDirectory().toString() ;  //Returns the user's home directory    }   catch (Exception e){ System.out.println("Error: "+e );}      }}