/*
 * import java.awt.*; import java.awt.event.ActionEvent; import
 * java.awt.event.ActionListener; import javax.swing.*;
 * 
 * 
 * class test extends JFrame implements ActionListener{
 * 
 * JPanel panel01,panel02,panel03,panel04,panel05; private final JButton sub,
 * sub5; JPanel cardPanel; CardLayout layout; JRadioButton
 * opt11,opt12,opt21,opt22,opt31,opt33,opt32,opt41,opt42,opt43,opt51,opt52;
 * 
 * 
 * public static void main(String[] args) { test frame = new test();
 * frame.setTitle("Questions"); frame.setBounds(250, 40, 900, 650);
 * frame.setDefaultCloseOperation(EXIT_ON_CLOSE); frame.setResizable(false);
 * frame.setVisible(true); }
 * 
 * public test() {
 * 
 * //panel01 panel01 = new JPanel(); panel01.setLayout(null);
 * 
 * 
 * JLabel head = new JLabel("Questions 1/5"); head.setFont(new Font("CAMBRIA",
 * Font.BOLD, 35)); head.setSize(300, 30); head.setLocation(130, 100);
 * head.setForeground(Color.BLACK); panel01.add(head);
 * 
 * 
 * JLabel q1 = new JLabel("Were you tested positive in the first wave?");
 * q1.setFont(new Font("CAMBRIA", Font.BOLD, 22)); q1.setSize(450, 40);
 * q1.setLocation(80, 150); panel01.add(q1);
 * 
 * 
 * ButtonGroup bg1 = new ButtonGroup(); opt11=new JRadioButton("A). YES");
 * opt11.setFont(new Font("CAMBRIA", Font.BOLD, 18)); opt11.setLocation(80,200);
 * opt11.setSize(230,30); bg1.add(opt11); panel01.add(opt11);
 * 
 * 
 * opt12=new JRadioButton("B). NO"); opt12.setFont(new Font("CAMBRIA",
 * Font.BOLD, 18)); opt12.setLocation(80,250); opt12.setSize(230,30);
 * 
 * 
 * bg1.add(opt11); panel01.add(opt11); bg1.add(opt12); panel01.add(opt12);
 * 
 * 
 * 
 * sub = new JButton("Next"); sub.setFont(new Font("CAMBRIA", Font.BOLD, 16));
 * sub.setSize(100, 30); sub.setBackground(new Color(50, 205, 50));
 * sub.setForeground(new Color(255, 255, 255)); sub.setLocation(80, 320);
 * sub.addActionListener(this); sub.setActionCommand("panel02");
 * panel01.add(sub);
 * 
 * 
 * 
 * //panel02 panel02 = new JPanel(); panel02.setLayout(null);
 * 
 * JLabel head2 = new JLabel("Questions 2/5"); head2.setFont(new Font("CAMBRIA",
 * Font.BOLD, 35)); head2.setSize(300, 30); head2.setLocation(130, 100);
 * head2.setForeground(Color.BLACK); panel02.add(head2);
 * 
 * JLabel q2 = new JLabel("Did you get Vaccinated?"); q2.setFont(new
 * Font("CAMBRIA", Font.BOLD, 22)); q2.setSize(280, 40); q2.setLocation(80,
 * 150); panel02.add(q2);
 * 
 * 
 * ButtonGroup bg=new ButtonGroup(); opt21 = new JRadioButton("A). YES");
 * opt21.setFont(new Font("CAMBRIA", Font.BOLD, 18)); opt21.setLocation(80,200);
 * opt21.setSize(230,30);
 * 
 * 
 * bg.add(opt21); panel02.add(opt21);
 * 
 * opt22= new JRadioButton("B). NO"); opt22.setFont(new Font("CAMBRIA",
 * Font.BOLD, 18)); opt22.setLocation(80,250); opt22.setSize(230,30);
 * 
 * 
 * bg.add(opt22); panel02.add(opt22);
 * 
 * 
 * JButton sub2 = new JButton("Next"); sub2.setFont(new Font("CAMBRIA",
 * Font.BOLD, 16)); sub2.setSize(100, 30); sub2.setBackground(new Color(50, 205,
 * 50)); sub2.setForeground(new Color(255, 255, 255)); sub2.setLocation(80,
 * 320); sub2.addActionListener(this); sub2.setActionCommand("panel03");
 * panel02.add(sub2);
 * 
 * 
 * 
 * //panel03 panel03 = new JPanel(); panel03.setLayout(null);
 * 
 * JLabel head3 = new JLabel("Questions 3/5"); head3.setFont(new Font("CAMBRIA",
 * Font.BOLD, 35)); head3.setSize(300, 30); head3.setLocation(130, 100);
 * head3.setForeground(Color.BLACK); panel03.add(head3);
 * 
 * JLabel q3 = new
 * JLabel("If you were tested positive, were you hospitalized "); q3.setFont(new
 * Font("CAMBRIA", Font.BOLD, 22)); q3.setSize(550, 40); q3.setLocation(80,
 * 150); panel03.add(q3);
 * 
 * q3 = new JLabel("or home quarantined?"); q3.setFont(new Font("CAMBRIA",
 * Font.BOLD, 22)); q3.setSize(550, 40); q3.setLocation(80, 180);
 * panel03.add(q3);
 * 
 * bg=new ButtonGroup(); opt31 = new JRadioButton("A). HOSPITALISED");
 * opt31.setFont(new Font("CAMBRIA", Font.BOLD, 18)); opt31.setLocation(80,230);
 * opt31.setSize(230,30); bg.add(opt31); panel03.add(opt31);
 * 
 * opt32=new JRadioButton("B). HOME QUARANTINED"); opt32.setFont(new
 * Font("CAMBRIA", Font.BOLD, 18)); opt32.setLocation(80,280);
 * opt32.setSize(230,30); bg.add(opt32); panel03.add(opt32);
 * 
 * opt33 = new JRadioButton("C). N/A"); opt33.setFont(new Font("CAMBRIA",
 * Font.BOLD, 18)); opt33.setLocation(80,330); opt33.setSize(230,30);
 * bg.add(opt33); panel03.add(opt33);
 * 
 * JButton sub3 = new JButton("Next"); sub3.setFont(new Font("CAMBRIA",
 * Font.BOLD, 16)); sub3.setSize(100, 30); sub3.setBackground(new Color(50, 205,
 * 50)); sub3.setForeground(new Color(255, 255, 255)); sub3.setLocation(80,
 * 400); sub3.addActionListener(this); sub3.setActionCommand("panel04");
 * panel03.add(sub3);
 * 
 * 
 * 
 * //panel04 panel04 = new JPanel(); panel04.setLayout(null);
 * 
 * JLabel head4 = new JLabel("Questions 4/5"); head4.setFont(new Font("CAMBRIA",
 * Font.BOLD, 35)); head4.setSize(300, 30); head4.setLocation(120, 100);
 * head4.setForeground(Color.BLACK); panel04.add(head4);
 * 
 * 
 * JLabel q4 = new JLabel("Which zone are you currently living in?");
 * q4.setFont(new Font("CAMBRIA", Font.BOLD, 22)); q4.setSize(500, 40);
 * q4.setLocation(80, 150);
 * 
 * panel04.add(q4);
 * 
 * 
 * bg=new ButtonGroup(); opt41 = new JRadioButton("A). Red Zone");
 * opt41.setFont(new Font("CAMBRIA", Font.BOLD, 18)); opt41.setLocation(80,200);
 * opt41.setSize(230,30); bg.add(opt41); panel04.add(opt41);
 * 
 * opt42 = new JRadioButton("B). Orange Zone"); opt42.setFont(new
 * Font("CAMBRIA", Font.BOLD, 18)); opt42.setLocation(80,250);
 * opt42.setSize(230,30); bg.add(opt42); panel04.add(opt42);
 * 
 * opt43 = new JRadioButton("C). Green Zone"); opt43.setFont(new Font("CAMBRIA",
 * Font.BOLD, 18)); opt43.setLocation(80,300); opt43.setSize(230,30);
 * bg.add(opt43); panel04.add(opt43);
 * 
 * JButton sub4 = new JButton("Next"); sub4.setFont(new Font("CAMBRIA",
 * Font.BOLD, 16)); sub4.setSize(100, 30); sub4.setBackground(new Color(50, 205,
 * 50)); sub4.setForeground(new Color(255, 255, 255)); sub4.setLocation(80,
 * 370); sub4.addActionListener(this); sub4.setActionCommand("panel05");
 * panel04.add(sub4);
 * 
 * 
 * 
 * //panel05 panel05 = new JPanel(); panel05.setLayout(null);
 * 
 * JLabel head5 = new JLabel("Questions 5/5"); head5.setFont(new Font("CAMBRIA",
 * Font.BOLD, 35)); head5.setSize(300, 30); head5.setLocation(110, 100);
 * head5.setForeground(Color.BLACK); panel05.add(head5);
 * 
 * 
 * JLabel q5 = new JLabel("Are you following the Guidelines for Covid-19?");
 * q5.setFont(new Font("CAMBRIA", Font.BOLD, 22)); q5.setSize(500, 40);
 * q5.setLocation(80, 150); panel05.add(q5);
 * 
 * bg=new ButtonGroup(); opt51 = new JRadioButton("A). YES"); opt51.setFont(new
 * Font("CAMBRIA", Font.BOLD, 18)); opt51.setLocation(80,200);
 * opt51.setSize(230,30);
 * 
 * 
 * opt52 = new JRadioButton("B). NO"); opt52.setFont(new Font("CAMBRIA",
 * Font.BOLD, 18)); opt52.setLocation(80,250); opt52.setSize(230,30);
 * 
 * 
 * bg.add(opt51); bg.add(opt52); panel05.add(opt52); panel05.add(opt51);
 * 
 * 
 * sub5 = new JButton("Finish"); sub5.setFont(new Font("CAMBRIA", Font.BOLD,
 * 16)); sub5.setSize(100, 30); sub5.setBackground(new Color(50, 205, 50));
 * sub5.setForeground(new Color(255, 255, 255)); sub5.setLocation(80, 320);
 * sub5.addActionListener(this); panel05.add(sub5);
 * 
 * 
 * 
 * cardPanel = new JPanel(); layout = new CardLayout();
 * cardPanel.setLayout(layout);
 * 
 * cardPanel.add(panel01, "panel01"); cardPanel.add(panel02, "panel02");
 * cardPanel.add(panel03, "panel03"); cardPanel.add(panel04, "panel04");
 * cardPanel.add(panel05, "panel05");
 * 
 * Container contentPane = getContentPane(); contentPane.add(cardPanel,
 * BorderLayout.CENTER); }
 * 
 * @Override public void actionPerformed(ActionEvent e) { String cmd =
 * e.getActionCommand(); layout.show(cardPanel, cmd); if (e.getSource() == sub5)
 * { JOptionPane.showMessageDialog(sub, "Thank You you will be Logged Out");
 * dispose(); } } }
 * 
 * 
 * 
 * 
 */