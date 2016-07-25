import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Survey {
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		Survey s  = new Survey();
		BufferedReader in;
		String line;
		
		ArrayList<ArrayList<Question>> person = new ArrayList<ArrayList<Question>>();
		int noPerson= s.getIntfromUser("Persons");
		
		for (int personCounter = 0; personCounter < noPerson; personCounter++) {	
		ArrayList<Question> questionList = new ArrayList<Question>();		
		in = new BufferedReader(new FileReader("question.txt"));
		
		//Loop to read file line by line
		while((line=in.readLine())!=null) {
				//Split line
				String[] lineElements=line.split(",");
				
				//Single Choice
				if(lineElements[2].contains("Single")) {
						SingalChoiceQuestion q = new SingalChoiceQuestion(lineElements[0],lineElements[1], lineElements[3].split("/"));
						System.out.println(q.getCompleteQues());
						int ans =0;
						while(true) {
							ans=s.getIntfromUser("Choice");
							if(q.setAnswerChoice(ans)) {
									break;
								}
							else { 
									System.out.println("Invalid Choice");
								}
						}
						questionList.add(q);					
					}
				
				//Multiple Choice
				if(lineElements[2].contains("Multi")) {
					MultipleSelectQuestion q = new MultipleSelectQuestion(lineElements[0],lineElements[1], lineElements[3].split("/"));
					System.out.println(q.getCompleteQues()+"Press 0 at the end");
					int ans=-1 ;
					//To store choices
					ArrayList<Integer> tmp= new ArrayList<Integer>();
					while(ans!=0) {
						while(true) {
							ans=s.getIntfromUser("Choice");
							if(q.isValidAns(ans)) {
								if(!tmp.contains(ans)) {
									tmp.add(ans);
								}
								break;
							}
							else {
									if(ans==0) {	
										break; 
									}
								System.out.println("Invalid Choice, Try again");
							}
						}
					}
					
					//Array list to array conversion
					int[] tmp2 = new int[tmp.size()];
					for (int i = 0; i < tmp2.length; i++) {
						tmp2[i]=tmp.get(i);
					}
					
					q.setAnswerChoices(tmp2);
					questionList.add(q);					
				}
				
				//Text Input
				if(lineElements[2].contains("Text")) {
					StringQuestion q = new StringQuestion(lineElements[0], lineElements[1]);
					System.out.println(q.getCompleteQues());
					System.out.println("Enter Ans");
					String tmp = s.getStringfromUser("String");	
					q.setAnswer(tmp);
					questionList.add(q);
				}
				
				//Number Input
				if(lineElements[2].contains("Num")) {
					NumberQuestion q = new NumberQuestion(lineElements[0], lineElements[1]);
					System.out.println(q.getCompleteQues());
					int tmp=s.getIntfromUser("INT");
					q.setAnswer(tmp);
					questionList.add(q);
				}
				
			}
		
			in.close();
			person.add(questionList);
		}
		SurveyReport sr = new SurveyReport();
		sr.getResponcesReport(person);
		sr.getSortedResponseReport(person);
		sr.getAnalysisOfResponse(person);
	}
	
	
		/**
		* Method to read integer data from standard input
		* @param Name of variable to print 
		* @return int value of integer
		*/
		public int getIntfromUser(String Name) {
			Scanner s= new Scanner(System.in);
			int number = 0;		
			while(true){
				try {
					System.out.println("Enter "+Name);
					number=s.nextInt();
					if(number>=0) {
						break;
					}
					else {
						System.out.println("Invalid, Try Again");
					}
				} catch (Exception e) {
					System.out.println("Invalid, Try again");
					s.next();
				}
			}
			return number;
		}
			
		
		/**
		 * Method to read string data from standard input
		 * @param Name of variable to print 
		 * @return String value input by user
		 */
		public String getStringfromUser(String Name) {
			Scanner s= new Scanner(System.in);
			String string = "";		
			while(true) {
				try {
					System.out.println("Enter "+Name);
					string=s.next();
					if(string.length()>0) {
						break;
					}
					else {
						System.out.println("Invalid, Try Again");
					}
				} catch (Exception e) {
					System.out.println("Invalid, Try again");
					s.next();
				}
			}
			return string;
		}


			

}
