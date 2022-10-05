package plagiarism;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.border.EmptyBorder;
public class Plagiarism extends JFrame {
	File efile;
	private final JPanel contentPane;
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plagiarism frame = new Plagiarism();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Plagiarism() {
		setBackground(Color.ORANGE);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 102));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblPlagiarismChecker = new JLabel("PLAGIARISM CHECKER");
		lblPlagiarismChecker.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 18));
		lblPlagiarismChecker.setBounds(198, 11, 198, 23);
		contentPane.add(lblPlagiarismChecker);
		JLabel lblEnterThePath = new JLabel("Enter the path of the file to be checked");
		lblEnterThePath.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterThePath.setBounds(45, 70, 267, 14);
		contentPane.add(lblEnterThePath);

		textField = new JTextField();
		textField.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		textField.setBounds(310, 69, 212, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Arial Black", Font.BOLD, 14));
		textArea.setBounds(95, 145, 404, 180);
		contentPane.add(textArea);
		textArea.setEditable(false);
		TextArea textArea2 = new TextArea();
		textArea2.setFont(new Font("Arial Black", Font.BOLD, 14));
		textArea2.setBounds(95, 145, 404, 180);
		contentPane.add(textArea2);
		textArea.setEditable(false);
		JButton btnNewButton = new JButton("Show More");
		JButton btnCheckPlagiriasm = new JButton("Check Plagiarism");
		btnCheckPlagiriasm.setBackground(new Color(255, 0, 0));
		btnCheckPlagiriasm.setForeground(Color.WHITE);
		btnCheckPlagiriasm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Plagirism obj = new Plagirism();

				obj.checkPath = textField.getText();
				efile = new File(obj.checkPath);
				if (obj.checkPath.isEmpty())
					JOptionPane.showMessageDialog(null, "The Path File is Empty, Enter the Proper Path File Name");
				else if (!efile.isFile()) {
					JOptionPane.showMessageDialog(null, "Wrong Path, Enter the Proper Path File Name");

				} else {
					try {

						obj.backend();
					} catch (Exception e) {
						e.printStackTrace();
					}
					textArea.setText(obj.aString);
					btnCheckPlagiriasm.setText("Check Plagiarism");
					btnCheckPlagiriasm.setBackground(new Color(255, 0, 0));
					btnCheckPlagiriasm.setForeground(Color.WHITE);
					
				}

			}

		});
		btnCheckPlagiriasm.setBounds(219, 101, 146, 23);
		contentPane.add(btnCheckPlagiriasm);
		btnCheckPlagiriasm.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}
}