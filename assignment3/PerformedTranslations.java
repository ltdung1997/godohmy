package assignment3;

import java.io.Serializable;

public class PerformedTranslations implements Serializable {
	private String ger;
	private String en;
	
	public PerformedTranslations() {}
	public PerformedTranslations(String ger, String en) {
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
	}
	
	
}
