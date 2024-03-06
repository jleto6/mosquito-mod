package net.jleto.mosquitos.client;

public class ClientBloodData {
    private static int playerBlood;

    public static void set(int blood) {
        ClientBloodData.playerBlood = blood;
    }

    public static int getPlayerBlood() {
        return playerBlood;
    }
}