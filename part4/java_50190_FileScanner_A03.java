import java.io.*; // Import necessary Java libraries  
class java_50190_FileScanner_A03 {   
     public static void main (String[] args){     
           File folder = new File("/path/to/your/folder");  // specify the directory here         
           findTxtFiles(folder);        }         private static int count = 0;       String extentionToSearchFor=".txt";   Scanner s=null;    public static void main (String[] args) { setFileScanner();findAllTextFilesInFolder("/"+args[1]);  //passing command line argument to this method } @Override protected FileFilter impl()    
{ return new FileFilter(){public boolean accept(File pathname){return  
pathname.getName().endsWith(extentionToSearchFor);} };    private static void findAllTextFilesInFolder (String folderPath) { s =new  Scanner(System.in);synchronized      public List<String> list= new ArrayList<>();{ try       File folder =  
new File(folderPath );File[] listOfFiles =  folder .listFiles((file, name)->  nam    e     matches("*.txt")); if (  ! listOfFiles.length > 0) { for      //iterate over each file found in the directory        }else{System.out   outprintln(folderPath + "is empty");return;}}} catch      
(Exception e){e.printStackTrace();}} private static void setFileScanner()  {}     @Override public FileFilter impl(){ return new    //filter files by extension .txt};}`         s=new Scanner (System   System.in); while((s.hasNextLine())) { count++; if(count==10){ break;}
          }      }}