import java.net.*;
import java.io.*;

public class java_35865_SocketServer_A07 {

    private static final int PORT = 8080; // Port to listen for connections

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Hand off the task of processing to a new thread
            new EchoThread(socket).start();
        }
    }
}

class EchoThread extends Thread {
    private Socket socket;

    public java_35865_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println(inputLine);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}