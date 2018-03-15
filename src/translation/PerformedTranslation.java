package translation;

import java.io.Serializable;
import java.util.Observable;

public class PerformedTranslation extends Observable implements Serializable{
    private String ger;
    private String en;
    private String translationType;
    
    public PerformedTranslation(){
    	
    }
    public PerformedTranslation(String en, String ger) {
        this.ger = ger;
        this.en = en;
    }

    public String getGer() {
        return ger;
    }

    public String getEn() {
        return en;
    }

    public void setGer(String ger) {
        this.ger = ger;
    }

    public void setEn(String en) {
        this.en = en;
        setChanged();
        notifyObservers();
    }
    
    public String getTranslationType() {
    	return translationType;
    }
    
    public void setTranslationType(String translationType) {
    	this.translationType = translationType;
    }
}