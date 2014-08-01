package com.eventorganiser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author Prasenjit
 * @version 1.0
 */
public class UserInterface {

	/**
	 * @param trackNumber Total number of days needed for scheduling the event
	 * @param eventArray  Array List to hold the n Event object 
	 * @param eventObject Object of class representing the Event.
	 */
	private static int  trackNumber=0; 
	public static ArrayList<Event> eventArray;
	public static Event eventObject;
	int i=0;
	public static void main(String[] args) throws IOException, ParseException 
	{   // To create ArrayList
		eventArray = new ArrayList<Event>();

		// To read integer 
		Scanner scan = new Scanner(System.in);

		// To read String
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// To store user string input temporarily
		String title;
		int duration=0;
		//Infinite for loop to enter n event details
		for(;;)
		{	
			// Create a new object for each iteration to store new event
			eventObject = new Event();

			// To inform user to input data
			System.out.println("Enter talkTitle, To Exit Enter Exit");

			// To read the user input from the console
			title = reader.readLine();

			// To check if user enters Exit, It will end the infinite for loop
			if(title.equals("Exit"))
			{
				break;
			}
			// Check condition to find string lightning, if found then initialize duration by 5, proceed to next iteration
			if((title.toLowerCase().contains("lightning")))
			{
				//System.out.println("true");
				duration = 5;
			}
			else
			{
				//To inform user to enter Talk Time(Duration)
				System.out.println("Enter talk time");

				// To set the duration of the event object, check if not integer
				
				try
				{
				 duration = scan.nextInt();
				}
				catch(InputMismatchException exception)
				{
					System.out.println("Invalid input, Expected Integer Only");
					break;
				}
			}
			
			// To set the talk Title
			eventObject.setTalkTitle(title);

			
			eventObject.setDuration(duration);

			//To set the default priority of the event object
			eventObject.setPriority(0);

			//To ser the flag if it has been scheduled. True if scheduled, else false
			eventObject.setStatus(false);

			// Add in the arraylist
			eventArray.add(eventObject);

		} 

		// To get the required number of days for scheduling the event
		int trackCount = EventScheduler.getTrackCount(eventArray); // Method will return number of days in integer
		
		//System.out.println(trackCount+"\n");
		for(int n=0;n<trackCount;n++)
		{	

			trackNumber= trackNumber+1;
			System.out.println("Track : " +trackNumber );

			// To schedule the event
			EventScheduler.generateSet(eventArray, 180, 240,trackNumber);

		}
		// To display the output
		/*for(int n=1;n<=trackCount;n++)
		 {
			 displayResult(n); // To display the result
		 }*/


	}
	/*
	 *  Method to display the output
	 *  Not in use
	 *  
	 */
	private static void displayResult(int track)
	{
		System.out.println("Track : "+track);
		for(Event number : eventArray)
		{
			if(number.getTrack()==track)
			{
				System.out.println(number.getTime()+" " + number.getTalkTitle() +" "+number.getDuration()+"min" +" " +number.getSession());
			}

		}
	}

}
