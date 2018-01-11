import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Driver extends JFrame implements ActionListener{

  private Container pane;
  private JButton b1, b2;
  private JTextField t1, t2;
  private long startTime;
  private long stopTime;
  private boolean running = false;
  //  private Timer timer;

  public void start(){
    this.startTime = System.currentTimeMillis();
    this.running = true;
  }

  public void stop(){
    this.stopTime = System.currentTimeMillis();
    this.running = false;
  }

  public long getTime(){
    long time;
    if (running){
      time = System.currentTimeMillis() - startTime;
    }
    else{
      time = stopTime - startTime;
    }
    return time;
  }

  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    //   String text = t1.getText();
    //   double d = Double.parseDouble(text);
    //    System.out.println(s);
    //    System.out.println(text);
    //    System.out.println(d);

    if (s.equals("Start")){
      //      timer.start();
      start();
      t2.setText("counting...");
      while (getTime() > 0 && getTime() < 10000){
        if (getTime() == 1000){
        t2.setText("1 s");
      }
      }

    }
    if (s.equals("Stop")){
      //    timer.stop();
      stop();
      t2.setText("done");
      t1.setText(Long.toString(getTime()) + " ms");
    }
  }

  public Driver(){
    this.setTitle("Timing...");
    this.setSize(600, 150);
    this.setLocation(800, 100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    b1 = new JButton("Start");
    b2 = new JButton("Stop");
    t1 = new JTextField(50);
    t2 = new JTextField(50);
    //    timer = new Timer(1000, this);

    b1.addActionListener(this);
    b2.addActionListener(this);
    t1.addActionListener(this);
    //    timer.addActionListener(this);

    pane.add(t1);
    pane.add(b1);
    pane.add(b2);
    pane.add(t2);

    t2.setEditable(false);

  }

  public static void main(String[] args){
    Driver g = new Driver();
    g.setVisible(true);
  }


}
