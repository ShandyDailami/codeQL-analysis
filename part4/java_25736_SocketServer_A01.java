import java.io.*;
import java.net.*;

public class java_25736_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is listening on port 6000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client has connected");

            // Creating a new thread for each client
            Thread t = new Thread(new ClientHandler(socket));
            t.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_25736_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Creating input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Reading from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Sending a response
            out.writeBytes("Server received your message\n");

            // Closing the connection
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}