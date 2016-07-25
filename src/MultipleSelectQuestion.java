
public class MultipleSelectQuestion extends Question {
	
	int[] answerChoice;
	String[] choices; 

	/**
	 * Constructor 
	 * @param String index 
	 * @param String questionLine
	 * @param String[] choice
	 */
	public MultipleSelectQuestion(String index,String questionLine,String[] choice) {
		
		this.questionLine=questionLine;
		this.choices=choice;
		setQtype(MULTI_SELECT);
		setQuesIndex(index);
	}
	
	
	/**
	 * Check input ans is valid or not
	 * @param int input choice (Starts from 1) 
	 * @return boolean
	 */
	public boolean isValidAns(int input) {
		if(input<=choices.length&&input>0) {
			return true;
		}
		else {
			return false;
		}			
	}
	
	
	/**
	 * To set answer 
	 * @param int[] input array  (index Starts from 1) 
	 * @return boolean
	 */
	public boolean setAnswerChoices(int[] input) {
		for (int i : input) {
			if(!isValidAns(i)) {
				return false;
			}
		}
		answerChoice=new int[input.length];
		for (int i = 0; i < input.length; i++) {
			answerChoice[i]=input[i];
		}
		setStringAnswer();
		return true;
	}
	
	
	//getter and setter for answerChoices
	public int[] getAnswerChoice() {
		return answerChoice;
	}
	
	public String[] getChoices() {
		return choices;
	}
	
	
	/**
	 * To generate complete question to print
	 * @return String
	 */
	public String getCompleteQues() {
		String out="";
		out=out+getQuesIndex()+" "+getQuestionLine()+"\n";
		for (String string : getChoices()) {
			out=out+string+"\n";
		}
		return out;
	}
	
	
	//Setter for stringAnswer
	private void setStringAnswer() {
		for (int i = 0; i < answerChoice.length; i++) {
			if(stringAnswer==null) { 
				stringAnswer="";
			}
			stringAnswer =stringAnswer+" "+ choices[answerChoice[i]-1]+" ";
		}
	}

}
