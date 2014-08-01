
package com.eventorganiser;

import java.text.ParseException;
import java.util.ArrayList;
/**
 * 
 * @author Prasenjit
 * @version 1.0
 */
public class EventScheduler {
	/* Private constructor, No need to create object of this class.
	 * Object creation can be supported via Singleton Pattern.
	 */
	private EventScheduler() {

	}
	/*
	 * Method to return the total number of days needed for scheduling the events
	 */
	public static int  getTrackCount(ArrayList<Event> events)
	{
		int totalSum = 0;
		int trackCount = 0;
		for (Event event : events)
		{
			totalSum = totalSum+event.getDuration();
		}
		//System.out.println(totalSum);
	    trackCount = (int) Math.ceil(totalSum/420.0);
		return trackCount;

	}
	/*
	 * Method to 
	 */
	public static void setOtherScheduledEvent(ArrayList<Event> events)
	{
		for (Event event : events)
		{

		}
	}
	/*
	 * Method to generate the scheduled event list   
	 */
	public static void generateSet(ArrayList<Event> events, int morningSession,int afternoonSession,int track) throws ParseException
	{
		int totalSum1 = 0;
		int totalSum2 = 0;
		String time;
		// Create an object of Utilty Class
		Utility util = new Utility();
		
		// Method call to initialize the schedule start Time
		util.initializeStart();

		// Loop to unpack Event object to read data from ArrayList  
		for (Event event : events)
		{
			// To check if total sum is mot greater then 180, in case of morning session
			if(totalSum1< morningSession)
			{
				// To check if the event has not been scheduled
				if(!event.isStatus())
				{
					totalSum1 = totalSum1 + event.getDuration();
					// After adding, check again if sum > 180 then subtract
					if(totalSum1<=morningSession)
					{
						// Set the status to true to make is visible for next iteration that event has been scheduled
						event.setStatus(true);
						// To check if track has already been assigned, by default it is 0
						if(event.getTrack()==0)
						{
							// To get the time in 09:00 AM format
							time = util.dateFormatter(event.getDuration(),track,1);
							event.setTrack(track);
							event.setSession(1);
							System.out.println(time+ " "+event.getTalkTitle()+" " + event.getDuration()+"min");
							event.setTime(time);

						}
						if(totalSum1==morningSession)
						{
							break;
						}
					}
					
				}
			}
			else
			{
				totalSum1 = totalSum1 - event.getDuration();
				continue; 
			}
			
		}
		// To iterate for each event in the Array list
		for (Event event : events)
		{	
			// To check if totalsum2 is not more then 240, for second session of the day
			if(totalSum2 < afternoonSession)
			{
				// To check if the event has not been scheduled
				if(!event.isStatus())
				{
					// After adding, check again if sum > 240 then subtract
					totalSum2 = totalSum2 + event.getDuration();
					if(totalSum2<= afternoonSession)
					{
						// Set the status to true to make is visible for next iteration that event has been scheduled
						event.setStatus(true);

						if(event.getTrack()==0)
						{
							time = util.dateFormatter(event.getDuration(),track,2);
							event.setTrack(track);
							event.setSession(2);
							System.out.println(time+ " "+event.getTalkTitle()+" " + event.getDuration()+"min");
							event.setTime(time);
							if(((util.parseStringToDate(time).compareTo(util.parseStringToDate("04:00 PM"))>=0)) && (util.parseStringToDate(time).compareTo(util.parseStringToDate("05:00 PM"))<=0))
							{
								UserInterface.eventObject = new Event();
								
								// To set the talk Title
								UserInterface.eventObject.setTalkTitle("Networking");

								//To inform user to enter Talk Time(Duration)
								//System.out.println("Enter talk time");

								// To set the duration of the event object
								UserInterface.eventObject.setDuration(60);

								//To set the default priority of the event object
								UserInterface.eventObject.setPriority(0);

								//To ser the flag if it has been scheduled. True if scheduled, else false
								UserInterface.eventObject.setStatus(true);
								UserInterface.eventObject.setSession(2);
								UserInterface.eventObject.setTrack(track);
								UserInterface.eventObject.setTime(util.dateFormatter(60,track,2));
								System.out.println(UserInterface.eventObject.getTime()+ " "+UserInterface.eventObject.getTalkTitle()+" " + UserInterface.eventObject.getDuration()+"min");
								
								// Add in the arraylist
								//UserInterface.eventArray.add(UserInterface.eventObject);
								
							}
							 /*if(((util.parseStringToDate(time).compareTo(util.parseStringToDate("05:00 PM"))<=0)))
							{
								UserInterface.eventObject = new Event();
								
								// To set the talk Title
								UserInterface.eventObject.setTalkTitle("Networking");

								//To inform user to enter Talk Time(Duration)
								//System.out.println("Enter talk time");

								// To set the duration of the event object
								UserInterface.eventObject.setDuration(60);

								//To set the default priority of the event object
								UserInterface.eventObject.setPriority(0);

								//To ser the flag if it has been scheduled. True if scheduled, else false
								UserInterface.eventObject.setStatus(true);
								UserInterface.eventObject.setSession(2);
								UserInterface.eventObject.setTrack(track);
								UserInterface.eventObject.setTime(util.dateFormatter(60,track,2));
								System.out.println(UserInterface.eventObject.getTime()+ " "+UserInterface.eventObject.getTalkTitle()+" " + UserInterface.eventObject.getDuration()+"min");
								
								// Add in the arraylist
								//UserInterface.eventArray.add(UserInterface.eventObject);
							}*/
						}
						if(totalSum2== afternoonSession)
						{
							break;
						}
					}
					
				}

			}
			// Subtracting as sum > 240 
			else
			{
				totalSum1 = totalSum1 - event.getDuration();
				continue; // Go to next iteration
			}
			
		}
		
	}
}
