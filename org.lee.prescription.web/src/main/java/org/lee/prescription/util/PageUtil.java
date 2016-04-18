package org.lee.prescription.util;


/**
 * 
 * @ClassName PageUtil
 * @Description 用于分页的工具类
 * @Date 2015年8月6日 下午4:07:19
 * @author lijw
 *
 */
public class PageUtil implements java.io.Serializable {

	private String page;// 页数
	private String rows;// 每页显示的数
	private int num;//总记录数

	private String startTime;//起始日期
	private String endTime;//截至日期
	private String time;//日期

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

}
