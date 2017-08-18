package xboxapi;

import static xboxapi.Root.Setup.GET.Default;

public class Endpoints {

    public static String XUID(String gamertag){
        return Default("xuid/"+gamertag);
    }

    public static String Profile(String xuid){
        return Default(xuid+"/profile");
    }

    public static String Gamercard(String xuid){
        return Default(xuid+"/gamercard");
    }

    public static String Presence(String xuid){
        return Default(xuid+"/presence");
    }
    public static String Activity(String xuid){
        return Default(xuid+"/activity");
    }
    public static String RecentActivity(String xuid){
        return Default(xuid+"/activity/recent");
    }
    public static String Friends(String xuid){
        return Default(xuid+"/friends");
    }
    public static String GamesWithGold(){
        return Default("xboxone-gold-lounge");
    }
    public static String JoinedClubs(String xuid){
        return Default("clubs/joined/"+xuid);
    }
    public static String SearchClub(String search){
        return Default("clubs/search/name/"+search);
    }
}
