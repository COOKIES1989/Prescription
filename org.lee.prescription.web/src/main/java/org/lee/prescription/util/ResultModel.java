package org.lee.prescription.util;

import java.io.Serializable;

public class ResultModel implements Serializable{

	
	private static final long serialVersionUID = -3224170425657436275L;
	private String msg;//提示信息
	private String flag;//成功/失败标记
	private int total;//记录条数
	private Object rows;//分页对象
	

	public ResultModel() {
		super();
	}

	/**
	 * @param msg
	 * @param flag
	 */
	public ResultModel(String flag ,String msg) {
		super();
		this.msg = msg;
		this.flag = flag;
	}

	/**
	 * @param msg
	 * @param flag
	 * @param total
	 * @param rows
	 */
	public ResultModel(String flag , String msg,  int total, Object rows) {
		super();
		this.msg = msg;
		this.flag = flag;
		this.total = total;
		this.rows = rows;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}
	
	
	
}
