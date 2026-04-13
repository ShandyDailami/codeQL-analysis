import java.io.*;
import java.net.*;
  import javax.sound.midi.*;
public class java_44034_SocketServer_A01 {     // define a public or internal/private socket-based service to accept connections from clients..(a)
    Socket sock;                  // (b), we'll use this for communication with the client...   .e       [socket server] 15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
    ServerSocket servSock;        // (b), a socket server that waits for connections.. .e       [socket] 15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
    public java_44034_SocketServer_A01(int port) throws IOException { // (b), this is the constructor of our service... .e       [main] 15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
        servSock = new ServerSocket(port);  // (b), create a server socket listening on the specified port.. .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
    }  // (b), we'll make the server listen for connections on our service... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
    public void service() throws IOException {  // (b), the main method of our server... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
        sock = servSock.accept(); // (b), accept a connection from the client... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
        PrintWriter out = new  // (b), write the client's name on this connection.. .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
    }  // (b), we'll make the client send a welcome message on this connection.. .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
    public static void main(String args[]) {  // (b), the method that gets called to start our server... .e       [main]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
        try {  // (b), start the server... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
            new InsecureServer(  // (b), make a server on port number... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
                Integer.parseInt(args[  // (b), parse the command line argument... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
                    args[  // (b), parse the command line argument... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
                        0 ]) ) ; // (b), make a server on port number... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
        } catch (IOException e) {  // (b), handle the exceptions... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
            e.printStackTrace(); // (b), print the exception's stack trace... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
        }  // (b), end of try-catch statement... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
    }  // (b), end of main method... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB
}  // (b), end of the InsecureServer class... .e       [server]  15:48 ~        37,20     /^cdeffac9fecbf6aefttccbbddhhjjkklmnooopprstuvvwxzzzAAAAAACCCCBBB