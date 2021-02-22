package br.com.bmo.taskmanager.model;

public class TaskCountByDayMonth {

	private Integer day;
	private Integer month;
	private Long total;
	
	public TaskCountByDayMonth() {
	}
	
	public TaskCountByDayMonth(Integer day, Integer month, Long total) {
		this.day = day;
		this.month = month;
		this.total = total;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	
	
}
