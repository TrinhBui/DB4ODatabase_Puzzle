package btn.k23.dhcantho.db4odatabase;

/**
 * Created by sonlonglxag on 12/9/16.
 */

public class Question {
    public int ID;
    public String SAMPLE;
    public String QUESTION;
    public String ANSWER;
    public String OPTA;
    public String OPTB;
    public String OPTC;
    public String OPTD;

    public Question(int ID, String SAMPLE, String QUESTION, String ANSWER, String OPTA, String OPTB, String OPTC, String OPTD) {
        this.ID = ID;
        this.SAMPLE = SAMPLE;
        this.QUESTION = QUESTION;
        this.ANSWER = ANSWER;
        this.OPTA = OPTA;
        this.OPTB = OPTB;
        this.OPTC = OPTC;
        this.OPTD = OPTD;
    }

    public Question() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSAMPLE() {
        return SAMPLE;
    }

    public void setSAMPLE(String SAMPLE) {
        this.SAMPLE = SAMPLE;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }

    public String getOPTA() {
        return OPTA;
    }

    public void setOPTA(String OPTA) {
        this.OPTA = OPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public void setOPTB(String OPTB) {
        this.OPTB = OPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public void setOPTC(String OPTC) {
        this.OPTC = OPTC;
    }

    public String getOPTD() {
        return OPTD;
    }

    public void setOPTD(String OPTD) {
        this.OPTD = OPTD;
    }
}
