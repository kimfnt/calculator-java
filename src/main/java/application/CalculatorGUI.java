package application;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import event.CalculatorActionListener;

public class CalculatorGUI {

	/**
	 * Elements on the application
	 */
	private JFrame frmCalculator;
	private JPanel panelNormal;
	private JTextField resultField;
	private JButton jButton0;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private JButton jButton7;
	private JButton jButton8;
	private JButton jButton9;
	private JButton plusButton;
	private JButton minusButton;
	private JButton multiplyButton;
	private JButton divButton;
	private JButton moduloButton;
	private JButton clearButton;
	private JButton resultButton;
	private JButton delButton;
	private JButton dotButton;
	private JButton pmButton;

	/**
	 * Launch the application.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
		// String str1="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		UIManager.setLookAndFeel(str);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI window = new CalculatorGUI();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorGUI() {
		initializeFrame();
		initializeContent();
		initializeEvent();
	}

	/**
	 * Initialize the frame and the panel
	 */
	private void initializeFrame() {
		frmCalculator = new JFrame();
		frmCalculator.getContentPane().setBackground(new Color(204, 204, 204));
		frmCalculator.setTitle("Calculator");
		frmCalculator.setResizable(false);
		frmCalculator.setBounds(100, 100, 340, 465);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.setIconImage(new ImageIcon("./src/main/resources/calculator.png").getImage());
		panelNormal = new JPanel();
		panelNormal.setBackground(new Color(204, 204, 204));

		resultField = new JTextField();
		resultField.setBackground(Color.WHITE);
		resultField.setEditable(false);
		resultField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resultField.setColumns(10);
		resultField.setHorizontalAlignment(SwingConstants.RIGHT);
		frmCalculator.getContentPane().add(resultField);

		GroupLayout groupLayout = new GroupLayout(frmCalculator.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelNormal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(resultField, 312, 312, 312))
						.addContainerGap(16, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(37, Short.MAX_VALUE)
				.addComponent(resultField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(panelNormal, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE).addGap(25)));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 70, 70, 70, 102, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panelNormal.setLayout(gbl_panel);

		frmCalculator.getContentPane().setLayout(groupLayout);
	}

