import java.net.*;
import java.io.*;

public class java_04733_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("A new client has connected");

            // Denial of Service (DoS) Attack
            // This will cause the server to accept connections but won't actually process the requests
            // serverSocket.accept();

            // Create a thread for each client connection
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
       
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_04733_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {
            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Write a message to the client
            out.println("Hello Client, I am a Server!");

            // Read a message from the client
            String message = in.readLine();
            System.out.println("Server received: " + message);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}