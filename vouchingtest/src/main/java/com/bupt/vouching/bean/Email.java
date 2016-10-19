package com.bupt.vouching.bean;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 邮件实体
 * 
 * @author Hogan
 * 
 */
public class Email {

	private String emailId;
	private String senterId;
	private String senterEmail;
	private String senterName;
	private String receiveId;
	private String receiveEmail;
	private String receiveName;
	private String subject;
	private String content;
	private Integer isRead;
	private Date sentDate;
	private Integer sentDel;
	private Integer receiveDel;
	@SuppressWarnings("unused")
	private String formatSentDate;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSenterId() {
		return senterId;
	}

	public void setSenterId(String senterId) {
		this.senterId = senterId;
	}

	public String getSenterEmail() {
		return senterEmail;
	}

	public void setSenterEmail(String senterEmail) {
		this.senterEmail = senterEmail;
	}

	public String getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}

	public String getReceiveEmail() {
		return receiveEmail;
	}

	public void setReceiveEmail(String receiveEmail) {
		this.receiveEmail = receiveEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getSenterName() {
		return senterName;
	}

	public void setSenterName(String senterName) {
		this.senterName = senterName;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getFormatSentDate() {
		return DateFormatUtils.format(this.sentDate, "yyyy-MM-dd HH:mm");
	}

	public void setFormatSentDate(String formatSentDate) {
		this.formatSentDate = formatSentDate;
	}

	public Integer getSentDel() {
		return sentDel;
	}

	public void setSentDel(Integer sentDel) {
		this.sentDel = sentDel;
	}

	public Integer getReceiveDel() {
		return receiveDel;
	}

	public void setReceiveDel(Integer receiveDel) {
		this.receiveDel = receiveDel;
	}

}
