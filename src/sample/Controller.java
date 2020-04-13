package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import sample.MathOperations;



import java.net.URL;
import java.util.ResourceBundle;


public  class Controller   {


    @FXML
    public   Button one;
    private Button zero;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button AC;
    private Button plusMinus;
    private Button procent;
    private Button split;
    private Button  multiplication;
    private Button  minus;
    private Button plus;
    private Button  comma;
    private Button  equals;
    @FXML
    private Label result;

    public MathOperations Ops= new MathOperations();

      public void initialize()
          {

          }


    // keyboard support
    @FXML
    private void handleKeyPressed(KeyEvent ke){
        System.out.println(ke.getCode());
        if( ke.getCode().toString().equals("NUMPAD0") || ke.getCode().toString().equals("DIGIT0"))
            ZeroButton();
        if( ke.getCode().toString().equals("NUMPAD1") || ke.getCode().toString().equals("DIGIT1"))
            OneButton();
        if( ke.getCode().toString().equals("NUMPAD2") || ke.getCode().toString().equals("DIGIT2"))
            TwoButton();
        if( ke.getCode().toString().equals("NUMPAD3") || ke.getCode().toString().equals("DIGIT3"))
            ThreeButton();
        if( ke.getCode().toString().equals("NUMPAD4") || ke.getCode().toString().equals("DIGIT4"))
            FourButton();
        if( ke.getCode().toString().equals("NUMPAD5") || ke.getCode().toString().equals("DIGIT5"))
            FiveButton();
        if( ke.getCode().toString().equals("NUMPAD6") || ke.getCode().toString().equals("DIGIT6"))
            SixButton();
        if( ke.getCode().toString().equals("NUMPAD7") || ke.getCode().toString().equals("DIGIT7"))
            SevenButton();
        if( ke.getCode().toString().equals("NUMPAD8") || ke.getCode().toString().equals("DIGIT8"))
            EightButton();
        if( ke.getCode().toString().equals("NUMPAD9") || ke.getCode().toString().equals("DIGIT9"))
            NineButton();
        if( ke.getCode().toString().equals("DIVIDE"))
            Split();
        if( ke.getCode().toString().equals("MULTIPLY"))
            Multiplication();
        if( ke.getCode().toString().equals("SUBTRACT"))
            Minus();
        if( ke.getCode().toString().equals("ADD"))
            Plus();
        if( ke.getCode().toString().equals("BACK_SPACE"))
            ACButton();
        if( ke.getCode().toString().equals("SEPARATOR"))
            CommaButton();
        if( ke.getCode().toString().equals("END"))
            EqualsFun();
        if( ke.getCode().toString().equals("HOME"))
            PlusMinus();
    }

    //anonymous classes (num buttons functionality)
    InsertButtonActions Digits=  (String symbol) ->
            {
                Ops.LabelClear(result);
                    String tmpLabel = result.getText();
                    if(!tmpLabel.equals("0") && tmpLabel.length()<14)
                        {
                            result.setText( tmpLabel + symbol);
                        }
                    else if (tmpLabel.length()<14)
                        {
                            result.setText(symbol);
                        }
            };

    InsertButtonActions Comma= (String symnol) ->
        {

              Ops.LabelClear(result);
              String tmpLabel = result.getText();
              boolean insert =true;
              for(int i =0; i<tmpLabel.length(); i++)
                    {
                        char  tmpchar= tmpLabel.charAt(i);
                        if(tmpchar==',')
                            insert=false ;
                    }
              if(insert)
                    {
                        if(tmpLabel.equals("0"))
                            result.setText("0.");
                        else
                        Digits.action(symnol);
                    }

        };

    // end of num buttons
    OtherButtonActions reset =()->
        {
            result.setText("0");
        };

    OtherButtonActions plusminus =()->
        {
            String tmp =result.getText();
            char tmpchar=tmp.charAt(0);
            if(!tmp.equals("0") && tmpchar!='-')
                  result.setText("-"+result.getText());  // else will be here in the future
        };


//symbol cases

   @FXML
   void ZeroButton()
   {
       Digits.action("0");
   }
   @FXML
    void OneButton()
   {
       Digits.action("1");
   }
    @FXML
    void TwoButton()
    {
        Digits.action("2");
    }
    @FXML
    void ThreeButton()
    {
        Digits.action("3");
    }
    @FXML
    void FourButton()
    {
        Digits.action("4");
    }
    @FXML
    void FiveButton()
    {
        Digits.action("5");
    }
    @FXML
    void SixButton()
    {
        Digits.action("6");
    }
    @FXML
    void SevenButton()
    {
        Digits.action("7");
    }
    @FXML
    void EightButton()
    {
        Digits.action("8");
    }
    @FXML
    void NineButton()
    {
        Digits.action("9");
    }

    @FXML
    void CommaButton()
    {
       Comma.action(".");
    }

    //function cases
    @FXML
    void ACButton()
    {
        reset.action();
    }
    @FXML
    void PlusMinus()
    {
        plusminus.action();
    }
    @FXML
    void Plus() {
       if(!result.getText().equals("0")) {
           Ops.setOperation("+", result.getText());
           reset.action();
       }
    }
    @FXML
    void Minus() {
        if(!result.getText().equals("0")) {
            Ops.setOperation("-", result.getText());
            reset.action();
        }
    }
    @FXML
    void Multiplication() {
        if(!result.getText().equals("0")) {
            Ops.setOperation("*", result.getText());
            reset.action();
        }
    }

    @FXML
    void Split() {
        if(!result.getText().equals("0")) {
            Ops.setOperation("/", result.getText());
            reset.action();
        }
    }

    @FXML
    void EqualsFun()
    {
        Ops.setSecondaryNumber(result.getText());
       result.setText( Ops.calculate());
    }

}



