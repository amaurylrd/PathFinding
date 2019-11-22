import java.awt.Color;

public class Grid extends javax.swing.JPanel {
	private Cell[][] board;
	private int count;
	private final Color RED = new Color(139, 0, 0);
	private final Color DARKGREY = new Color(212, 212, 212);
	private final Color PATH = new Color(179, 212, 212);

	public Boolean done = false;
	public Frame frame;

	public Grid(Frame frame) {
		this.frame = frame;
		this.setLocation(0, 0);
        this.setSize((int) frame.getWidth(), (int) frame.getHeight());
        this.setBackground(new Color(246, 246, 246));
        this.setLayout(null);
        this.generation(18, 23);
	}

	private void generation(int m, int p) {
		Cell[][] tmp = new Cell[m][p];
		int size = 50;
		int offset = 23;

		for (int i = 0 ; i < m ; i++) {
			for (int j = 0 ; j < p  ; j++) {
				Cell elem = new Cell(this);
				if ((i == 0 && j == 0) || (i == m - 1 && j == p - 1))
					elem.setBackground(RED);
				elem.setSize(size, size);
				int x = j*(size + 3) + offset;
				int y = i*(size + 3) + offset;
                elem.setLocation(x, y);
                this.add(elem);		
                tmp[i][j] = elem;
			}
		}
		this.board = tmp;
	}

	public void init() {
		this.count = 0;
		this.start(0, 0, 0);
	}

	public void start(int k, int i, int j) {
		int m = this.board.length;
		int p = this.board[0].length;
		this.done = true;
		
		//neighbor in cross
		for (int xoff = -1 ; xoff <= 1 ; xoff++) {
			for (int yoff = -1 ; yoff <= 1 ; yoff++) {
				int ioff = i + xoff;
				int joff = j + yoff;
				if (ioff > -1 && ioff < m && joff > -1 && joff < p && (ioff == i || joff == j) && !(ioff == i && joff == j)) {
					Cell elem = this.board[ioff][joff];
					if (!elem.isBlocked()) {
						if (ioff == m - 1 && joff == p - 1)
							this.backtrace(k, m, p);
						else if (elem.getValue() == -1 && elem.getBackground() != RED)
						{
							elem.setBackground(DARKGREY);
							elem.setValue(k + 1);
						}
					}
				}
			}
		}
		
		if (this.count == 0) {
			//set count
			k = k + 1;
			int cmp = 0;
			for (i = 0 ; i < m ; i++) {
				for (j = 0 ; j < p ; j++) {
					Cell elem = this.board[i][j];
					if (elem.getValue() == k) 
						cmp++;
				}
			}
			this.count = cmp;

			//parse
			for (i = 0 ; i < m ; i++) {
				for (j = 0 ; j < p ; j++) {
					Cell elem = this.board[i][j];
					if (elem.getValue() == k) {
						this.count = this.count - 1;
						this.start(k, i, j);
					}
				}
			}
		}
	}

	private void backtrace(int k, int m, int p) {
		int i = m - 1;
		int j = p - 1;
		this.board[i][j].render(k + 1, Color.YELLOW);
    	while (k != 0)
    	{
			for (int xoff = -1 ; xoff <= 1 ; xoff++) {
				for (int yoff = -1 ; yoff <= 1 ; yoff++) {
					int ioff = i + xoff;
					int joff = j + yoff;
					if (ioff > -1 && ioff < m && joff > -1 && joff < p && (ioff == i || joff == j) && !(ioff == i && joff == j)) {
						Cell elem = this.board[ioff][joff];
						if (elem.getValue() == k)
						{
							elem.setBackground(PATH);
							k--;
							i = ioff;
							j = joff;
						}	
					}
				}
			}
    	}
	}
}