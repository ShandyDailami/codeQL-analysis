import java.io.*;
import java.net.*;
import java.util.*;

public class java_29923_SocketServer_A03 {

    // define a port number
    private static final int PORT = 9876;

    public static void main(String[] args) {

        // create a server socket and bind it to the specified port
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            // infinite loop to accept multiple client connections
            while (true) {
                try {
                    // accept a new client connection
                    Socket socket = serverSocket.accept();

                    // create a new thread to handle the client connection
                    new HandleClientThread(socket).start();

                } catch (IOException e) {
                    System.out.println("IOException was caught");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("IOException was caught when trying to listen on port " + PORT);
            e.printStackTrace();
        }
    }
}

// Thread for handling client connections
class HandleClientThread extends Thread {
    private Socket socket;

    public java_29923_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read a string from the client
            String clientInput = in.readUTF();

            // process the input string (security-sensitive operation)
            clientInput = processInput(clientInput);

            // send the processed input string back to the client
            out.writeUTF(clientInput);

        } catch (IOException e) {
            System.out.println("IOException was caught while reading or writing data");
            e.printStackTrace();
        }
    }

    // security-sensitive operation for injection
    private String processInput(String input) {
        // this operation is not secure, it is just for demonstration
        return input.toUpperCase();
    }
}