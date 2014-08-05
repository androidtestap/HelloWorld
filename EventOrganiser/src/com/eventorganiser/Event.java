
package com.eventorganiser;
/**
 * 
 * @author Prasenjit
 * @version 1.0
 */

public class Event {

	// Title of the Event
	private String talkTitle; 

	//Test Again
	// Duration of the Event
	private int duration;

	// Priority of the Event. It can be used to sort the event and schedule as per priority 
	private int priority;

	// Status of an Event object. If scheduled then true else false
	private boolean status;

	// Event day count
	private int track;

	// Session of the Event. If morning session then 1, if Afternoon session then 2 
	private int session;

	// Scheduled Event Time
	private String time; 

	// Public Constructor
	public Event()
	{
		track = 0;
		status = false;
		priority = 0;
		session = 0;

	}
	/*
	 * Method to get the scheduled time 
	 */ 
	public String getTime() {
		return time;
	}
	/*
	 * Method to set the scheduled time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/*
	 * Method to get the session 
	 */
	public int getSession() {
		return session;
	}
	/*
	 * Method to session
	 */
	public void setSession(int session) {
		this.session = session;
	}
	/*
	 * Method to get the track
	 */
	public int getTrack() {
		return track;
	}
	/*
	 * Method to set the track
	 */
	public void setTrack(int track) {
		this.track = track;
	}
	/*
	 * Method to get the Talk Title
	 */
	public String getTalkTitle() {
		return talkTitle;
	}
	/*
	 * Method to set the Talk Title
	 */
	public void setTalkTitle(String talkTitle) {
		this.talkTitle = talkTitle;
	}
	/*
	 * Method to get the Duration 
	 */
	public int getDuration() {
		return duration;
	}
	/*
	 * Method to set the Duration 
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/*
	 * Method to get the priority
	 */
	public int getPriority() {
		return priority;
	}
	/*
	 * Method to set the priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/*
	 * Method to check the status
	 */
	public boolean isStatus() {
		return status;
	}
	/*
	 * Method to set the status 
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}