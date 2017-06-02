package cn.sfturing.entity;

/**
 * 
 * @author sfturing
 *
 * @date 2017年6月2日
 */
public class HelpQA {
	// id
	private int id;
	// 问题类型
	private String questionType;
	// 问题
	private String question;
	// 回答
	private String answer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "HelpQA [id=" + id + ", questionType=" + questionType + ", question=" + question + ", answer=" + answer
				+ "]";
	}

}
