
public class SingalChoiceQuestion extends Question {
	
	int answerChoice;
	String[] choices; 
	int[] choicesCount;
	
	/**
	 * Constructor 
	 * @param String index 
	 * @param String questionLine
	 * @param String[] choice
	 */
	public SingalChoiceQuestion(String index,String questionLine,String[] choice) {
		this.questionLine=questionLine;
		this.choices=choice;
		this.choicesCount=new int[choice.length];
		setQtype(SINGAL_SELECT);
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
	 * @param int input ans (Starts from 1) 
	 * @return boolean
	 */
	public boolean setAnswerChoice(int input) {
		if(isValidAns(input)) {
			answerChoice=input;
			setStringAnswer();
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//getter for ans Choice
	public int getAnswerChoice() {
		return answerChoice;
	}
	
	
	//getter for all options or choices
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
	public void setStringAnswer() {
		stringAnswer=choices[answerChoice-1];
	}
	
	
	//getter and setter for get choice count
	public int[] getChoicesCount() {
		return choicesCount;
	}
	
	public void setChoicesCount(int[] choicesCount) {
		this.choicesCount = choicesCount;
	}
	
}
