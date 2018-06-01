package com.example.demo;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity(name="FUND_USER_LOG")
@EntityListeners(AuditingEntityListener.class)
public class FundUserLog{
	/**
	 * 
	 */
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="SVL_CODE")
	 private int svlCode;
	 @Column(length=80,name="SVC_UID")
	 private String svcUid;
	 @Column(length=30,name="SVL_USERID")
	 private String svlUserid;
	 @Column(length=3000,name="SVL_DESC")
	 private String svlDesc;
	 @Column(length=30,name="SVL_SCREEN")
	 private String svlScreen;  
	 @Column(length=20,name="SVL_TTYPE")
	 private String svlTtype;
	 @CreatedDate
	 @Column(name="SVL_DATE")
	 private Calendar svlDate;
	 //for Item info
	 @Column(name="SNO",length=50)
	 private String sno;
	 @CreatedBy
	 private String createdBy;
	 @LastModifiedDate
	 private Calendar lastModifiedOn;
	 @LastModifiedBy
	 private String lastModifiedBy;
	public Calendar getLastModifiedOn() {
		return lastModifiedOn;
	}
	public void setLastModifiedOn(Calendar lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getSvlCode() {
		return svlCode;
	}
	public void setSvlCode(int svlCode) {
		this.svlCode = svlCode;
	}
	public String getSvcUid() {
		return svcUid;
	}
	public void setSvcUid(String svcUid) {
		this.svcUid = svcUid;
	}
	public String getSvlUserid() {
		return svlUserid;
	}
	public void setSvlUserid(String svlUserid) {
		this.svlUserid = svlUserid;
	}
	public String getSvlDesc() {
		return svlDesc;
	}
	public void setSvlDesc(String svlDesc) {
		this.svlDesc = svlDesc;
	}
	public String getSvlScreen() {
		return svlScreen;
	}
	public void setSvlScreen(String svlScreen) {
		this.svlScreen = svlScreen;
	}
	public String getSvlTtype() {
		return svlTtype;
	}
	public void setSvlTtype(String svlTtype) {
		this.svlTtype = svlTtype;
	}
	public Calendar getSvlDate() {
		return svlDate;
	}
	public void setSvlDate(Calendar svlDate) {
		this.svlDate = svlDate;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	 
	 
}
