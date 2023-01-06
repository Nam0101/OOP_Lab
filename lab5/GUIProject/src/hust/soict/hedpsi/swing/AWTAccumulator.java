
package hust.soict.hedpsi.swing;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/**
 * @author NamNV
 *
 */
public class AWTAccumulator extends Frame {
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0;

	public AWTAccumulator() {
		setLayout(new GridLayout(2, 2));
		add(new Label("Enter an integer: "));
		tfInput = new TextField(10);
		add(tfInput);
		tfInput.addActionListener(new TFInputListener());

		add(new Label("The Accumulated Sum is: "));
		tfOutput = new TextField(10);
		tfOutput.setEditable(false);
		add(tfOutput);

		setTitle("AWT Accumulator");
		setSize(350, 120);
		setVisible(true);

	}

	private class TFInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}

	public static void main(String[] args) {
		new AWTAccumulator();
	}

}
