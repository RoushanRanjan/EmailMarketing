package com.nacre.emailmarketing.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.emailmarketing.dto.OperationtypeDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.formbean.PieChartDetails;

public interface AdminServiceI {
	public String checkUpdation(OperationtypeDto otd) throws DatabaseException;
	
    // create the method for tracking on viewed process
	public List<PieChartDetails> clickedViewServiceProcess(int a) throws DatabaseException, SQLException;
	
	//code by sagar
	public Map adminNotification(int type);
	public Object NotificationDetail(int type , int key);
	public int  changeStatusType(int type,int key);
	public int countNotification();

}
