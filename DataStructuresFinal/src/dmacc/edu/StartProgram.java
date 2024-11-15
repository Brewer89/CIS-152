package dmacc.edu;
/** Main for QuickLube program
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


import javax.swing.JFrame;

import view.CarDriverPanel;

public class StartProgram {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		CarDriverPanel panel = new CarDriverPanel();
		frame.add(panel);

		frame.setSize(450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
