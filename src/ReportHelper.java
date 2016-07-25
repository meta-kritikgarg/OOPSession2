
public class ReportHelper {
	String[] choices;
	int[] choiceCounter;
	float[] percent;
	int total;
	public ReportHelper(String[] tchoices) {
		int length = tchoices.length;
		setChoices(tchoices);
		choiceCounter = new int[length];
		percent= new float[length];
		for (int i = 0; i < choiceCounter.length; i++) {
			choiceCounter[i]=0;
			percent[i]=0;
		}
		total=0;
	}
	

	/**
	 * To increase choiceCount
	 * @param int choice indexed from 1
	 */
	public void increase(int choice) {
		choiceCounter[choice-1]++;
		total++;
	}
	
	
	/**
	 * To set choices for question report
	 * @param String[] choices
	 */
	public void setChoices(String[] choices) {
		this.choices = choices;
	}
	
	
	/**
	 * To calculate percentage and set in percent
	 */
	public void calculatePercentage() {
		for (int i = 0; i < percent.length; i++) {
			percent[i]= ((float)choiceCounter[i]/(float)total)*100;
		}
	}
	
	
	/**
	 * to get final report
	 * @return String 
	 */
	public String getReport() {
		calculatePercentage();
		String outputData= "";
		for (int i = 0; i < choiceCounter.length; i++) {
			outputData = outputData + choices[i] +"  " + percent[i]+"% \n";
		}
		return outputData;
	}

}
