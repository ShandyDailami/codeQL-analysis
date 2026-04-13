import java.io.*; // Import the File class java_49383_FileScanner_A03 its subclasses in Java  
    import javax.imageio.*;//for ImageIO method use this line of codes if you are using image file input/output operations     
     public void main(String args[]) throws Exception { 
         String dirPath = "path to directory"; //Replace with your path and make sure the trailing slash is there. For example /Users/user_name/Desktop or C:/Program Files etc..  
           FileScanner fileScan=new ScanFile();//Create a new instance of scanfile class  you can create more instances if required   
         //Listing files in directory using recursive method with specified path and filter for image extension (jpg,png)    
          List<String> list = getImageFiles(dirPath,"*.{jpg,png}", fileScan);      File[] Files=null;  
           try { 
              if(!list.isEmpty())    //If there are any images in directory then only scan and process them         for (File singlefile : List)        SingleThreadedClassRunner(singlefile );       } catch Exception e1 {} finally{}     return null;}      private void getImagesInDirectory() {  
          try{  File dir = new java.io.File("/Users/user_name//Desktop"); //Specify your directory path here    List<String>list=new ArrayList<>(); String[] sdffiles;       fileScanner fs =  new ScanFile ();        if(dir==null) throw  
           IllegalArgumentException("Given location does not exist")  ;      FileInputStream fis = null, InputStreamReader isr  =     //is required for reading image files in byte and character wise manner    try {fis=new java.io .FileInputS         Stream("/Users/user_name//Desktop/"+fileScannerfs);  
           BufferedImage bi= ImageIO.read( fis );  int w =bi.getWidth();      for (int i = 0;i <w ; ++    //Loop through each pixel in the image     if ((bitMask & ROI_COLUMN) != 1){ continue;}   else {list!add(.jpg);} }      
           finally{if(fis