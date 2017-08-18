package xboxapi;

import org.json.simple.JSONObject;
import xboxapi.Root.Setup.Setup;

import static xboxapi.Root.Setup.Setup.String;
import static xboxapi.Root.Setup.Setup.objString;
import static xboxapi.Root.Setup.Utils.deleteAfter;
import static xboxapi.Root.Setup.Utils.delete_to;

public class Presence {

    public static String State(String json) {
        return String(json, "state");
    }
    private static JSONObject LastSeen(String json){
        return Setup.JSONObject(json, "lastSeen");
    }
    public static String Device(String json, Boolean isOnline){
        String device = "User is online; Cannot display 'Device'";
        if(isOnline==false){
            device = objString(LastSeen(json), "deviceType");
        }else if(isOnline==true){
            device = "User is online; Cannot display 'Device'";
        }
        return device;
    }
    public static String LastSeenPlaying(String json, Boolean isOnline){
        String lastplayed = "User is online; Cannot display 'LastSseenPlaying'";
        if(isOnline==false) {
            lastplayed = objString(LastSeen(json), "titleName");
        } else if(isOnline==true){
            lastplayed = "User is online; Cannot display 'LastSseenPlaying'";
        }
        return lastplayed;
    }
    public static String LastSeenOnline(String json, Boolean isOnline){
        String lastplayed = null;
        if(isOnline==false) {
            lastplayed = objString(LastSeen(json), "timestamp");
        } else if(isOnline==true){
            lastplayed = "User is online; Cannot display 'LastSeenOnline'";
        }
        return lastplayed;
    }
    public static String CurrentActivity(String json, Boolean isOnline){
        String activity = null;
        if(isOnline==true) {
            try {
            String trimOne = delete_to(json, "},{\"id\"");
            String trimTwo = deleteAfter(trimOne, "]}]}");
            String jsonString = "{\"id\"" + trimTwo;
            JSONObject activityObj = Setup.JSONObject(jsonString, "activity");
            activity = objString(activityObj, "richPresence");
            }catch(StringIndexOutOfBoundsException e) {
                activity = "StringIndexOutOfBoundsException: Cannot display 'CurrentActivity'";
            }
        } else if(isOnline==false) {
            activity = "User is offline; Cannot display 'CurrentActivity'";
        }
        return activity;
    }
    public static String CurrentGame(String json, Boolean isOnline){
        String game = null;
        if(isOnline==true) {
            try {
                String trimOne = delete_to(json, "},{\"id\"");
                String trimTwo = deleteAfter(trimOne, "]}]}");
                String jsonString = "{\"id\"" + trimTwo;
                game = String(jsonString, "name");
            }catch(StringIndexOutOfBoundsException e){
                game = "StringIndexOutOfBoundsException: Cannot display 'CurrentGame'";
            }
            } else if (isOnline == false) {
                game = "User is offline; Cannot display 'CurrentGame'";
            }
        return game;
    }
    public static String All(String json, Boolean isOnline){
        String i = "\n";
        return "State: " + State(json) + i +
               "Device: " + Device(json, isOnline) + i +
               "Last Seen Playing: " + LastSeenPlaying(json, isOnline) + i +
               "Last Seen Online: " + LastSeenOnline(json, isOnline) + i +
               "Current Game: " + CurrentGame(json, isOnline) + i +
               "Current Activity: " + CurrentActivity(json, isOnline);
    }
}
