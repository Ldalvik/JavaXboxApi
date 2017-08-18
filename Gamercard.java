package xboxapi;

import static xboxapi.Root.Setup.Setup.*;

public class Gamercard {

    public static String Name(String json) {
        return String(json, "name");
    }
    public static String Location(String json) {
        return String(json, "location");
    }
    public static String Bio(String json) {
        return String(json, "bio");
    }
    public static String Motto(String json) {
        return String(json, "motto");
    }
    public static String Tier(String json) {
        return String(json, "tier");
    }
    public static String AvatarBodyImage(String json) {
        return String(json, "AccountTier");
    }
    public static String AvatarGamerpic(String json) {
        return String(json, "gamerpicLargeImagePath");
    }
    public static String All(String json){
        String i = "\n";
        return "Name: " + Name(json) + i +
                "Location: " + Location(json) + i +
                "Bio: " + Bio(json) + i +
                "Motto: " + Motto(json) + i +
                "Tier: " + Tier(json) + i +
                "Avatar Body Image: " + AvatarBodyImage(json) + i +
                "Avatar Gamerpicture: " + AvatarGamerpic(json);
    }
}
