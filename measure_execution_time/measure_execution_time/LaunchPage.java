import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LaunchPage implements ActionListener {
    execution ex = new execution();   
    JFrame frame = new JFrame();
    JLabel label1 = new JLabel("Measure execution time test");
    JPanel panel1 = new JPanel();
    JProgressBar bar = new JProgressBar();
    JButton btnpr = new JButton("start");
    JLabel lwait = new JLabel("");

    LaunchPage() {
               
        label1.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label1.setBounds(150, 15, 300, 30);
        frame.getContentPane().add(label1);

        lwait.setFont(new Font("MV Boli", Font.PLAIN, 20));
        lwait.setBounds(250, 120, 300, 30);
        frame.getContentPane().add(lwait);
        lwait.setVisible(false);

        panel1.setBackground(new Color(145, 221, 155));
        panel1.setPreferredSize(new Dimension(100, 50));

        bar.setValue(0);
        bar.setBounds(100, 150, 400, 30);
        bar.setStringPainted(true);
        bar.setVisible(true);

        btnpr.setBounds(200, 300, 200, 100);
        btnpr.setFont(new Font(null, Font.PLAIN, 40));
        btnpr.addActionListener(this);
        frame.add(btnpr);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(700, 200, 600, 500);
        frame.add(bar);
        frame.setTitle("CPU Performance");
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(245, 221, 155));
        frame.setVisible(true);
        frame.add(panel1, BorderLayout.NORTH);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnpr) {
            lwait.setVisible(true);      
            fill();
        }
    }
    public void fill() {
        
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    final int progress = i;
                    SwingUtilities.invokeLater(() -> {
                        lwait.setText("Please wait.");
                        bar.setValue(progress);
                    });
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lwait.setText("Please wait..");
                }           
                    ex.gen();
                    PageShowTime show = new PageShowTime(ex.getnumtime());
                    frame.dispose();
    
                return null;
            }
        };
        worker.execute();
    } 
}
