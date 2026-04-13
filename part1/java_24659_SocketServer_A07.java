import java.io.*;
import java.net.*;

public class java_24659_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // open port 1234 for connections
            System.out.println("Server is listening on port 1234...");

            while (true) {
                Socket socket = serverSocket.accept(); // accept a connection
                System.out.println("A client has connected...");

                // create new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_24659_SocketServer_A07(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // perform security-sensitive operation
                if ("auth".equals(message)) {
                    out.println("Auth successful");
                } else {
                    out.println("Auth failed");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}