package xboxapi;

import static xboxapi.Root.Setup.Setup.*;

public class Profile {

    public static Long Id(String json) {
        return Long(json, "id");
    }
    public static Long HostId(String json) {
        return Long(json, "hostId");
    }
    public static String Gamertag(String json) {
        return String(json, "Gamertag");
    }
    public static Long Gamerscore(String json) {
        return Long(json, "Gamerscore");
    }
    public static String Gamerpicture(String json) {
        return String(json, "GameDisplayPicRaw");
    };
    public static String AccountTier(String json) {
        return String(json, "AccountTier");
    }
    public static String Reputation(String json) {
        return String(json, "XboxOneRep");
    }
    public static Long TenurLevel(String json) {
        return Long(json, "TenurLevel");
    }
    public static String AccountColor(String json) {
        return String(json, "PreferredColor");
    }
    public static Boolean SponseredPlayer(String json){
        return Boolean(json, "isSponseredPlayer");
    }
    public static String All(String json){
         String i = "\n";
         return "ID: " + Id(json) + i +
                "Host ID: " + HostId(json) + i +
                "Gamertag: " + Gamertag(json) + i +
                "Gamerscore: " + Gamerscore(json) + i +
                "Gamerpicture: " + Gamerpicture(json) + i +
                "Account Tier: " + AccountTier(json) + i +
                "Reputation: " + Reputation(json) + i +
                "Tenur Level: " + TenurLevel(json) + i +
                "Account Color: " + AccountColor(json) + i +
                "Sponsered Player: " + SponseredPlayer(json);
    }
}
