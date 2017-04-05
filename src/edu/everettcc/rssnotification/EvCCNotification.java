/**
 * 
 */
package edu.everettcc.rssnotification;


import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

/**
 * @author kakoehn
 * version 0.1
 * forgive the documentation.
 * 
 * This program reads an rss feed and outputs a title to a jframe dialogue box. it runs on a 30 second loop 
 * and only outputs titles from rss items less than 30 seconds old.
 *
 */
public class EvCCNotification {

	/**
	 * @param args
	 * @throws ParseException 
	 * 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		OutputNotification window = new OutputNotification();
		RssScan rssScan = new RssScan();

		while(true)
		{
			
			//read from RSS feed
				String rssMessage = "";
				try {
					//rssMessage = rssScan.readRSS("http://lorem-rss.herokuapp.com/feed");
					//rssMessage = rssScan.readRSS("http://rss.cnn.com/rss/cnn_topstories.rss");
					rssMessage = rssScan.readRSS("http://www.everettcc.edu/rss/events/");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//
					e1.printStackTrace();
				}
				try {
					if(!rssMessage.isEmpty())
					{
						window.outputNotification(rssMessage, "www.everettcc.edu/events for more details");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				//DELAY TIME
				TimeUnit.SECONDS.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}