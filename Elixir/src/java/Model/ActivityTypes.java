package Model;

/**
 *
 * @author Ashley
 */
public enum ActivityTypes {
    
    Body, Mind, Communication, Stress, Love;
    
    /**
     * Used to convert activity type enum to string
     * @return string that represents the enum
     */
    public String convertToString(){
        switch (this) {
            case Body:
                return "Body";
            case Mind:
                return "Mind";
            case Communication:
                return "Communication";
            case Stress:
                return "Stress";
            case Love:
                return "Love";
            default:
                //Shouldn't be able to reach this
                return "ERROR: NO ENUM! in ActivityTypes";
        }
    }
    
    /**
     * Method that converts string to enum type
     * @param activity string that represents one of the enums
     * @return enum var
     */
    public static ActivityTypes convertToActivityType(String activity){
        switch (activity) {
            case "Body":
                return Body;
            case "Mind":
                return Mind;
            case "Communication":
                return Communication;
            case "Stress":
                return Stress;
            case "Love":
                return Love;
            default:
                System.err.println("ERROR IN CONVERSIONS FROM STRING TO ACTIVITYTYPE");
                return null;
        }
    }
}
