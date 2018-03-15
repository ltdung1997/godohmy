package translation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class SavePerformedTranslations implements Observer {
    private List<PerformedTranslation> performedTranslations = new ArrayList<PerformedTranslation>();
    private int numCount;
    private int phraseCount;
    private int illegalCount;
    
	private static SavePerformedTranslations instance;
	private SavePerformedTranslations() {}
	
	public static SavePerformedTranslations getInstance() {
		if(instance == null) {
			instance = new SavePerformedTranslations();
		}
		return instance;
	}

    public List<PerformedTranslation> getPerformedTranslations() {
        return performedTranslations;
    }

    public void add(PerformedTranslation performedTranslation) {
        performedTranslations.add(performedTranslation);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		PerformedTranslation performedTranslation = (PerformedTranslation) arg0;
		if(performedTranslation.getTranslationType().equals("num")) numCount ++;
		else if(performedTranslation.getTranslationType().equals("phrase")) phraseCount++;
		add(performedTranslation);
	}
	
	public int getNumCount() {
		return numCount;
	}
	
	public int getPhraseCount() {
		return phraseCount;
	}
	
	public void setIllegalCount(int illegalCount) {
		this.illegalCount = illegalCount;
	}
	
	public int getIllegalCoutn() {
		return illegalCount;
	}
	

    
    
}
