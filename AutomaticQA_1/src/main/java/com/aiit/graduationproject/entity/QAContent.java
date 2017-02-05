/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.entity;

/**
 * 问答内容实体类
 * <p>
 * <code>QAContent</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月27日 上午11:32:33
 * @since 1.0
 * @version 1.0
 */
public class QAContent {

	/**
	 * 问题-答案编号
	 */
	private int questionAnswerContentId;

	/**
	 * 内容
	 */
	private String questionAnswerContentContent;

	/**
	 * QA表外键
	 */
	private int fkquestionAnswerId;

	/**
	 * @return the questionAnswerContentId
	 */
	public int getQuestionAnswerContentId() {
		return questionAnswerContentId;
	}

	/**
	 * @param questionAnswerContentId
	 *            the questionAnswerContentId to set
	 */
	public void setQuestionAnswerContentId(int questionAnswerContentId) {
		this.questionAnswerContentId = questionAnswerContentId;
	}

	/**
	 * @return the questionAnswerContentContent
	 */
	public String getQuestionAnswerContentContent() {
		return questionAnswerContentContent;
	}

	/**
	 * @param questionAnswerContentContent
	 *            the questionAnswerContentContent to set
	 */
	public void setQuestionAnswerContentContent(String questionAnswerContentContent) {
		this.questionAnswerContentContent = questionAnswerContentContent;
	}

	/**
	 * @return the fkquestionAnswerId
	 */
	public int getFkquestionAnswerId() {
		return fkquestionAnswerId;
	}

	/**
	 * @param fkquestionAnswerId
	 *            the fkquestionAnswerId to set
	 */
	public void setFkquestionAnswerId(int fkquestionAnswerId) {
		this.fkquestionAnswerId = fkquestionAnswerId;
	}

	/**
	 * 无参数的构造函数
	 */
	public QAContent() {
		super();
	}

	/**
	 * 有参数的构造函数
	 * 
	 * @param questionAnswerContentId
	 * @param questionAnswerContentContent
	 * @param fkquestionAnswerId
	 */
	public QAContent(int questionAnswerContentId, String questionAnswerContentContent, int fkquestionAnswerId) {
		super();
		this.questionAnswerContentId = questionAnswerContentId;
		this.questionAnswerContentContent = questionAnswerContentContent;
		this.fkquestionAnswerId = fkquestionAnswerId;
	}
}
