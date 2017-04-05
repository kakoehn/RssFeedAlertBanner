/**
 * 
 */
package edu.everettcc.rssnotification;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author kakoehn
 *
 */
public class OutputNotification {

	/**
	 * @param size
	 * @return
	 */
	private static Point windowLocation(Dimension size)
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		Point windowLocation = new Point();
     	windowLocation.setLocation(width - size.getWidth() - 4 ,height - size.getHeight() - 34);
     	return windowLocation;
	}

	/**
	 * @param notificaton
	 * @param url
	 * @throws InterruptedException
	 */
	public void outputNotification(String notificaton,String url) throws InterruptedException
	{
		JLabel windowLabel = new JLabel(notificaton);
		JLabel urlLabel = new JLabel(url);
     	JDialog window = new JDialog();
        JPanel panel1 = new JPanel();

        
        //configuring panel to make it look nice
        panel1.setLayout(new GridLayout(2,1));
        panel1.add(windowLabel);
        panel1.add(urlLabel);
        panel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //minimum window size
        Dimension minSize = new Dimension();
        minSize.setSize(300, 100);
        //set window attributes that change size
        window.setLayout(new GridBagLayout());
        window.setContentPane(panel1);
        window.setTitle("EvCC Notification");
        window.setMinimumSize(minSize);
        window.setMaximumSize(minSize);
        window.pack();
        //get location based on size
        window.setLocation(windowLocation(window.getSize()));
        
        //set window attributes and timeout
        window.setAlwaysOnTop(true);
        window.setVisible( true );
        window.setResizable(false);
        TimeUnit.SECONDS.sleep(15);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible( false );
        window.dispose();
	}
}
