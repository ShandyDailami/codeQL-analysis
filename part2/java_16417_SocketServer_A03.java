import java.net.*;
import java.io.*;

public class java_16417_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // spawn new thread for each connection
            new HandleConnection(socket).start();
        }
    }
}

class HandleConnection extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_16417_SocketServer_A03(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            // read request from client
            String request = in.readLine();
            System.out.println("Received: " + request);

            // handle request, respond
            String response = "Hello, you sent: " + request;
            out.println(response);

            // close connection
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}