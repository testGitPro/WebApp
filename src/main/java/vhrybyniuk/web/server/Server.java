package vhrybyniuk.web.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int port;

    private String PathToFiles;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPathToFiles() {
        return PathToFiles;
    }

    public void setPathToFiles(String pathToFiles) {
        this.PathToFiles = pathToFiles;
    }


    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.setPort(8080);
        server.setPathToFiles("src/main/resources/web/");

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(server.getPort());
                 Socket socket = serverSocket.accept();
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                RequestHandler requestHandler = new RequestHandler(bufferedReader, bufferedWriter, server.getPathToFiles());
                requestHandler.handle();
            }
        }

    }

}
