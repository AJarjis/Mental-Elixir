/*****************************************************************************

File        : AssessmentController.java

Date        : 11-Mar-2018

Description : A class for dealing with the mental health assessment that a user
              can partipate in on their profile.

Author      : Ashley Black

******************************************************************************/

package Controller;

import Model.Assessment;
import java.util.Calendar;
import java.util.Date;

public class AssessmentController {
    
    private Assessment assessment;
    
    public AssessmentController(Assessment assessment) {
        
        this.assessment = assessment;
    }
    
    /**
     * @return the assessment score
     */
    public int getScore() {
        
        return assessment.getScore();
    }
    
    /**
     * @return the assessment date
     */
    public Calendar getDate() {
        
        return assessment.getDate();
    }
    
    /**
     * @param score
     * 
     * Description: Sets the score for the given assessment in question
     */
    public void setScore(int score) {
        
        this.assessment.setScore(score);
    } 
    
    /**
     * @param date
     */
    public void setDate(Calendar date) {
        
        this.assessment.setDate(date);
    }

}
