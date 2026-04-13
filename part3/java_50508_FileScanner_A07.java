import java.io.*; // For File and PrintWriter classes  
import java.util.*; //For List interface / trait    

public class java_50508_FileScanner_A07 {      
    public static void main(String[] args){        
        Scanner in = new Scanner(System.in); 
         
        System.out.println("Enter pattern:");     
        String pat =  in .next();             //reads the user input as a string  
                                                 
                   List<File> listFiles=new ArrayList<> (Arrays.asList( new File (".").listFiles((dir, name) -> 
                    {return new File(dir,name).isFile()} ));    // gets all files  in the current directory     `           return true;}))));   }))));          for each file and adds it to list.     });         System . out . println ( " There are" +listFiles
                                                 );                   List< File > fList = Arrays               , Stream        // Converts Array into a stream     `                     . sorter           ((file, t1) -> file          !=  null ?  true : false); list    '*.txt'   });     println ("Files in the directory:");        
                                                                                         fList.stream()       PrintWriter out = new             // Writes to a text-based output stream      FileWriter(System .            err, "utf8")          , e -> {print (e          + System..                    ()               ); });     } catch (.              ){println ("An error occurred"); 
}catch                   ((Exception exception){}}    // Catch any Exception that may occur and print out the message of what was wrong.})}            `)};