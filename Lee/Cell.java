import java.awt.Color;
import java.awt.event.MouseEvent;

public class Cell extends javax.swing.JLabel {
	private final Color GREY = new Color(184, 184, 184);
	private final Color BLACK = new Color(47, 79, 79);

	private int weigth = -1;

	public Cell(Grid caller)
	{
		this.setOpaque(true);
		this.setBackground(GREY);
		this.addMouseListener(new java.awt.event.MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!caller.done) {
					int button = e.getButton();
					if (button == 1) {
						Cell elem = (Cell) e.getSource();
						elem.toggleBackgroundColor();
					}
					else if (button == 3)
						caller.init();
				}
				else
					caller.frame.refresh();
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
	}

	public void toggleBackgroundColor()
	{
		if (this.getBackground() == GREY)
			this.setBackground(BLACK);
		else if (this.getBackground() == BLACK)
			this.setBackground(GREY);
	}

	public boolean isBlocked() {
		return this.getBackground() == BLACK ? true : false;
	}

	public int getValue() {
		return this.weigth;
	}

	public void setValue(int iteration) {
		this.weigth = iteration;
		this.render(iteration, this.getForeground());
	}

	public void render(int step, Color color)
	{
		this.setForeground(color);
		this.setText("      "+step);
	}
}