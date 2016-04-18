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
 * @ClassName CFYPXXB
 * @Description 处方药品信息
 * @Date 2015年8月26日 下午9:16:17
 * @author LIJW
 *
 */
@Entity
@Table(name="CFYPXXB")
public class CFYPXXB implements Serializable{

	private static final long serialVersionUID = 2924259072584667649L;
	
	@Id
	@GeneratedValue(generator="paymentableGenerator")
	@GenericGenerator(name="paymentableGenerator",strategy="uuid")
	@Column(name="UUID",unique=true)
	private String uuid ;//主键
	
	@Column(name = "CFZJ")
	private String cfzj ;//处方主键
	
	@Column(name="YPQC")
	private String ypqc ;//处方药品名称
	
	@Column(name="YPJL")
	private String ypjl ;//药品剂量
	
	@Column(name="YPJLZW")
	private String ypjlzw ;//药品剂量中文
	
	@Column(name="FYFS")
	private String fyfs ;//服用方式
	
	@Column(name="FYFSZW")
	private String fyfszw ;//服用方式中文
	
	@Column(name="SFZJ")
	private String sfzj ;//是否针剂
	
	@Column(name="SFZJZW")
	private String sfzjzw ;//是否针剂中文
	
	@Column(name="TJSJ")
	private String tjsj ;//添加时间
	
	@Column(name="YPDM")
	private String ypdm ; //药品代码
	
	public CFYPXXB (){
		super();
	}
	
	
	/**
	 * @param cfzj
	 * @param ypqc
	 * @param ypjl
	 * @param ypjlzw
	 * @param fyfs
	 * @param fyfszw
	 * @param sfzj
	 * @param sfzjzw
	 * @param ypdm
	 */
	public CFYPXXB(String cfzj, String ypqc, String ypjl, String ypjlzw, String fyfs, String fyfszw, String sfzj,
			String sfzjzw, String ypdm) {
		super();
		this.cfzj = cfzj;
		this.ypqc = ypqc;
		this.ypjl = ypjl;
		this.ypjlzw = ypjlzw;
		this.fyfs = fyfs;
		this.fyfszw = fyfszw;
		this.sfzj = sfzj;
		this.sfzjzw = sfzjzw;
		this.ypdm = ypdm;
	}




	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getCfzj() {
		return cfzj;
	}
	public void setCfzj(String cfzj) {
		this.cfzj = cfzj;
	}
	public String getYpqc() {
		return ypqc;
	}
	public void setYpqc(String ypqc) {
		this.ypqc = ypqc;
	}
	public String getYpjl() {
		return ypjl;
	}
	public void setYpjl(String ypjl) {
		this.ypjl = ypjl;
	}
	public String getYpjlzw() {
		return ypjlzw;
	}
	public void setYpjlzw(String ypjlzw) {
		this.ypjlzw = ypjlzw;
	}
	public String getFyfs() {
		return fyfs;
	}
	public void setFyfs(String fyfs) {
		this.fyfs = fyfs;
	}
	public String getFyfszw() {
		return fyfszw;
	}
	public void setFyfszw(String fyfszw) {
		this.fyfszw = fyfszw;
	}
	public String getSfzj() {
		return sfzj;
	}
	public void setSfzj(String sfzj) {
		this.sfzj = sfzj;
	}
	public String getSfzjzw() {
		return sfzjzw;
	}
	public void setSfzjzw(String sfzjzw) {
		this.sfzjzw = sfzjzw;
	}
	public String getTjsj() {
		return tjsj;
	}
	public void setTjsj(String tjsj) {
		this.tjsj = tjsj;
	}
	public String getYpdm() {
		return ypdm;
	}
	public void setYpdm(String ypdm) {
		this.ypdm = ypdm;
	}
	
	
	
	
	
	
	
	
	
	

}
