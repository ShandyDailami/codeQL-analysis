import java.io.*;
import java.net.*;

public class java_06783_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 5000;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_06783_SocketServer_A03(Socket socket) {
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
                System.out.println("Received message: " + message);
                // Perform security-sensitive operations, like sanitizing user input,
                // preventing SQL injection, or XSS attacks
                // ...

                out.println("Message received");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}