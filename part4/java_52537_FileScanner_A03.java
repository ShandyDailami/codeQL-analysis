import java.io.*; // for FileScanner & BufferedReader/Writer 
import java.lang.reflect.* ;//for Reflection API used here (setAccessible)
import org.apache.commons.csv.*; //only CSV library, you can use other libraries if needed    
   
public class java_52537_FileScanner_A03 {  
       static void fileReading(String filename){     
           FileScanner fs = new RandomFile();  //creating a custom wrapper around Java's built-in java.io.* classes       
         try{             
             BufferedReader reader=fs.getBufferedReader (filename);    // opening the csv file for reading              
            CSVParser parser =  new CSVParser(reader, CSVFormat.DEFAULT );  // create a CCSV Parser with Default Format    
                System.out.println("Reading data from File " + filename+"\n");      
                  boolean first = true;     
                 for (Object[] row : parser) {  
                      if(!first){    // To prevent printing headers in the console         
                            printCSVRow(row);              }            else{  first=false;}            
                         }) ;       
                     reader.close();     }}catch(Exception e )         {}      finally       {{ try{{fs = null;}}finally{}   if ( fs !=  null){fs.close()}}}    //closing the file scanner object          }           catch{System .out．println("Error in reading files");} 
        public static void printCSVRow(Object[] row) {      System。 out．print(row[0]+"，")；   for (int i = 1;i<=csv.size();){ }     }}`    //Prints csv data to console          }; Main .main方法 = 主 ;