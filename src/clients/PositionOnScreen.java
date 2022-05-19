package clients;
import java.awt.*;

public class PositionOnScreen {

	private static final int maxX;
	private static final int maxY; 
	
	private static int cX = 0;
	private static int cY = 0;
	
	static {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		maxX = (int) dimension.getWidth();
		maxY = (int) dimension.getHeight();
	}
	
	public static Dimension getPos()
	{
		Dimension pos = new Dimension(cX, cY);
		return pos;
	}
}
