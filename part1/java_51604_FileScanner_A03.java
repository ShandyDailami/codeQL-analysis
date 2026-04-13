import java.io.*; // for the BufferedReader, InputFileStream and PrintWriter classes  
public class java_51604_FileScanner_A03 {   
     public static void main(String[] args) throws IOException{     
           String fileName;         
         try (BufferedReader reader = new BufferedReader 
                 (new FileReader("C:/Users/User/.config"))){              // Reading a local configuration folder. You can use your own directory also      
             int i = 0 ;                 
                     while((fileName=reader.readLine()) !=  null)     {   System.out.println(++i + ": '"+ fileName  + "'");}  }    catch (IOException e){e.printStackTrace();}}         // Exception handling for reading the files from local directory     
              public class MyFileReader{             void readLinesFromDirectory(){          File dir = new java.io.File("C:/Users/User/.config")       try(Stream<String> lines =  Files.lines (Paths .get ("file"))){         for each line in the file, do something with it           }catch (IOException e) {e.printStackTrace();}}            // You can replace 'Files' and other methods as per your requirement