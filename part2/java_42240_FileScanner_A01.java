import javax.imageio.*; // ImageIO for reading image file types, BufferedImage for storing the loaded images  
import java.awt.image.*; // Rendering hints like isSampleJava2DSupported etc., are used to optimize rendering performance when loading large amounts of data 
import java.nio.file.*; // Paths and Files class java_42240_FileScanner_A01 Java NIO, allows you work with files on disk as if they were objects in the file system  
import javax.imageio.stream.FileImageOutputStream; // OutputStream for writing image to a specific location (such directory) 
...    
public void scanFiles(String folderPath){   
        try {     
            Path path = FileSystems.getDefault().getPath(folderPath);      
             Files.walk(path, RecursiveOption.FOLLOW_LINKS).forEach((p)->{          //Walking through all files in the given directory        
              if (Files.isRegularFile(p)) {                  // Check file type  and not a folder     
                try (ImageInputStream stream = ImageIO.createImageInputStream(Files.newInputStream(p)))       {          
                    Iterator<ImageReader> imageReaders= ImageIO.getImageReadersByFormatName((MetadataDrawables)stream);         //Get the format of each file 
                  if (imageReaders.hasNext())     {          //Check for JPEGs,PNGS etc., in a directory   
                    ImageReader reader = imageReaders.next();     
                     while(reader.readHeader(stream)){            //Reading all headers   by getting meta data from the file      
                       BufferedImage buffImg= null;    
                      if (MetadataDrawables.TYPE_IMAGE == stream.getType()){        //Check whether it is an image or not          }           else {             continue;}  ... your other code here}               reader =imageReaders .next();      }}...continue and complete the program accordingly}}         catch(Exception e)    
                {}       });   };    try{FileImageOutputStream outputStream=new FileImageOutputS.... (filePath))}{finally { ImageIO.write() }}}} // Close image in finally block}  This is just a simple example, actual implementation might be more complex based on your needs e.g., multi-threading for large directories etc..