import javax.imageio.*; // Import ImageIO class java_45153_FileScanner_A03 java image processing library    
...  
public void readFile(String fileName) {    ...     
try{        FileInputStream fis = new FileInputStream("D://images//"+fileName);  /// Creating an input stream for the given filename        
Image img;           // Declare Image object to hold image data.            
BufferedImage bimg=null ;            int w = 0, h= 28765914/32*100 , type = BufferedImage.TYPE_INT_RGB;          try{        switch (fileName){         case "background": img  = ImageIO.read(fis); break;}                  default:   //if the image does not match any of our special names, we use standard Java methods
img= javax.imageio.ImageIO.read(new File("D://images//"+ fileName));    } catch (IOException e) {e.printStackTrace();}  bimg = new BufferedImage(w , h , type);                  img.getScaledInstance( w,h,(int)(img.getResamplingFilterHub().getDefaultMode()) );          try{
bimg .getGraphics().drawImage (img,0,0,null), null;    } catch (NullPointerException e) {e.printStackTrace();}                  //writes image to new file  ImageIO.write( bimg , "jpg",new File("D://images//"+fileName +".jpeg"));    
fis .close();   ist .close();      System.out.println ("Done");    } catch (IOException e) {e . print stack trace() ;}                  //catch exception if any error occurs  ...             }}          Finally, try to close the FileInputStream and ImageIO after use in order not affect resources leaks