import java.io.*;
import java.net.*;

public class java_17428_SocketServer_A03 {

    private ServerSocket serverSocket;

    public java_17428_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

            // Create new thread for each client
            Thread t = new Thread(new SocketServerThread(clientSocket));
            t.start();
       
        }
    }

    public static void main(String[] args) {
        try {
            SocketServer s = new SocketServer(1234);
            s.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketServerThread implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_17428_SocketServer_A03(Socket socket) {
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
        String request;
        try {
            request = in.readLine();
            System.out.println("Received: " + request);

            // Perform a basic injection prevention with the use of command injection
            // Here, we are just checking if the request contains a command, if it does, we return an error message
            if (request.contains("command")) {
                out.println("Invalid command!");
            } else {
                out.println("You said: " + request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}