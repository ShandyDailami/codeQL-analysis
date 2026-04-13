import java.*;

import java.io.*;    // Import of IOException, Serializable etc...     from Java standard library (Java.*).       These are all needed imports for any code that uses these classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with IO operations or network programming tasks such connections on sockets.

import java.net.*;   // Import of InetAddress, ServerSocket etc...    from Java standard library (Java.*).       These are all needed imports for any code that uses these classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with network programming tasks such connection on sockets.

import java.util.*;  // Import of ArrayList etc...                    from Java standard library (Java.*).       These are all needed imports for any code that uses these classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with data structures such array lists or sockets connections, etc..

import java.security.*;  // Import of MessageDigestCipher    from Java standard library (Java.*).       These are all needed imports for any code that uses these classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with security-sensitive operations such hashing or encryption.

 

public class java_52366_SocketServer_A03 {   // Defining the Class which is going to act like a server side Socket Server    using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks.

{   // Defining the Class which is going to act like a server side Socket Server    using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks.

  // Creating an ArrayList of type InetSocketAddress which can hold the client sockets information, using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks.

  private List<InetSocketAddress> clients = new ArrayList<>();   // Defining the list of client sockets information using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks.

  private ListenningSocket listenSock;   // Defining the server listening socket information using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks.

  private Socket sock_new;   // Defining the client socket information using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks.

  private InputStream inputSock_new;   // Defining the socket's stream information using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks.

  private OutputStream outputSock_new;   // Defining the socket's stream information using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks.

  private MessageDigest md;   // Defining the cryptographic hash function, using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with security-sensitive operations such hashing or encryption.

  private static final int PORT = 8091;   // Defining the port number using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks.

  private static final String IP_ADDRESS = "localhost";   // Defining the server's ip address using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks.

  private static final int BUF_SIZE = 1024;   // Defining the buffer size, using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks.

  private static final String ALGORITHM = "SHA-256";   // Defining the cryptographic hash function, using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with security sensitive operations such hashing or encryption.

  public java_52366_SocketServer_A03() throws IOException   // Defining the constructor using java.* standard libraries (java.*;).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks, such opening or closing of sockets.

  {   

      // Constructor body here if necessary...   from Java standard library (Java.*).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks, such opening or closing of sockets.

  }     // Constructor body here if necessary...   from Java standard library (Java.*).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks, such opening or closing of sockets.

  public static void main(String[] args) throws Exception   // Defining the Main Method here if necessary...    from Java standard library (Java.*).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks, such opening or closing of sockets.

  {   // Defining the Main Method here if necessary...    from Java standard library (Java.*).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks, such opening or closing of sockets.

  }     // Defining the Main Method here if necessary...    from Java standard library (Java.*).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks, such opening or closing of sockets.

}   // Defining the Main Class here if necessary...    from Java standard library (Java.*).       These are all needed imports for any code that uses this classes/objects in its entirety and should be used everywhere as possible due to their importance when dealing with networking tasks, such opening or closing of sockets.