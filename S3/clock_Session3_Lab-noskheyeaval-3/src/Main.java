/**
 * This program represents the simple clock.
 * @author Helia Sadat Hashemipour
 * @version 0.0
 */
public class Main {

    public static void main(String[] args) {
	ClockDisplay clockDisplay=new ClockDisplay();
	clockDisplay.setTime(5,59,59);
	clockDisplay.timeTick();
	System.out.println(clockDisplay.getTime());
    }
}
