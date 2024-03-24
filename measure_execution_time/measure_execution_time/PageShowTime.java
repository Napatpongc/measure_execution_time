
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PageShowTime implements ActionListener  {
    String ans;
    execution ex = new execution();
    JFrame frame = new JFrame();
    JPanel bluePanel = new JPanel();
    JTextField txt1 = new JTextField();
    JLabel label1 = new JLabel("Measure execution time test");
    JLabel labeltext = new JLabel("Execution time");
    JLabel lcomp = new JLabel("computer compare");
    JLabel labelans = new JLabel();
    JLabel labelsecond = new JLabel("second");
    JLabel labelsecond2 = new JLabel("second");
    JPanel panel1 = new JPanel();
    JButton bback = new JButton("back");
    JButton bsub = new JButton("submit");
    JLabel part1 = new JLabel();
    JLabel part2 = new JLabel();
    JLabel partt = new JLabel("times");
    JLabel partans = new JLabel();

    PageShowTime(String text) {
        ans = text;
           
        label1.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label1.setBounds(150, 15, 300, 30);
        frame.getContentPane().add(label1);

        labeltext.setFont(new Font("MV Boli", Font.PLAIN, 30));
        labeltext.setBounds(50, 40, 300, 200);
        frame.getContentPane().add(labeltext);

        lcomp.setFont(new Font("MV Boli", Font.PLAIN, 30));
        lcomp.setBounds(20, 115, 280, 200);
        frame.getContentPane().add(lcomp);


        labelans.setFont(new Font("MV Boli", Font.PLAIN, 30));
        labelans.setBounds(290, 40, 200, 200);
        labelans.setText(ans);
        frame.getContentPane().add(labelans);

        part1.setFont(new Font("MV Boli", Font.PLAIN, 20));
        part1.setBounds(130, 185, 200, 200);
        frame.getContentPane().add(part1);
        part1.setVisible(false);

        part2.setFont(new Font("MV Boli", Font.PLAIN, 20));
        part2.setBounds(130, 210, 340, 200);
        frame.getContentPane().add(part2);
        part2.setVisible(false);

        partt.setFont(new Font("MV Boli", Font.PLAIN, 20));
        partt.setBounds(390, 185, 300, 200);
        frame.getContentPane().add(partt);
        partt.setVisible(false);

        partans.setFont(new Font("MV Boli", Font.PLAIN, 20));
        partans.setBounds(340, 185, 200, 200);
        frame.getContentPane().add(partans);
        partans.setVisible(false);

        labelsecond.setFont(new Font("MV Boli", Font.PLAIN, 30));
        labelsecond.setBounds(400, 40, 200, 200);
        labelsecond.setVisible(true);
        frame.getContentPane().add(labelsecond);

        labelsecond2.setFont(new Font("MV Boli", Font.PLAIN, 30));
        labelsecond2.setBounds(370, 115, 200, 200);
        labelsecond2.setVisible(true);
        frame.getContentPane().add(labelsecond2);

        txt1.setFont(new Font(null, Font.PLAIN, 15));
        txt1.setBounds(295, 205, 60, 25);
        frame.add(txt1);

        panel1.setBackground(new Color(145, 221, 155));
        panel1.setPreferredSize(new Dimension(100, 50));

        bback.setBounds(20,400,70,30);
        bback.addActionListener(this);
        frame.add(bback);

        bsub.setBounds(480,200,85,30);
        bsub.addActionListener(this);
        frame.add(bsub);

        bluePanel.setBackground(new Color(162, 228, 255));
        bluePanel.setBounds(100,260,370,80);
        bluePanel.setPreferredSize(new Dimension(100, 50));
        frame.add(bluePanel);
        bluePanel.setVisible(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(700, 200, 600, 500);
        frame.setTitle("CPU Performance");
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(245, 221, 155));
        frame.setVisible(true);
        frame.add(panel1, BorderLayout.NORTH);
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bback) {
            LaunchPage lp = new LaunchPage();
            frame.dispose();
     
        }else if(e.getSource() == bsub){
            String text;
            double y = Double.parseDouble(ans);
            double c = Double.parseDouble(txt1.getText());
            if(y>c){
                double a = y/c;
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                text = decimalFormat.format(a);  
                part1.setText("computer compare is");
                partans.setText(text);
                part2.setText("as fast as your computer");
                part1.setVisible(true);
                partt.setVisible(true);
                part2.setVisible(true);
                partans.setVisible(true);
                bluePanel.setVisible(true);
            }else if(c>y){
                double a = c/y;
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                text = decimalFormat.format(a);
                part1.setText("  your computer is");
                partans.setText(text);
                part2.setText("  as fast as computer compare");
                part1.setVisible(true);
                partt.setVisible(true);
                part2.setVisible(true);
                partans.setVisible(true);
                bluePanel.setVisible(true);

            }
        }
    }  
}