	/**
	 * Initialize the buttons of the frame
	 */
	private void initializeContent() {

		// Numbers
		jButton0 = new JButton("0");
		jButton0.setBackground(new Color(153, 204, 204));
		jButton0.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_0 = new GridBagConstraints();
		gbc_0.fill = GridBagConstraints.BOTH;
		gbc_0.gridheight = 2;
		gbc_0.insets = new Insets(0, 0, 0, 5);
		gbc_0.gridx = 1;
		gbc_0.gridy = 8;
		panelNormal.add(jButton0, gbc_0);

		jButton1 = new JButton("1");
		jButton1.setBackground(new Color(153, 204, 204));
		jButton1.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_1 = new GridBagConstraints();
		gbc_1.fill = GridBagConstraints.BOTH;
		gbc_1.gridheight = 2;
		gbc_1.insets = new Insets(0, 0, 5, 5);
		gbc_1.gridx = 0;
		gbc_1.gridy = 6;
		panelNormal.add(jButton1, gbc_1);

		jButton2 = new JButton("2");
		jButton2.setBackground(new Color(153, 204, 204));
		jButton2.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_2 = new GridBagConstraints();
		gbc_2.fill = GridBagConstraints.BOTH;
		gbc_2.gridheight = 2;
		gbc_2.insets = new Insets(0, 0, 5, 5);
		gbc_2.gridx = 1;
		gbc_2.gridy = 6;
		panelNormal.add(jButton2, gbc_2);

		jButton3 = new JButton("3");
		jButton3.setBackground(new Color(153, 204, 204));
		jButton3.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_3 = new GridBagConstraints();
		gbc_3.fill = GridBagConstraints.BOTH;
		gbc_3.gridheight = 2;
		gbc_3.insets = new Insets(0, 0, 5, 5);
		gbc_3.gridx = 2;
		gbc_3.gridy = 6;
		panelNormal.add(jButton3, gbc_3);

		jButton4 = new JButton("4");
		jButton4.setBackground(new Color(153, 204, 204));
		jButton4.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_4 = new GridBagConstraints();
		gbc_4.fill = GridBagConstraints.BOTH;
		gbc_4.gridheight = 2;
		gbc_4.insets = new Insets(0, 0, 5, 5);
		gbc_4.gridx = 0;
		gbc_4.gridy = 4;
		panelNormal.add(jButton4, gbc_4);

		jButton5 = new JButton("5");
		jButton5.setBackground(new Color(153, 204, 204));
		jButton5.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_5 = new GridBagConstraints();
		gbc_5.fill = GridBagConstraints.BOTH;
		gbc_5.gridheight = 2;
		gbc_5.insets = new Insets(0, 0, 5, 5);
		gbc_5.gridx = 1;
		gbc_5.gridy = 4;
		panelNormal.add(jButton5, gbc_5);

		jButton6 = new JButton("6");
		jButton6.setBackground(new Color(153, 204, 204));
		jButton6.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_6 = new GridBagConstraints();
		gbc_6.fill = GridBagConstraints.BOTH;
		gbc_6.gridheight = 2;
		gbc_6.insets = new Insets(0, 0, 5, 5);
		gbc_6.gridx = 2;
		gbc_6.gridy = 4;
		panelNormal.add(jButton6, gbc_6);

		jButton7 = new JButton("7");
		jButton7.setBackground(new Color(153, 204, 204));
		jButton7.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_7 = new GridBagConstraints();
		gbc_7.fill = GridBagConstraints.BOTH;
		gbc_7.gridheight = 2;
		gbc_7.insets = new Insets(0, 0, 5, 5);
		gbc_7.gridx = 0;
		gbc_7.gridy = 2;
		panelNormal.add(jButton7, gbc_7);

		jButton8 = new JButton("8");
		jButton8.setBackground(new Color(153, 204, 204));
		jButton8.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_8 = new GridBagConstraints();
		gbc_8.fill = GridBagConstraints.BOTH;
		gbc_8.gridheight = 2;
		gbc_8.insets = new Insets(0, 0, 5, 5);
		gbc_8.gridx = 1;
		gbc_8.gridy = 2;
		panelNormal.add(jButton8, gbc_8);

		jButton9 = new JButton("9");
		jButton9.setBackground(new Color(153, 204, 204));
		jButton9.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_9 = new GridBagConstraints();
		gbc_9.fill = GridBagConstraints.BOTH;
		gbc_9.gridheight = 2;
		gbc_9.insets = new Insets(0, 0, 5, 5);
		gbc_9.gridx = 2;
		gbc_9.gridy = 2;
		panelNormal.add(jButton9, gbc_9);

		// Operations
		pmButton = new JButton("+/-");
		pmButton.setBackground(new Color(153, 204, 204));
		pmButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_pmbtn = new GridBagConstraints();
		gbc_pmbtn.fill = GridBagConstraints.BOTH;
		gbc_pmbtn.gridheight = 2;
		gbc_pmbtn.insets = new Insets(0, 0, 0, 5);
		gbc_pmbtn.gridx = 0;
		gbc_pmbtn.gridy = 8;
		panelNormal.add(pmButton, gbc_pmbtn);

		plusButton = new JButton("+");
		plusButton.setBackground(new Color(153, 153, 255));
		plusButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_plusbtn = new GridBagConstraints();
		gbc_plusbtn.insets = new Insets(0, 0, 5, 0);
		gbc_plusbtn.fill = GridBagConstraints.BOTH;
		gbc_plusbtn.gridheight = 2;
		gbc_plusbtn.gridx = 3;
		gbc_plusbtn.gridy = 6;
		panelNormal.add(plusButton, gbc_plusbtn);

		minusButton = new JButton("-");
		minusButton.setBackground(new Color(153, 153, 255));
		minusButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_minusbtn = new GridBagConstraints();
		gbc_minusbtn.fill = GridBagConstraints.BOTH;
		gbc_minusbtn.gridheight = 2;
		gbc_minusbtn.insets = new Insets(0, 0, 5, 0);
		gbc_minusbtn.gridx = 3;
		gbc_minusbtn.gridy = 4;
		panelNormal.add(minusButton, gbc_minusbtn);

		multiplyButton = new JButton("x");
		multiplyButton.setBackground(new Color(153, 153, 255));
		multiplyButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_mulbtn = new GridBagConstraints();
		gbc_mulbtn.fill = GridBagConstraints.BOTH;
		gbc_mulbtn.gridheight = 2;
		gbc_mulbtn.insets = new Insets(0, 0, 5, 0);
		gbc_mulbtn.gridx = 3;
		gbc_mulbtn.gridy = 2;
		panelNormal.add(multiplyButton, gbc_mulbtn);

		divButton = new JButton("/");
		divButton.setBackground(new Color(153, 153, 255));
		divButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_divbtn = new GridBagConstraints();
		gbc_divbtn.fill = GridBagConstraints.BOTH;
		gbc_divbtn.gridheight = 2;
		gbc_divbtn.insets = new Insets(0, 0, 5, 5);
		gbc_divbtn.gridx = 2;
		gbc_divbtn.gridy = 0;
		panelNormal.add(divButton, gbc_divbtn);

		moduloButton = new JButton("%");
		moduloButton.setBackground(new Color(153, 153, 255));
		moduloButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_modulobtn = new GridBagConstraints();
		gbc_modulobtn.fill = GridBagConstraints.BOTH;
		gbc_modulobtn.gridheight = 2;
		gbc_modulobtn.insets = new Insets(0, 0, 5, 5);
		gbc_modulobtn.gridx = 1;
		gbc_modulobtn.gridy = 0;
		panelNormal.add(moduloButton, gbc_modulobtn);

		dotButton = new JButton(".");
		dotButton.setBackground(new Color(153, 204, 204));
		dotButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_dotbtn = new GridBagConstraints();
		gbc_dotbtn.fill = GridBagConstraints.BOTH;
		gbc_dotbtn.gridheight = 2;
		gbc_dotbtn.insets = new Insets(0, 0, 0, 5);
		gbc_dotbtn.gridx = 2;
		gbc_dotbtn.gridy = 8;
		panelNormal.add(dotButton, gbc_dotbtn);

		resultButton = new JButton("=");
		resultButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		resultButton.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_resbtn = new GridBagConstraints();
		gbc_resbtn.fill = GridBagConstraints.BOTH;
		gbc_resbtn.gridheight = 2;
		gbc_resbtn.gridx = 3;
		gbc_resbtn.gridy = 8;
		panelNormal.add(resultButton, gbc_resbtn);

		clearButton = new JButton("C");
		clearButton.setBackground(new Color(255, 51, 51));
		clearButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_clearbtn = new GridBagConstraints();
		gbc_clearbtn.fill = GridBagConstraints.BOTH;
		gbc_clearbtn.gridheight = 2;
		gbc_clearbtn.insets = new Insets(0, 0, 5, 5);
		gbc_clearbtn.gridx = 0;
		gbc_clearbtn.gridy = 0;
		panelNormal.add(clearButton, gbc_clearbtn);

		delButton = new JButton("DEL");
		delButton.setBackground(new Color(153, 153, 255));
		delButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_delbtn = new GridBagConstraints();
		gbc_delbtn.fill = GridBagConstraints.BOTH;
		gbc_delbtn.gridheight = 2;
		gbc_delbtn.insets = new Insets(0, 0, 5, 0);
		gbc_delbtn.gridx = 3;
		gbc_delbtn.gridy = 0;
		panelNormal.add(delButton, gbc_delbtn);
	}

	/**
	 * Initialize the action listener on the buttons
	 */
	private void initializeEvent() {
		final Container con = (Container) panelNormal;
		Component[] comps = con.getComponents();

		for (Component c : comps) {
			if (c instanceof JButton) {
				try {
					JButton jb = (JButton) c;
					jb.addActionListener(new CalculatorActionListener(resultField, jb));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
