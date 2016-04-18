/**
 * 
 */
package org.lee.prescription.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @ClassName CFXXB
 * @Description 处方信息表
 * @Date 2015年8月26日 下午9:12:34
 * @author LIJW
 *
 */
@Entity
@Table(name="CFXXB")
public class CFXXB implements Serializable{

	
	private static final long serialVersionUID = -4021471501877286531L;
	
	@Id
	@GeneratedValue(generator="paymentableGenerator")
	@GenericGenerator(name="paymentableGenerator",strategy="uuid")
	@Column(name="UUID",unique=true)
	private String uuid ;//主键
	
	@Column(name="HZXM")
	private String hzxm ;//患者姓名
	
	@Column(name="HZXB")
	private String hzxb ;//患者性别
	
	@Column(name="HZXBZW")
	private String hzxbzw ;//患者性别中文
	
	@Column(name="HZNL")
	private String hznl ;//患者年龄
	
	@Column(name="CFJX")
	private String cfjx ;//处方剂型
	
	@Column(name="CFJXZW")
	private String cfjxzw ;//处方剂型中文
	
	@Column(name="CFSJ")
	private String cfsj ;//处方时间
	
	@Column(name="BZ")
	private String bz ;//备注
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getHzxm() {
		return hzxm;
	}
	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}
	public String getHzxb() {
		return hzxb;
	}
	public void setHzxb(String hzxb) {
		this.hzxb = hzxb;
	}
	public String getHzxbzw() {
		return hzxbzw;
	}
	public void setHzxbzw(String hzxbzw) {
		this.hzxbzw = hzxbzw;
	}
	public String getHznl() {
		return hznl;
	}
	public void setHznl(String hznl) {
		this.hznl = hznl;
	}
	public String getCfjx() {
		return cfjx;
	}
	public void setCfjx(String cfjx) {
		this.cfjx = cfjx;
	}
	public String getCfjxzw() {
		return cfjxzw;
	}
	public void setCfjxzw(String cfjxzw) {
		this.cfjxzw = cfjxzw;
	}
	public String getCfsj() {
		return cfsj;
	}
	public void setCfsj(String cfsj) {
		this.cfsj = cfsj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
	
	
	
	
	
	
	
	

}
