package studio.rossxrio.client;

import java.util.LinkedList;
import java.util.List;

/**
 * Class meant to be a shared resource
 */
public class ClientDataBank {
    private final static List<String> DATA_BANK = new LinkedList<>();

    public static void writeData(String str) {
        if (str == null) return;
        DATA_BANK.add(str);
    }

    public static String readData(int i) {
        String getDataBank;
        try {
            getDataBank = DATA_BANK.get(i);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return getDataBank;

    }

    public static List<String> getDataBank() {
        return DATA_BANK;
    }
}