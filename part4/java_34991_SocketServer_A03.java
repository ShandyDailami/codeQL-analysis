import java.io.*;
import java.net.*;

public class java_34991_SocketServer_A03 {

    private final int port = 4445;
    private ServerSocket server;

    public void startServer(int port) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server started on port " + port);
        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");
            // Create new thread to handle the client
            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }

    public static void main(String[] args) {
        try {
            SecureServer secureServer = new SecureServer();
            secureServer.startServer(4445);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ClientHandler implements Runnable {
        Socket clientSocket;

        public java_34991_SocketServer_A03(Socket socket) {
            clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    // Here is a place for a real-world application,
                    // where you might have to implement a kind of injection attack
                    // This is just a way to show how you can perform security operations
                    String response = inputLine + "\n";
                    out.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}