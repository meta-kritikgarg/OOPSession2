
public abstract class Question implements Comparable<Question> {
	String quesIndex;
	String questionLine="";
	int qType;
	String stringAnswer;
	
	int SINGAL_SELECT=1;
	int MULTI_SELECT=2;
	int TEXT_STRING=3;
	int TEXT_INTEGER=4;

	//Getter Setter Question Line
	public String getQuestionLine() {
		return questionLine;
	}
	
	public void setQuestionLine(String questionLine) {
		this.questionLine = questionLine;
	}
	
	
	//Getter Setter Question Index
	public void setQuesIndex(String quesIndex) {
		this.quesIndex = quesIndex;
	}
	
	public String getQuesIndex() {
		return quesIndex;
	}
	
	
	//Getter Setter for Qtype
	public int getQtype() {
		return qType;
	}
	
	public void setQtype(int qtype) {
		this.qType = qtype;
	}
	
	
	//getter for stringAnswer
	public String getStringAnswer() {
		return stringAnswer;
	}
	
	
	//compare interface
	@Override
	public int compareTo(Question question) {
		return this.questionLine.compareTo(question.questionLine);
	}
}
