import java.io.*;
import java.net.*;
import java.util.*;

public class java_01754_SocketServer_A03 {
    private static final int PORT = 8888;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                clientSocket = serverSocket.accept();

                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                // Create new thread for each client
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_01754_SocketServer_A03(Socket socket) {
        this.socket = socket;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String message;

        try {
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // TODO: Add your security-sensitive operation here.
                // Example: Injecting back into message for later reading.
                String injection = "Injected string!";
                message += injection;

                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}