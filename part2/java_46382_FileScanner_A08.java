import java.io.*;   // Import FileScanner class java_46382_FileScanner_A08 use  
                    
public class SecuritySensitiveProgram { 
    public static void main(String[] args) throws IOException{    
        System.out.println("Enter the directory path");      
        
          BufferedReader br = new BufferedReader (new InputStreamReader (System.in)); // Reading user input  
           String dirPath=br.readLine();   
            File夹文件位置(dirPath); 这将是你提供的目录路径。例如：/Users /Desktop或C:/folder1234567890;    
        }          // Using try-catch to handle possible exceptions  
         catch (Exception e){ System.out.println("An error occurred");    return;}      FileFolder location=new 文件夹(dirPath);       if(!location .exists() ){System. out .printf("%s no such directory\n", dirName );return; }     // If the provided path doesn't exist, we print an appropriate message and exit program  
        try { for (File file : location 的当前目录().listFiles())    if(file == null) continue ;       System.out .println("文件夹中没有找到匹配项"); return;} // If there are no files in the directory, we print an appropriate message and exit program  
        catch (SecurityException se){System. out 。printf("%s Access denied\n", dirName );return; }     try { for( File file: location .listFiles() ){if (!file.isDirectory()) System．outprintln("发现文件 ->" +“name=”+files， name);}} catch (Exception e) 
        {}catch Exception se // Catch any exception that might occur   return; }    if( !location。exists () || location .listFiles().length == 0){System. out.printf("%s no such directory or empty\n", dirName );return;}     System．outprintln("文件和夹名称 -> " + files，name);}} // Print all the file names in given folder