import java.io.*;   // Import necessary classes from the Java Standard Library package
class java_49350_FileScanner_A08 {   
public static void main(String[] args) throws IOException  {    
         File file = new File("C:/Users/Your Directory Here");//Replace with actual directory location, e.g., "/home" or "D:\\folder".   // Declare a variable of type `File` and assign it the desired path to your folder in hard drive   
        if (file.exists()) {     // Checking whether file exists at specified locations     
            File[] listOfFiles = file.listFiles();  //Getting all files from given directory  
             for(int i=0;i<listOfFiles.length;++i){       //Loop through the Files and Folders in Directory    
                if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".txt")){    }  /*Checking for text files only*/   {      int lineCount = 0 ; String password = "password";       //Declaring the variables required//Defining data types    
                FileReader fr=new FileReader(listOfFiles[i]);        //Creates a reader using file name as parameter    Reads character at a time, stored in char variable   if((c=fr.read()) != -1)  {      while (true){               int ch = 0;    
                long pos = listOfFiles[i].length();       /*Calculate the line number when reading from file end */        }    @Override public void run(){             try{              for(int i= 5 ; true && ((ch=fr.read()) != -1 )  {   if (lineCount==4){                return;}}