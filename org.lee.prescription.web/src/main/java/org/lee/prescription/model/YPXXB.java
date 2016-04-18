package org.lee.prescription.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="YPXXB")
public class YPXXB implements Serializable{

	private static final long serialVersionUID = 3559178368705560316L;
	
	@Id
	@GeneratedValue(generator="paymentableGenerator")
	@GenericGenerator(name="paymentableGenerator",strategy="uuid")
	@Column(name="UUID",unique=true)
	private String uuid;//主键
	
	@Column(name = "YPQC")
	private String ypqc;//药品全称
	
	@Column(name = "YPMC")
	private String ypmc;//药品名称
	
	@Column(name = "YPPYJC")
	private String yppyjc;//药品拼音简称
	
	@Column(name = "YPJL")
	private String ypjl;//药品剂量
	
	@Column(name = "YPJLZW")
	private String ypjlzw;//药品剂量中文
	
	@Column(name="YPCJ")
	private String ypcj;//药品厂家
	
	@Column(name="YPCJZW")
	private String ypcjzw;//药品厂家中文
	
	@Column(name="YPDM")
	private String ypdm;//药品代码
	
	@Column(name="YPJX")
	private String ypjx;//药品剂型

	@Column(name="YPJXZW")
	private String ypjxzw;//药品剂型中文

	
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getYpqc() {
		return ypqc;
	}

	public void setYpqc(String ypqc) {
		this.ypqc = ypqc;
	}

	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	public String getYppyjc() {
		return yppyjc;
	}

	public void setYppyjc(String yppyjc) {
		this.yppyjc = yppyjc;
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

	public String getYpcj() {
		return ypcj;
	}

	public void setYpcj(String ypcj) {
		this.ypcj = ypcj;
	}

	public String getYpcjzw() {
		return ypcjzw;
	}

	public void setYpcjzw(String ypcjzw) {
		this.ypcjzw = ypcjzw;
	}

	public String getYpdm() {
		return ypdm;
	}

	public void setYpdm(String ypdm) {
		this.ypdm = ypdm;
	}

	public String getYpjx() {
		return ypjx;
	}

	public void setYpjx(String ypjx) {
		this.ypjx = ypjx;
	}

	public String getYpjxzw() {
		return ypjxzw;
	}

	public void setYpjxzw(String ypjxzw) {
		this.ypjxzw = ypjxzw;
	}
	
	

}
