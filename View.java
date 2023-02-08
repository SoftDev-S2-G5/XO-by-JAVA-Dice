import java.awt.*;
import javax.swing.*;

public class View extends JFrame {
    private Control control;
    private int table_panel_size = 400;

    JLabel header = new JLabel();

    JButton rollleft_btn = new JButton("Roll Left");
    JButton rollright_btn = new JButton("Roll Right");
    JButton rollup_btn = new JButton("Roll Up");
    JButton rolldown_btn = new JButton("Roll Down");
    JButton clockwise_btn = new JButton("Clockwise");
    JButton counterclockwise_btn = new JButton("Counter Clockwise");
    JButton exit_btn = new JButton("Exit");

    JFrame game_frame = new JFrame();

    JPanel empty_panel = new JPanel();
    JPanel xo_table_panel = new JPanel();
    JPanel optionButton_panel = new JPanel();

    //Create window for draw the table
    public void CreateGameScreen(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(700,700);

        empty_panel.setSize(800,500);
        optionButton_panel.setSize(800,100);

        header.setBackground(Color.pink);
        header.setForeground(Color.BLACK);
        header.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setText("Dice");
        header.setOpaque(true);

        rollleft_btn.setPreferredSize(new Dimension(150,40));
        rollright_btn.setPreferredSize(new Dimension(150,40));
        rollup_btn.setPreferredSize(new Dimension(150,40));
        rolldown_btn.setPreferredSize(new Dimension(150,40));
        clockwise_btn.setPreferredSize(new Dimension(150,40));
        counterclockwise_btn.setPreferredSize(new Dimension(150,40));
        exit_btn.setPreferredSize(new Dimension(150,40));

        optionButton_panel.setBackground(Color.pink);
        optionButton_panel.add(rollleft_btn);
        optionButton_panel.add(rollright_btn);
        optionButton_panel.add(rollup_btn);
        optionButton_panel.add(rolldown_btn);
        optionButton_panel.add(clockwise_btn);
        optionButton_panel.add(counterclockwise_btn);
        optionButton_panel.add(exit_btn);

        this.setTitle("Tic-Tac-Toe Game");

        xo_table_panel.setPreferredSize(new Dimension(table_panel_size, table_panel_size));
        xo_table_panel.setBackground(Color.white);

        
        empty_panel.add(xo_table_panel);
        xo_table_panel.setBorder(BorderFactory.createLineBorder(Color.white));
        this.add(header,BorderLayout.NORTH);
        this.add(empty_panel,BorderLayout.CENTER);
        this.add(optionButton_panel,BorderLayout.SOUTH);
        this.setResizable(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //Draw table
    public void DrawTable(){
        int frontvalue = control.GetFrontValueFromControl();
        String[][] DiceArray = control.GetDiceArrayFromControl();
        int responsive = table_panel_size / 3;
        xo_table_panel.removeAll();
        Graphics2D g2d = (Graphics2D) xo_table_panel.getGraphics();
        g2d.setStroke(new BasicStroke(2));
        for (int i = 0 ; i < 3 ; i++){
            g2d.setColor(Color.white);
            g2d.drawLine(0, i * responsive, table_panel_size, i * responsive);
            for (int j = 0 ; j < 3 ; j++){
                g2d.setColor(Color.white);
                g2d.drawLine(j * responsive, 0, j * responsive, table_panel_size);
                g2d.setFont(new Font("Calibri", Font.PLAIN, responsive));         
                g2d.setColor(Color.black);               
                g2d.setFont(new Font("Calibri", Font.PLAIN, 500));         
                if(frontvalue == 1 || frontvalue == 4){
                    g2d.setColor(Color.red);
                }else{
                    g2d.setColor(Color.black);
                }
                g2d.drawString(DiceArray[i][j],(responsive * j) + 5,(responsive * (i + 1)) - 50);
                
                g2d.setFont(new Font("Calibri", Font.PLAIN, responsive));         

            }
        }
        
    }
    public void paint(Graphics g){
        super.paint(g);
        DrawTable();
    }

    public void SetControlObject(Control control){
        this.control = control; //Set value to line 5
    }
}
