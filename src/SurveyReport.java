import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class SurveyReport {
	
	int SINGAL_SELECT=1;
	int MULTI_SELECT=2;
	int TEXT_STRING=3;
	int TEXT_INTEGER=4;
	
	/**
	 * To get report of all the responses in a file
	 * @param ArrayList responses 
	 * @throws IOException
	 */
	public void getResponcesReport(ArrayList<ArrayList<Question>> responses) throws IOException {
		int personCounter=1;
		String data="";
		for (ArrayList<Question> arrayList : responses) {
			for (Question question : arrayList) {
				data=data+"Person "+personCounter+" "+question.getQuesIndex()+" "+question.getStringAnswer()+"\n";
			}
			personCounter++;
		}
		writeToFile(data,"ReportB");
	}
	
	
	/**
	 * To get report of all the responses(sorted) in a file 
	 * @param ArrayList responses
	 * @throws IOException
	 */
	public void getSortedResponseReport(ArrayList<ArrayList<Question>> responses) throws IOException {
		int personCounter=1;
		String data="";
		for (ArrayList<Question> arrayList : responses) {
			Collections.sort(arrayList);
			for (Question question : arrayList) {
				data=data+"Person "+personCounter+" "+question.getQuesIndex()+" "+question.getStringAnswer()+"\n";
			}
			personCounter++;
		}
		writeToFile(data,"SortedReport.txt");
	}

	
	/**
	 * To get report on analysis of single choice responses
	 * @param ArrayList responses
	 * @throws IOException
	 */
	public void getAnalysisOfResponse(ArrayList<ArrayList<Question>> responses) throws IOException {
		String data="";
		HashMap<String,ReportHelper> reportMaker = new HashMap<String, ReportHelper>();

		for (ArrayList<Question> arrayList : responses) {
			for (Question question : arrayList) {				
				if(question.qType==SINGAL_SELECT) {
					SingalChoiceQuestion temp = (SingalChoiceQuestion) question;
					if(reportMaker.containsKey(temp.quesIndex)!=true) {
						reportMaker.put(temp.quesIndex, new ReportHelper(temp.getChoices()));
					}
					reportMaker.get(temp.getQuesIndex()).increase(temp.answerChoice);
				}
			}
			
			for(String quesIndex : reportMaker.keySet()) {
				ReportHelper reportData = reportMaker.get(quesIndex);
				data =  reportData.getReport();
				
			}
		}
		
		writeToFile(data,"ReportA");
	}
	
	
	/**
	 * To write data in file
	 * @param String data 
	 * @param String filename
	 * @throws IOException
	 */
	public void writeToFile(String data,String filename) throws IOException {
		BufferedWriter bufferwriter= null;
		try {
			FileWriter filewritter= new FileWriter(filename);
			bufferwriter = new BufferedWriter(filewritter);
			bufferwriter.write(data);
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		bufferwriter.flush();
	}
	

}
