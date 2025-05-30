package studio.rossxrio.server;

import java.util.HashMap;

/**
 * Class meant to be a shared resource
 */
public class ServerDataBank {
    private final static HashMap<String, String> DATA_BANK = new HashMap<>();

    public static void writeData(String alias, String data) {
        if (data == null) return;
        DATA_BANK.put(alias, data);
    }

    public static String readData(String alias) {
        return DATA_BANK.get(alias);

    }

    public static HashMap<String, String> getDataBank() {
        return DATA_BANK;
    }
}
