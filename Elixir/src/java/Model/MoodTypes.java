package Model;

/**
 *
 * @author Ashley
 */
public enum MoodTypes {
        
        Fear, Anger, Sadness, Joy, Disgust, Surprise, Trust, Anticipation;
    
    /**
     * Used to convert mood type enum to string
     * @return string that represents the enum
     */
    public String convertToString(){
        switch (this) {
            case Fear:
                return "Fear";
            case Anger:
                return "Anger"; 
            case Sadness:
                return "Sadness";
            case Joy:
                return "Joy";
            case Disgust:
                return "Disgust";
            case Surprise:
                return "Surprise";
            case Trust:
                return "Trust";
            case Anticipation:
                return "Anticipation";    
            default:
                //Shouldnt reach this
                return "ERROR: NO ENUM! in MoodTypes";
         }
    }
    
    /**
     * Method that converts strings to enum types
     * @param mood string that represents one of the enums
     * @return enum variable
     */
    public static MoodTypes convertToMoodType(String mood){
        System.out.println("STRING PASSED INTO CONVERT TO MOOD: " + mood);
        switch (mood) {
            case "Fear":
                return Fear;
            case "Anger":
                return Anger;
            case "Sadness":
                return Sadness;
            case "Joy":
                return Joy;
            case "Disgust":
                return Disgust;
            case "Surprise":
                return Surprise;
            case "Trust":
                return Trust;
            case "Anticipation":
                return Anticipation;
            default:
                System.err.println("ERROR IN CONVERSIONS FROM STRING TO MOODTYPE");
                return null;
                
        }
    }
        
}
