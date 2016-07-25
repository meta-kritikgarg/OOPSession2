
public class NumberQuestion extends Question {

	int answer;
	
	/**
	 * Constructor
	 * @param String index
	 * @param String questionLine
	 */
	public NumberQuestion(String index,String questionLine) {
		this.questionLine=questionLine;
		setQtype(TEXT_STRING);
		setQuesIndex(index);
	}
	
	
	//getter and setter for answer
	public int getAnswer() {
		return answer;
	}
	
	public void setAnswer(int answer) {
		this.answer = answer;
		stringAnswer = String.valueOf(answer);
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
