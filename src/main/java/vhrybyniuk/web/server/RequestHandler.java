package vhrybyniuk.web.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class RequestHandler {
    private BufferedReader socketReader;
    private BufferedWriter socketWriter;
    private String PathToFiles;

    public RequestHandler(BufferedReader socketReader, BufferedWriter socketWriter, String Path) {
        this.socketReader = socketReader;
        this.socketWriter = socketWriter;
        this.PathToFiles = Path;
    }

    public void handle() throws IOException {
        RequestParser requestParser = new RequestParser();



        Request request = requestParser.parseRequest(this.socketReader);
        ResourceReader resourceReader = new ResourceReader();
        resourceReader.setPath(PathToFiles);
        ResponseWriter writer = new ResponseWriter();

        writer.SendRepsonse(resourceReader.readResources(request.getUri()), socketWriter);
    }

    public BufferedReader getSocketReader() {
        return socketReader;
    }

    public void setSocketReader(BufferedReader socketReader) {
        this.socketReader = socketReader;
    }

    public BufferedWriter getSocketWriter() {
        return socketWriter;
    }

    public void setSocketWriter(BufferedWriter socketWriter) {
        this.socketWriter = socketWriter;
    }

    public String getWebAppPath() {
        return PathToFiles;
    }

    public void setWebAppPath(String webAppPath) {
        this.PathToFiles = webAppPath;
    }
}
