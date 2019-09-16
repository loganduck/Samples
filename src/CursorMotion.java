import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CursorMotion extends JPanel implements MouseMotionListener {
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 300;
	
	private JLabel coordinates;
	private final int COORD_Y = 200;
	
	private JLabel image;
	
	private ImageIcon yellow = new ImageIcon("src/images/yellow.png");
	private ImageIcon red = new ImageIcon("src/images/red.png");
	
	public CursorMotion() {
		setLayout(null);
		setBackground(Color.CYAN);
		setBounds(0, 0, WIDTH, HEIGHT);
		
		image = new JLabel(yellow);
		image.setName("image");
		image.setSize(108, 108);
		image.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				image.setIcon(red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				image.setIcon(yellow);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) { }
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
		});
		image.addMouseMotionListener(this);
		image.setBounds((WIDTH / 2) - (image.getWidth() / 2), (HEIGHT / 4) - (image.getHeight() / 2), image.getWidth(), image.getHeight());
		add(image);
		
		coordinates = new JLabel("X: 0, Y: 0");
		coordinates.setFont(new Font("", Font.BOLD, 25));
		coordinates.setForeground(Color.WHITE);
		coordinates.setBounds((WIDTH / 2) - (coordinates.getPreferredSize().width / 2), COORD_Y, coordinates.getPreferredSize().width, coordinates.getPreferredSize().height);
		add(coordinates);
		
		addMouseMotionListener(this);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		String text = e.getComponent().getName() == null ?
				("X: " + (int) e.getPoint().getX() + ", Y: " + (int) e.getPoint().getY()) : ("X: " + ((int) e.getPoint().getX() + 196) + ", Y: " + ((int) e.getPoint().getY() + 71));
		coordinates.setText(text);
		coordinates.setBounds((WIDTH / 2) - (coordinates.getPreferredSize().width / 2), COORD_Y, coordinates.getPreferredSize().width, coordinates.getPreferredSize().height);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) { }
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("MouseMotionListener");
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(WIDTH, HEIGHT);
				frame.setResizable(false);
				
				frame.add(new CursorMotion());
				
				frame.setVisible(true);
			}
		});
	}
}