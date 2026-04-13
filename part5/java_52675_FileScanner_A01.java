import java.io.*; // Import of Java built in packages 
class java_52675_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        FileScanner fs = new FileScanner();         
       System.out.println("Files and directories:" +fs);                 
         }                  
}     
// Implementation of the file scaner class without using external frameworks 
class MyFileScanner {   // Define a method named 'Myfile' which is used for scanning files in folder recursively   
       void listRec(String dir) throws IOException{             
          File f = new File (dir);                  
           if(!f.exists()) throw null;                else return ;     while (!f.isDirectory()){   // While the directory exists, print all its contents                     String[] files= folder .list();  for(String file:files)fs.printRec(" "+folder + "/" +file);   
           f = f.getParentFile ( );                  }             return;        }}