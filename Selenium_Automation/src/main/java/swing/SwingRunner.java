package swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.testng.TestNG;


public class SwingRunner {

	
	private static final Map<String, String > stateMap= new HashMap<>();
	private static final String STATE_SELECTED_TEST="stateSelectedTest";
	private static final String STATE_SELECTED_CLIENT="stateSelectedClient";
	
	
	private static void createAndShowGUI() {
		JFrame frame= new JFrame("Automation Testing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane= frame.getContentPane();
		contentPane.add(new JLabel("Please Select"));
		contentPane.setLayout(new FlowLayout());
		
		JButton runBtn =new JButton("Run");
		
		JPanel panel= new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		String[] testNames= new String[] {"com.test.LoginfunctionTest"};
		String[] clientNames= new String[] {"1001","1002"};
		
		/* default state*/
		
		
		stateMap.put(STATE_SELECTED_TEST, testNames[0]);
		stateMap.put(STATE_SELECTED_CLIENT, clientNames[0]);
		
		final JComboBox<String> testNameComboBox= new JComboBox<String>(testNames) {
			@Override
			public void setPopupVisible(boolean visible) {
				
				if (visible) {
					super.setPopupVisible(visible);
				}
			}
			
		};
		
		
		final JComboBox<String> clientNameComboBox= new JComboBox<String>(clientNames) {
			@Override
			public void setPopupVisible(boolean visible) {
				
				if (visible) {
					super.setPopupVisible(visible);
				}
			}
			
		};
		
	final CheckBoxRender testNameRender = new 	CheckBoxRender(testNames);
	final CheckBoxRender clientNameRender = new CheckBoxRender(clientNames);
		
		
	testNameComboBox.addItemListener(e ->{
	
			String item = (String) e.getItem();
			
			if(e.getStateChange() == ItemEvent.DESELECTED) {
				clientNameRender.setSelected(item, false);
			}
			
			
			else{
				clientNameRender.setSelected(item, true);
				stateMap.put(STATE_SELECTED_CLIENT, item);
			}
	});
	
	
	
	panel.add(testNameComboBox);
	panel.add(clientNameComboBox);
	
	contentPane.add(panel);
	
	runBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				
				Class cls = Class.forName(stateMap.get(STATE_SELECTED_TEST)+"_"+ stateMap.get(STATE_SELECTED_CLIENT));
			System.out.println("Running......"+ cls.getCanonicalName());
			
			TestNG tng = new TestNG();
			tng.setTestClasses(new Class[] {cls});
			tng.run();
			
			} catch(Exception e1){
				e1.printStackTrace();
			}
			
			}
			
	});
	
	contentPane.add(runBtn);
	
	//dispplay the window
	frame.pack();
	frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	
	
	
	
	
	
		
		
	}
	

