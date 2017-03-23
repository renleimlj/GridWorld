import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Calc extends Frame implements ActionListener
{
	private TextField num1, num2;
	private Button pls, sub, mul, div, ok;
	private float x, y;
	private int marks;
	private TextField mark, equal, ans;

	public Calc()
	{
		super("Easy Calculator");
		int height = 100, width = 200, l1 = 400, l2 = 350;
		int hang = 2, lie = 5;
		this.pls = new Button("+");
		this.sub = new Button("-");
		this.mul = new Button("*");
		this.div = new Button("/");
		this.mark = new TextField(" ");
		this.equal = new TextField("=");
		this.ok = new Button("ok");
		this.ans = new TextField(" ");
		num1 = new TextField(" ");
		num2 = new TextField(" ");
		this.setSize(width, height);
		this.setBackground(Color.white);
		this.setLocation(l1, l2);
		this.setLayout(new GridLayout(hang, lie));
		equal.setEditable(false);
		mark.setEditable(false);
		ans.setEditable(false);
		this.add(num1);
		this.add(mark);
		this.add(num2);
		this.add(equal);
		this.add(ans);
		this.add(pls);
		this.add(sub);
		this.add(mul);
		this.add(div);
		this.add(ok);
		pls.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		ok.addActionListener(this);
		this.addWindowListener(new Ada());
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		int h1 = 1, h2 = 2, h3 = 3, h4 = 4;
		if (ae.getSource() == ok) {
			x = Float.parseFloat(num1.getText());
			y = Float.parseFloat(num2.getText());
			if (marks == h1) {
				String s = String.valueOf(x+y);
				ans.setText(s);
			} else if (marks == h2) {
				String s = String.valueOf(x-y);
				ans.setText(s);
			} else if (marks == h3) {
				String s = String.valueOf(x*y);
				ans.setText(s);
			} else if (marks == h4) {
				if (y == 0) {
					ans.setText("Divided by 0!");
				} else {
					String s = String.valueOf(x/y);
					ans.setText(s);
				}
			}
		} else if (ae.getSource() == pls) {
			mark.setText("+");
			marks = h1;
		} else if (ae.getSource() == sub) {
			mark.setText("-");
			marks = h2;
		} else if (ae.getSource() == mul) {
			mark.setText("*");
			marks = h3;
		} else if (ae.getSource() == div) {
			mark.setText("/");
			marks = h4;
		} 
	}

	public static void main(String []args)
	{
		Calc mycal = new Calc();
	}
}

class Ada extends WindowAdapter
{
	public void windowClosing(WindowEvent we)
	{
		Frame f = (Frame)we.getSource();
		f.setVisible(false);
		f.dispose();
		System.exit(0);
	}
}