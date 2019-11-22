public class Frame extends javax.swing.JFrame {
    public Frame(String name) {
        super(name);
        this.set();
        this.init();
    }

    private void set() {
        final int WIDTH = 1280;
        final int HEIGHT = 1024;
        java.awt.Dimension dimension = new java.awt.Dimension(WIDTH, HEIGHT);
        
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.pack();
    }

    private void init() {
        this.add(new Grid(this), java.awt.BorderLayout.CENTER);
    }

    public void refresh() {
        this.getContentPane().removeAll();
        this.revalidate();
        this.getContentPane().repaint();
        this.init();
    }
}