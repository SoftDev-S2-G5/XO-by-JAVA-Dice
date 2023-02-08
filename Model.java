public class Model {
    private String[][] DiceArray = new String[3][3];;
    private int max = 6;
    private int min = 1;
    private int range = max - min + 1;

    // init value side
    private int final_Top, final_Buttom, final_Front, final_Back, final_Left, final_Right;

    public String[][] GetDiceArray() {
        return DiceArray;
    }
    
    public int GetFrontValue(){
        return final_Front;
    }

    public void CreateEmptyArray() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                DiceArray[i][j] = " ";
            }
        }
    }

    public void RandomDiceSide() {
        int Top = 0, Buttom = 0, Front = 0, Back = 0, Left = 0,Right = 0; 
        int randTop, randFront, randLeft;
        
        randTop = (int) (Math.random() * range) + min;
        Buttom = 7 - randTop;
        randFront = (int) (Math.random() * range) + min;
        Back = 7 - randFront;
        randLeft = (int) (Math.random() * range) + min;
        Right = 7 - randLeft;
        System.out.println(randTop);
        System.out.println(randFront);
        System.out.println(randLeft);

        if ((randTop != randLeft) && (randTop != randFront) && (randLeft != randFront) && (randTop != Right)
                && (randTop != Back) && (randFront != Buttom) && (randFront != Right)) {
                final_Top = randTop;
                final_Buttom = Buttom;
                final_Left = randLeft;
                final_Right = Right;
                final_Front = randFront;
                final_Back = Back;
            System.out.println("---------------------First Condition-------------------------");
            System.out.println("randTop : " + randTop + " | Buttom : " + Buttom);
            System.out.println("randLeft : " + randLeft + " | Right : " + Right);
            System.out.println("randFront : " + randFront + " | Back : " + Back);
            System.out.println("-------------------------------------------------------------");

        } else {
            while ((randTop == randLeft) || (randTop == randFront) || (randFront == randLeft) || (randTop == Back)
                    || (randTop == Right) || (randFront == Buttom) || (randFront == Right)
                    || (randLeft == Buttom) || (randLeft == Back)) {

                randTop = (int) (Math.random() * range) + min;
                if ((randTop != randLeft) && (randTop != randFront) && (randTop != Back) && (randTop != Right)) {
                    Top = randTop;
                    Buttom = 7 - Top;

                    randFront = (int) (Math.random() * range) + min;
                    if ((randFront != Top) && (randFront != Buttom) && (randFront != Buttom) && (randFront != Right)) {
                        Front = randFront;
                        Back = 7 - Front;

                        randLeft = (int) (Math.random() * range) + min;
                        if ((randLeft != Top) && (randLeft != Buttom) && (randLeft != Front) && (randLeft != Back)) {
                            Left = randLeft;
                            Right = 7 - randLeft;
                        }
                        final_Left = Left;
                        final_Right = Right;
                    }
                    final_Front = Front;
                    final_Back = Back;
                }
                final_Top = Top;
                final_Buttom = Buttom;
            }
            System.out.println("---------------------Second Condition------------------------");
            System.out.println("Top : " + final_Top + " | Buttom : " + final_Buttom);
            System.out.println("Front : " + final_Front + " | Back : " + final_Back);
            System.out.println("Left : " + final_Left + " | Right : " + final_Right);
            System.out.println("-------------------------------------------------------------");
        }
        SetSymbol();
    }

    public void Clockwise(){
        System.out.println("Clockwise");
        int newside = final_Right;
        this.final_Right = final_Top;
        this.final_Top = final_Left;
        this.final_Left = final_Buttom;
        this.final_Buttom = newside;
        SetSymbol();
    }

    public void Counterclockwise(){
        System.out.println("Counterclockwise");
        int newside = final_Left;
        this.final_Left = final_Top;
        this.final_Top = final_Right;
        this.final_Right = final_Buttom;
        this.final_Buttom = newside;
        SetSymbol();
    }

    public void RollLeft() {
        System.out.println("Left");
        int newside = final_Left;
        this.final_Left = final_Front;
        this.final_Front = final_Right;
        this.final_Right = final_Back;
        this.final_Back = newside;
        SetSymbol();
    }

    public void RollRight() {
        System.out.println("Right");
        int newside = final_Right;
        this.final_Right = final_Front;
        this.final_Front = final_Left;
        this.final_Left = final_Back;
        this.final_Back = newside;
        SetSymbol();
    }

    public void RollUp() {
        System.out.println("Up");
        int newside = final_Top;
        this.final_Top = final_Front;
        this.final_Front = final_Buttom;
        this.final_Buttom = final_Back;
        this.final_Back = newside;
        SetSymbol();
    }

    public void RollDown() {
        System.out.println("Down");
        int newside = final_Front;
        this.final_Front = final_Top;
        this.final_Top = final_Back;
        this.final_Back = final_Buttom;
        this.final_Buttom = newside;
        SetSymbol();
    }

    private void SetSymbol() {
        if (final_Front == 1) {
            DiceArray[1][1] = ".";
        } else if (final_Front == 2) {
            DiceArray[0][0] = ".";
            DiceArray[2][2] = ".";
        } else if (final_Front == 3) {
            DiceArray[0][0] = ".";
            DiceArray[1][1] = ".";
            DiceArray[2][2] = ".";
        } else if (final_Front == 4) {
            DiceArray[0][0] = ".";
            DiceArray[0][2] = ".";
            DiceArray[2][0] = ".";
            DiceArray[2][2] = ".";
        } else if (final_Front == 5) {
            DiceArray[0][0] = ".";
            DiceArray[0][2] = ".";
            DiceArray[1][1] = ".";
            DiceArray[2][0] = ".";
            DiceArray[2][2] = ".";
        } else if (final_Front == 6) {
            DiceArray[0][0] = ".";
            DiceArray[0][2] = ".";
            DiceArray[1][0] = ".";
            DiceArray[1][2] = ".";
            DiceArray[2][0] = ".";
            DiceArray[2][2] = ".";
        }

    }

}