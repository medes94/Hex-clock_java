import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Hexclock implements Runnable {

	// Laver en tråd af et Hexclock og kører det
	public static void main(String[] args) {
		Runnable r = new Hexclock();
		Thread t = new Thread(r);
		t.start();
	}

	public void run() {
		try {
			// Kalder currentTime() hvert sekund
			while (true) {
				long millis = System.currentTimeMillis();
				hashTime();
				Thread.sleep(1000 - millis % 1000);
			}
			// Fanger InterrupetdException
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Printer tiden i formatet HH:mm:ss
	public static void currentTime() {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(cal.getTime()));
	}

	// Printer tiden i formatet #hhmmss
	public static void hashTime() {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("#HHmmss");
		System.out.println(sdf.format(cal.getTime()));
	}
}
