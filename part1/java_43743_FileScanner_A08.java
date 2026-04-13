import java.io.*; // Importing necessary classes/packages  
    
public class java_43743_FileScanner_A08 { 
    public static void main(String[] args) throws IOException{     
        String directoryPath = "/path_to_your_directory";// specify your path here;      
         File fileOrDirectory = new File (directoryPath); // create a java.io instance of the object to be searched for files in this specific location  
     if(fileOrDirectory.exists()){  System.out.println("Reading all .txt and other legal textfiles from directory: " + directoryPath ); }        else {System.err.printf("%s not found.",directoryPath); return; }      File[] listOfFiles = fileOrDirectory.listFiles(); //get a array of files present in the specified location      
         for (File eachfile :  listOfFiles){     if(eachfile != null && eachfile.isFile() ){           String absolutepath  = eachfile.getAbsolutePath();// Get Absolutepath to file/directory   System.out.println("Full Path:" +absolutepath);    //Security-sensitive operation: read and delete a text files      if (eachfile.canRead()) { try{ BufferedReader br = new BufferedReader(new FileReader((File) eachfile)); String line; while ((line = br.readLine()) != null){ System.out.println("Content of file:" + "\n"+ line); }br.close();eachfile.delete();}catch (Exception e ){System.err.printf("%s cannot be read",absolutepath );}}      }}