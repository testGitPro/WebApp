package vhrybyniuk.web.server;

public class ResourceReader {
    private String Path;

    public String readResources(String uri){
        return this.Path + uri;
    }

    public String getWebAppPath() {
        return Path;
    }

    public void setPath(String PathToFiles) {
        this.Path = PathToFiles;
    }
}
