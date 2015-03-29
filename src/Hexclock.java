import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Hexclock implements Runnable {

	private static JFrame frame = new JFrame("Hexclock");
	private static JPanel panel = new JPanel(new BorderLayout());
	private static JLabel label = new JLabel();
	private Color rgbColor;
	private static String rgbColorString;

	public static void main(String[] args) {
		Runnable r = new Hexclock();
		Thread t = new Thread(r);
		t.start();
		makeGUI();
	}

	public void run() {
		try {
			while (true) {
				long millis = System.currentTimeMillis();
				hashTime();
				panel.setBackground(rgbColor);
				label.setText(rgbColorString);
				Thread.sleep(1000 - millis % 1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void currentTime() {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(cal.getTime()));
	}

	public void hashTime() {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("#HHmmss");
		System.out.println(sdf.format(cal.getTime()));
		rgbColorString = sdf.format(cal.getTime());
		rgbColor = Color.decode(rgbColorString);
	}

	public static void makeGUI() {
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.add(panel);
		panel.add(label, BorderLayout.CENTER);
		label.setFont(new Font("Myriad Pro", Font.PLAIN, 60));
		label.setForeground(Color.WHITE);
		label.setText(rgbColorString);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
