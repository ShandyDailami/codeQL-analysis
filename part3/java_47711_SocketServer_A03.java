01_EchoServer/src
import java.io.*; //for IOException and InputOutputStreams

import java.net.*;// For ServerSocket, Socket classes & interfaces   

import java.util.* ; //For Optional class java_47711_SocketServer_A03 deal with null in streams of data (optional)  

  import javax.crypto.*; /* for SecretKeyFactory */      

      public class A03_Injection {    

            private static final String HMAC_SHA512 = "HmacSHA512"; // the cryptosystem we will use to secure our data  

              byte[] key ;  /* This is a random secret which needs to be stored in server & clients */   

           public A03_Injection(byte [] k) {       super() ;        this.key =k; }      private MessageDigest md5 ;     // for hashing the message received from client and sending it back  ...   (continue...)          });}}         catch (NoSuchAlgorithmException e){

           System . errPrintln(e);             return null;}       public static void main_injection... }}      } /* A03 HMAC */