package external;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import translation.PerformedTranslation;
import translation.SavePerformedTranslations;

public class ExternalDatabase {
    private SavePerformedTranslations savePerformedTranslations;

    public ExternalDatabase() {
    }

    public SavePerformedTranslations getSavePerformedTranslations() {
        return savePerformedTranslations;
    }

    public void setSavePerformedTranslations(SavePerformedTranslations savePerformedTranslations) {
        this.savePerformedTranslations = savePerformedTranslations;
    }

    public void storePerformedTranslations() throws IOException {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("G:\\testout.txt"));
	        oos.writeObject(savePerformedTranslations.getPerformedTranslations());
	        System.out.println("Success...");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        oos.close();
	    }
	}
	
	public SavePerformedTranslations LoadPerformedTranslations() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("G:\\testout.txt"));
			savePerformedTranslations =  (SavePerformedTranslations) ois.readObject();
			for(PerformedTranslation pt: savePerformedTranslations.getPerformedTranslations()) {
				System.out.println(pt.getEn()+ " " +pt.getGer());
			}	
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			ois.close();
		}
		return savePerformedTranslations;
	}
}