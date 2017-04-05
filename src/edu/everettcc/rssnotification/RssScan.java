/**
 * 
 */
package edu.everettcc.rssnotification;
import java.io.*;
import java.net.*;
import java.text.ParseException;

/**
 * @author kakoehn
 *
 */
public class RssScan {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	
	
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		System.out.println(readRSS("http://rss.cnn.com/rss/cnn_topstories.rss"));
//	
//		//http://www.everettcc.edu/rss/events/
//        ///http://rss.cnn.com/rss/cnn_topstories.rss
//	}
//	
	
	/**
	 * @param urlAddress
	 * @return
	 * @throws IOException
	 * 
	 * this loops through the Rss feed for item titles and returns the most relevant one.
	 */
	public String readRSS(String urlAddress) throws IOException
	{
		URL rssUrl = new URL(urlAddress);
		BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
		String outputData = "";
		String line;
		while((line = in.readLine())!=null)
		{
			RssDate date = new RssDate();
			String title = null;
			String pubDate = null;
			if(line.contains("<title>"))
			{
				int firstPos = line.indexOf("<title>");
				title = line.substring(firstPos);
				title = title.replace("<title>", "");
				int lastPos = title.indexOf("</title>");
				title = title.substring(0, lastPos);
			}
			if(line.contains("<pubDate>"))
			{
				int firstPos = line.indexOf("<pubDate>");
				pubDate = line.substring(firstPos);
				pubDate = pubDate.replace("<pubDate>", "");
				int lastPos = pubDate.indexOf("</pubDate>");
				pubDate = pubDate.substring(0, lastPos);
				date.dateSet(pubDate);
				try {
					if(date.isRelevant())
					{
						outputData = title;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		in.close();
		//return outputData;
		return outputData;
	}
	
	
}


