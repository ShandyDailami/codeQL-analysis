import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25620_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
           
            }

        } catch (IOException e) {
            System.out.println("Server could not be started because: " + e.getMessage());
       
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_25620_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            java.io.BufferedReader in = new java.io.BufferedReader(
                    new java.io.InputStreamReader(socket.getInputStream()));

            java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                out.println("Server: " + inputLine);
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}