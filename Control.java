import java.awt.event.*;

public class Control{
    private Model model;
    private View view;

    Control(Model model,View view){
        this.model = model;
        this.view = view;
        GameStart(); 
    }
    
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Control control = new Control(model,view);
        view.SetControlObject(control);
    }   
    

    public void GameStart(){
        model.CreateEmptyArray();
        model.RandomDiceSide();
        view.repaint();
        view.CreateGameScreen();
        view.rollleft_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.CreateEmptyArray();
                model.RollLeft();
                view.repaint();
            }
        });

        view.rollright_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.CreateEmptyArray();
                model.RollRight();
                view.repaint();
            }
        });

        view.rollup_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.CreateEmptyArray();
                model.RollUp();
                view.repaint();
            }
        });

        view.rolldown_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.CreateEmptyArray();
                model.RollDown();
                view.repaint();
            }
        });

        view.clockwise_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.CreateEmptyArray();
                model.Clockwise();
                view.repaint();
            }
        });

        view.counterclockwise_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.CreateEmptyArray();
                model.Counterclockwise();
                view.repaint();
            }
        });
            
        view.exit_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }

    public int GetFrontValueFromControl(){
        return model.GetFrontValue();
    }
    
    public String[][] GetDiceArrayFromControl(){
        return model.GetDiceArray();
    }

}