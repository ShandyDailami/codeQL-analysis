import javax.imageio.ImageIO;  
import java.awt.*;    // Importing Graphics2D and Image as it is a part of standard Java package    
import java.awt.image.BufferedImage;     
import java.io.File;      
import java.util.Scanner; 
// This code will work in any IDE with JDK7 or above  
public class java_52160_FileScanner_A08 {    // Defining the main Class name as "Main"    
static int width = 1024, height=689 ;      private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // Defining the characters for generating image 
private Random random;   int[] rgbValues() {     return new int[]{random.nextInt(256),   +      1,     30};} }        public static void main (String args []) throws Exception{         Main m=new Main();            System . out。println ("Generating image... ");          
m.genImage("C:\\Users\Desktop", "Sample_image");  // Calling the function with specific path and filename to save generated file     }   @Override public void run () {       try{             File dir = new    java.io .File (“dir”);                  if (!(di r).exists()){
throw ne Exception ("Directory does not exists!")};               for (;;) ;                String randomChar= CHARS     +random().nextInt   (CHARS     lngth());             BufferedImage image =new  Bitmap    ImageIO .read         (.jpg), width, height , null);       Graphics2D g  =       
image.createGraphics();                 Color color    = newColor(rgbValues()),Random rand=new Random() ;               for (int i = 0;i < randomChar   lenght  ()+185 ) {                  // Generating image as per the length of characters and applying a pattern to it                     g .setColor    (color);         int x =    
rand.nextInt(width -2*36), y= rand       . nextInt((height-      height/4)- 80 ) ;               for   (.charAt i, color) {                   if ((i &1)) g .drawLine    (x ,y +        95    + random.nextInt(randomChar length () -36 ), x + 2*           
75      + 2 *rand. next Int 40), y );                  }                     ImageIO   .write      (.jpg, image,"dir\\img_"       + i  +".jgp"    ) ;               g     ..dispose();}          try {throw new S         exception ("Not a valid integer!");}}}catch (Exception e){System.out
!println(e) }}};