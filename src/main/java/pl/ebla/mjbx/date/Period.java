package pl.ebla.mjbx.date;

import java.util.Date;

public class Period {
	
	private Date startDate;
	private Date endDate;
	
	public Period( int year ){
		
		CurrentMonth beginOfYear = new CurrentMonth( year, 0 );
		CurrentMonth endOfYear = new CurrentMonth( year, 11 );
		this.startDate = beginOfYear.getFirstDateOfMonth();
		this.endDate = endOfYear.getLastDateOfMonth();
	}
	
	public Period( int year, int month ){
		
		CurrentMonth monthOfYear = new CurrentMonth( year, month );
		this.startDate = monthOfYear.getFirstDateOfMonth();
		this.endDate = monthOfYear.getLastDateOfMonth();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	

	
}
