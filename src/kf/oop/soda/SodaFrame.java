package kf.oop.soda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * SodaFrame class is a JFrame that displays the main screen of the soda machine.
 * @author Kevin Flaherty
 *
 */
public class SodaFrame extends JFrame {
	
	public SodaFrame(){
		
	this.setTitle("Soda Machine");
	Dimension d = new Dimension(300,400);
	this.setPreferredSize(d);
	JPanel mainPanel = new JPanel(new BorderLayout());
	JPanel topPanel = new JPanel(new BorderLayout());
	JPanel coinPanel = new JPanel(new GridLayout(2, 3));
	
	nickel = new JButton("5");
	dime = new JButton("10");
	quarter = new JButton("25");
	total = new JTextArea("   ");
	coinPanel.add(nickel);
	coinPanel.add(dime);
	coinPanel.add(quarter);
	coinPanel.add(new JLabel("Total: "));
	coinPanel.add(total);
	
	JPanel sodaPanel = new JPanel(new GridLayout(5, 2));
	sodaPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	
	oosTextPane = new JTextPane();
	oosTextPane.setText("   ");
	oosTextPane.setEditable(false);

	coke = new JButton("Coke");
	orange = new JButton("Orange");
	sprite = new JButton("Sprite");
	ginger = new JButton("Ginger Ale");
	sodaPanel.add(new JLabel("Soda Selection"));
	sodaPanel.add(new JLabel(" "));
	sodaPanel.add(coke);
	sodaPanel.add(new JLabel(" "));
	sodaPanel.add(orange);
	sodaPanel.add(new JLabel(" "));
	sodaPanel.add(sprite);
	sodaPanel.add(new JLabel(" "));
	sodaPanel.add(ginger);
	sodaPanel.add(oosTextPane);
	
	topPanel.add(new JLabel("Coin Entry"), BorderLayout.NORTH);
	topPanel.add(coinPanel, BorderLayout.CENTER);
	topPanel.add(sodaPanel, BorderLayout.SOUTH);
	
	JPanel deliveryPanel = new JPanel(new FlowLayout());
	JLabel selectionLabel = new JLabel("Selection:");
	deliveryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	deliveryPanel.add(selectionLabel);
	selected = new JTextArea("   ");
	deliveryPanel.add(selected);
	deliveryPanel.add(new JLabel("Change:"));
	change = new JTextArea("   ");
	deliveryPanel.add(change);
	
	JPanel adminPanel = new JPanel(new GridLayout(2,3));
	enterButton = new JButton("Enter");
	adminPanel.add(new JLabel("Admin Mode"));
	adminPanel.add(new JLabel(" "));
	adminPanel.add(new JLabel(" "));
	adminPanel.add(new JLabel(" "));
	adminPanel.add(enterButton);
	
	mainPanel.add(topPanel, BorderLayout.NORTH);
	mainPanel.add(deliveryPanel, BorderLayout.CENTER);
	mainPanel.add(adminPanel, BorderLayout.SOUTH);
	
	this.add(mainPanel);
	
	this.setLayout(new FlowLayout());
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JButton enterButton;
	public JButton nickel;
	public JButton dime;
	public JButton quarter;
	public JButton coke;
	public JButton orange;
	public JButton sprite;
	public JButton ginger;
	public JTextArea total;
	public JTextArea selected;
	public JTextArea change;
	public JTextPane oosTextPane;
}
