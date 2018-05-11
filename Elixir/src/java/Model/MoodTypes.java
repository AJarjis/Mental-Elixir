package Model;

/**
 *
 * @author Ashley
 */
public enum MoodTypes {
        
        Fear, Anger, Sadness, Joy, Disgust, Surprise, Trust, Anticipation;
        
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
                return "ERROR: NO ENUM! in MoodTypes";
         }
        
    }
}
