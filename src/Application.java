import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application
{
    static Node temp=null, head=null;

    public static void main(String[] args)
    {
        //Frame for error message
        JFrame error=new JFrame("WARNING !!!");
        error.setSize(400,100);
        JPanel message=new JPanel();
        JLabel msg=new JLabel("Kindly fill all the required fields to add participant.");
        message.add(msg);
        error.add(message);
        error.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //Main Frame
        JFrame mainFrame=new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800,800);

        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));


        //Name textbox
        JPanel p_name=new JPanel();
        p_name.setLayout(new FlowLayout(FlowLayout.CENTER));
        p_name.add(new JLabel("Name: "));
        JTextField tf=new JTextField();
        tf.setPreferredSize(new Dimension(200,25));
        p_name.add(tf);
        mainPanel.add(p_name);

        //Time textbox
        JPanel p_time=new JPanel();
        p_time.setLayout(new FlowLayout(FlowLayout.CENTER));
        p_time.add(new JLabel("Time (minutes): "));
        JTextField ta=new JTextField();
        ta.setPreferredSize(new Dimension(100,25));
        p_time.add(ta);
        mainPanel.add(p_time);

        //Category
        JPanel p_cat=new JPanel();
        p_cat.setLayout(new FlowLayout(FlowLayout.CENTER));//new BoxLayout(p_cat,BoxLayout.LINE_AXIS));
        p_cat.setSize(200,100);
        p_cat.add(new JLabel("Category: "));
        JPanel buttons=new JPanel();
        buttons.setLayout(new BoxLayout(buttons,BoxLayout.Y_AXIS));
        ButtonGroup bg=new ButtonGroup();
        JRadioButton cat0=new JRadioButton("Half Marathon");
        JRadioButton cat1=new JRadioButton("Open 10K Run");
        JRadioButton cat2=new JRadioButton("Great Delhi Run");
        bg.add(cat0);bg.add(cat1);bg.add(cat2);
        buttons.add(cat0);buttons.add(cat1);buttons.add(cat2);
        p_cat.add(buttons);
        mainPanel.add(p_cat);

        //Buttons
        JPanel p_buttons=new JPanel();
        p_buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton add=new JButton("NEXT");
        JButton submit=new JButton("WINNER");
        JButton cancel=new JButton("EXIT");
        p_buttons.add(add);p_buttons.add(submit);p_buttons.add(cancel);
        mainPanel.add(p_buttons);

        //Output Box
        JPanel p_out=new JPanel();
        p_out.setLayout(new BoxLayout(p_out,BoxLayout.Y_AXIS));
        p_out.add(new JLabel("Winners:"));

        JPanel win_cat0=new JPanel();
        win_cat0.setLayout(new BoxLayout(win_cat0,BoxLayout.Y_AXIS));
        win_cat0.add(new JLabel("1. Half Marathon (20km)"));
        JTextField win11=new JTextField();
        JTextField win12=new JTextField();
        win_cat0.add(win11);win_cat0.add(win12);

        JPanel win_cat1=new JPanel();
        win_cat1.setLayout(new BoxLayout(win_cat1,BoxLayout.Y_AXIS));
        win_cat1.add(new JLabel("2. Open 10K Run (10km)"));
        JTextField win21=new JTextField();
        JTextField win22=new JTextField();
        win_cat1.add(win21);win_cat1.add(win22);

        JPanel win_cat2=new JPanel();
        win_cat2.setLayout(new BoxLayout(win_cat2,BoxLayout.Y_AXIS));
        win_cat2.add(new JLabel("3. Great Delhi Run (5km)"));
        JTextField win31=new JTextField();
        JTextField win32=new JTextField();
        win_cat2.add(win31);win_cat2.add(win32);

        p_out.add(win_cat0);p_out.add(win_cat1);p_out.add(win_cat2);
        mainPanel.add(p_out);

        //Button Actions
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                try
                {
                    name = tf.getText();
                    if(name.equals(""))
                    {
                        error.setVisible(true);
                        return;
                    }
                }
                catch(Exception e1)
                {
                    error.setVisible(true);
                    return;
                }

                int time;
                try
                {
                    time=Integer.parseInt(ta.getText());
                }
                catch (Exception e2)
                {
                    error.setVisible(true);
                    return;
                }

                int category;
                if(cat0.isSelected())
                    category=0;
                else if(cat1.isSelected())
                    category=1;
                else if(cat2.isSelected())
                    category=2;
                else
                {
                    error.setVisible(true);
                    return;
                }
                if(head==null)
                {
                    head=new Node(new Runner(name,time,category));
                    temp=head;
                }
                else
                {
                    temp.next=new Node(new Runner(name,time,category));
                    temp=temp.next;
                }
                tf.setText("");
                ta.setText("");
                bg.clearSelection();
            }
        });
        submit.addActionListener(new ActionListener() { //Generate result
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Node cat1wins=Winner.winners(Runner.HALF_MARATHON,head);
                Node cat2wins=Winner.winners(Runner.OPEN_10K_RUN,head);
                Node cat3wins=Winner.winners(Runner.GREAT_DELHI_RUN,head);


                if(cat1wins!=null)
                {
                    Runner win1 = cat1wins.getRun();
                    win11.setText("1st " + win1.getName() + ":- Rs. 2,80,000/-");

                    if (cat1wins.next != null)
                    {
                        Runner win2 = cat1wins.getNext().getRun();
                        win12.setText("2nd " + win2.getName() + ":- Rs. 2,10,000/-");
                    }
                }
                if(cat2wins!=null)
                {
                    Runner win1 = cat2wins.getRun();
                    win21.setText("1st " + win1.getName() + ":- Rs. 1,90,000/-");

                    if (cat2wins.next != null)
                    {
                        Runner win2 = cat2wins.getNext().getRun();
                        win22.setText("2nd " + win2.getName() + ":- Rs. 1,50,000/-");
                    }
                }
                if(cat3wins!=null)
                {
                    Runner win1 = cat3wins.getRun();
                    win31.setText("1st " + win1.getName() + ":- Rs. 1,35,000/-");

                    if(cat3wins.next!=null)
                    {
                        Runner win2=cat3wins.getNext().getRun();
                        win32.setText("2nd "+win2.getName()+":- Rs. 1,15,000/-");
                    }
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}
