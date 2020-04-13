package sample;

import javafx.scene.control.Label;

public class MathOperations
{
    private boolean labelReset = false;
    private String operation;
    private String PrimaryNumber;
    private String SecondatyNumber;

        void  setOperation(String operation, String PrimaryNumber)
            {
                this.operation=operation;
                this.PrimaryNumber=PrimaryNumber;
            }


        void setSecondaryNumber(String SecondaryNumber)
        {
            this.SecondatyNumber=SecondaryNumber;
        }

        public String calculate()
             {
                 Double first = Double.valueOf(PrimaryNumber);
                 Double secound = Double.valueOf(SecondatyNumber);
                double tmpd=0;
                String tmps="";
                int tmpi=0;

                switch (operation)
                 {
                     case "+":
                          tmpd = first + secound;
                          break;
                     case "-":
                         tmpd = first - secound;
                         break;
                     case "/":
                         tmpd = first / secound;
                         break;
                     case "*":
                         tmpd = first * secound;
                         break;
                 }
                 if((int)tmpd==tmpd)
                     {
                         tmpi=(int)tmpd;
                         tmps = Integer.toString(tmpi);
                     }
                 else
                     tmps = Double.toString(tmpd);

                 labelReset = true;
                 return tmps;
        }

        void LabelClear(Label inter)
                {
                    if(labelReset)
                        {
                            inter.setText("0");
                            labelReset=false;
                        }
                }
}
