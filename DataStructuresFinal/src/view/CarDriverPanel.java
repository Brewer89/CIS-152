package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Scheduling;

/** User input panel creation
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Oct 22, 2024 
*/
/*  
* OS: Win 11
* IDE: Eclipse 2024-06
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/


public class CarDriverPanel extends JPanel {
	//create all variables used in the GUI
	private JLabel carMakeLabel = new JLabel("Car Make");
	private JTextField carMake = new JTextField();
	private JLabel carModelLabel = new JLabel("Car Model");
	private JTextField carModel = new JTextField();
	private JLabel carYearLabel = new JLabel("Car Year");
	private JTextField carYear = new JTextField();
	private JLabel customerLabel = new JLabel("Customer Name");
	private JTextField customer = new JTextField();
	private JCheckBox oil = new JCheckBox("Oil");
	private JCheckBox brakes = new JCheckBox("Brakes");
	private JCheckBox tires = new JCheckBox("Tires");
	private JLabel title = new JLabel("Enter your information to schedule your car service.");
	private JButton buttonSchedule = new JButton("Schedule");
	private JButton printNextQL = new JButton("Get Next Quick Lube customer");
	private JButton printNextFS = new JButton("Get Next Full Service customer");
	private JTextField output = new JTextField();
	private Scheduling schedule;
	
	public CarDriverPanel() {
		//Create the panel, layout, and all user interface options
		JPanel layout = new JPanel();
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		layout.setLayout(new BoxLayout(layout, BoxLayout.PAGE_AXIS));
		layout.add(title);
		layout.add(carMakeLabel);
		layout.add(carMake);
		layout.add(carModelLabel);
		layout.add(carModel);
		layout.add(carYearLabel);
		layout.add(carYear);
		layout.add(customerLabel);
		layout.add(customer);
		layout.add(oil);
		layout.add(brakes);
		layout.add(tires);
		layout.add(buttonSchedule);
		layout.add(printNextQL);
		layout.add(printNextFS);
		layout.add(output);
		add(layout, BorderLayout.CENTER);
		
		ScheduleButtonListener bl = new ScheduleButtonListener();
		PrintButtonListener b2 = new PrintButtonListener();
		buttonSchedule.addActionListener(bl);
		printNextQL.addActionListener(b2);
		printNextFS.addActionListener(b2);
		schedule = new Scheduling();
	}
	//This is for the schedule button action 
	class ScheduleButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String make = carMake.getText();
			String model = carModel.getText();
			String year = carYear.getText();
			String customerName = customer.getText();
			output.setText(schedule.inputCheck(make, model, year, customerName, oil.isSelected(), brakes.isSelected(), tires.isSelected()));
		}
	}
	
	//The is for the next customer buttons
	class PrintButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == printNextQL) {
				output.setText(schedule.nextQuickLube());
			}
			if (e.getSource() == printNextFS) {
				output.setText(schedule.nextFullService());
			}
		}
	}
	
	
}
