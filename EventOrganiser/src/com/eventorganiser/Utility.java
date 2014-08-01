package com.eventorganiser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @author Prasenjit
 * @version 1.0
 */
public class Utility {

	// Schedule endTime
	private  Date end; 

	// SimpleDateFormat to get the date in hh:mm a format
	private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a"); 

	// Event startTime, lunchTime
	private  Date start, lunchTime; 

	private Date networkEventTime; // To track the day end 

	// Calendar object to perform addition / subtraction on time.
	private static Calendar cal;  

	// To maintain track
	private int prevtrack=0;

	//Session of the event(if Morning then 1 else 2)
	private int session=0; 

	// To check the lunch time and update the startTime
	private boolean flag = true; 
	/*
	 * Method to initialize the startTime
	 */
	public  void initializeStart() 
	{
		try {
			start = sdf.parse("09:00 AM");
			networkEventTime = sdf.parse("4:00 PM");
			cal = Calendar.getInstance();
			cal.setTime(start);

			lunchTime = sdf.parse("12:00 PM");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * Method to parse the given string in date format
	 */
	public Date parseStringToDate(String dateString) throws ParseException
	{
		Date convertedDate= null;
	    SimpleDateFormat simpledateformatter = new SimpleDateFormat("hh:mm a");
	    convertedDate = simpledateformatter.parse(dateString);
	    return convertedDate;
	}
	/*
	 * Method to set the Time details to each event
	 */
	public  String dateFormatter(int min,int track,int session) throws ParseException 
	{	

		cal = Calendar.getInstance();
		if(prevtrack!=track)
		{
			// Check if end not initialized or if it is the first call	
			if(end!=null)
			{
				// To check if it equal to lunchTime or session for the event is 2
				if(!((end.compareTo(lunchTime)==0)|| session==2))
				{
					// Check if startTime is not equal to end
					if(start.compareTo(end)!=0)
					{
						start = end; // update the start with endTime 
					}
				}
				//If session == 2 or endTime == lunchTime then update the startTime and endTime
				else
				{
					/* This will be true for first call, for next call it will be false, This will schedule the 
					 * events in second half
					 * */ 

					if(flag)
					{	
						System.out.println("12:00 PM Lunch"); 
						end = sdf.parse("1:00 PM");
						flag=false;
					}
					
					// To update the start time in second half
					if(start.compareTo(end)!=0)
					{
						start = end; 
					}
					/*if(start.compareTo(networkEventTime)>0)
					{
						// Set the Networking time as 5 PM event
					}
					else
					{
						//Set the networking event time from 4PM
					}*/
				}

			}
			//To update the calendar with correct startTime
			cal.setTime(start);

			// To add the event minutes in the calendar 
			cal.add(Calendar.MINUTE, min);

			// To get the endTime of the scheduled event 
			end = cal.getTime();

		}
		else
		{
			// To set the start time to 9:00 AM
			start = sdf.parse("09:00 AM");
		}
		//System.out.println(sdf.format(start) + " to " + sdf.format(end));

		// To update the calendar event with the endTime
		cal.setTime(end);
		//System.out.println("End Time : " + end);

		// Return the start time of the scheduled event
		return sdf.format(start);


	}

}
