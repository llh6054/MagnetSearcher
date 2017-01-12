package com.magnetsearcher.action;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.magnetsearcher.util.ProcessUtil;
import com.magnetsearcher.website.BtSoWebsite;
import com.magnetsearcher.website.Website;

public class SearchWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton searchButton = new JButton("Search");
	private final JLabel keywordsLabel = new JLabel("KeyWords");
	private JTextField keywordsField = new JTextField(20); 
	
	private ActionListener searchListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(keywordsField.getText());
			Website website = new BtSoWebsite(keywordsField.getText());
			ProcessUtil.resultNeedProcess(keywordsField.getText());
			website.search();
			keywordsField.setText("finished");
		}
	};		
	
	public SearchWindow(String windowName) {
		this.setLayout(new FlowLayout());
		this.setBounds(100, 100, 500, 300);
		this.add(keywordsLabel);
		this.add(keywordsField);
		this.add(searchButton);
		searchButton.addActionListener(searchListener);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle(windowName);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new SearchWindow("MagnetSearcher");
	}

}
