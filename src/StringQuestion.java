
public class StringQuestion extends Question {

	String answer;
	
	/**
	 * Constructor
	 * @param String index 
	 * @param String questionLine 
	 */
	public StringQuestion(String index,String questionLine) {
		this.questionLine=questionLine;
		setQtype(TEXT_STRING);
		setQuesIndex(index);
	}
	
	
	//getter and setter for answer
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
		stringAnswer=answer;
	}
	
	
	/**
	 * To generate complete question to print
	 * @return String
	 */
	public String getCompleteQues() {
		String out="";
		out=out+getQuesIndex()+" "+getQuestionLine()+"\n";
		return out;
	}
	
}
