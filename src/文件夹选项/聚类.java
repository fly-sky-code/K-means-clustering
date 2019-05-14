package 文件夹选项;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class 聚类 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					聚类 frame = new 聚类();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public 聚类() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u56FE\u7247\u663E\u793A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				调用 d=new 调用();
				d.main(null);
			}
			
		});
		btnNewButton.setBounds(32, 79, 124, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u6587\u672C\u663E\u793A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("E:/kmeansResults.txt");
			}
		});
		button.setBounds(32, 185, 124, 23);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(166, 186, 254, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("\u6253\u5F00\u6587\u4EF6");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(textField.getText());
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(456, 185, 93, 23);
		contentPane.add(button_1);
	}
}
