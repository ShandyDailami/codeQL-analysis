import java.io.*;
import java.net.*;

public class java_16105_SocketServer_A03 {

    private int port;
    private File serverDirectory;

    public java_16105_SocketServer_A03(int port, File serverDirectory) {
        this.port = port;
        this.serverDirectory = serverDirectory;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Write the file list to the socket
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Files in directory:");

            File[] files = serverDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    out.println(file.getName());
                }
            }

            // Read the file name from the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String fileName = in.readLine();
            System.out.println("Sending file: " + fileName);

            File file = new File(serverDirectory, fileName);
            if (file.exists()) {
                out.println("Sending file contents to client");
                sendFile(new FileInputStream(file), socket.getOutputStream());
            } else {
                out.println("File not found");
            }

            socket.close();
        }
    }

    private void sendFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
    }

    public static void main(String[] args) throws IOException {
        File serverDirectory = new File(".");
        SocketServer server = new SocketServer(8080, serverDirectory);
        server.start();
    }
}