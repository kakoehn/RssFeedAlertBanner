/**
 * 
 */
package edu.everettcc.rssnotification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author kakoehn
 * The RssDate object is used for handling the publish date of Rss items.
 */
public class RssDate {
//some stuff
	String pubDate;
	
	
	public RssDate()
	{
		
	}

	//sets date on existing RssDate object
	/**
	 * @param pubDate
	 * setter for date to check.
	 */
	public void dateSet(String pubDate)
	{
		this.pubDate = pubDate;
	}
	
	/**
	 * @return
	 * @throws ParseException
	 * checks for time relevancy. if the pubDate is within 22 seconds of the current time, returns true.
	 * 
	 */
	public boolean isRelevant() throws ParseException {  
		SimpleDateFormat timeStamp = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
		Date date = new Date();
		date = timeStamp.parse(pubDate);
		long pubDateTime = date.getTime();
		long currentTimeMillis = System.currentTimeMillis();
		if(currentTimeMillis <= pubDateTime + 30000)
		{
			return true;
		}
		return false;
	}
	
}
