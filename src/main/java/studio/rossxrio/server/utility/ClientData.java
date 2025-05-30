package studio.rossxrio.server.utility;

/**
 * Class used for data structure
 */
public class ClientData {
    String alias;
    String data;

    public ClientData(String alias, String data) {
        this.alias = alias;
        this.data = data;
    }

    public String getAlias() {
        return alias;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ClientData{" +
                "alias='" + alias + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}