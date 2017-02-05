/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.entity;

/**
 * 问答对实体类
 * <p>
 * <code>QAnswer</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月27日 上午11:28:27
 * @since 1.0
 * @version 1.0
 */
public class QAnswer {

	/**
	 * 问题-答案编号
	 */
	private int questionAnswerId;

	/**
	 * 问题
	 */
	private String question;

	/**
	 * 答案
	 */
	private String answer;

	/**
	 * @return the questionAnswerId
	 */
	public int getQuestionAnswerId() {
		return questionAnswerId;
	}

	/**
	 * @param questionAnswerId
	 *            the questionAnswerId to set
	 */
	public void setQuestionAnswerId(int questionAnswerId) {
		this.questionAnswerId = questionAnswerId;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * 无参数的构造函数
	 */
	public QAnswer() {
		super();
	}

	/**
	 * 有参数的构造函数
	 * 
	 * @param questionAnswerId
	 * @param question
	 * @param answer
	 */
	public QAnswer(int questionAnswerId, String question, String answer) {
		super();
		this.questionAnswerId = questionAnswerId;
		this.question = question;
		this.answer = answer;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QAnswer [questionAnswerId=" + questionAnswerId + ", question=" + question + ", answer=" + answer + "]";
	}
}
