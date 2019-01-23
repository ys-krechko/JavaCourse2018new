package homework;

/*
Студент должен сдать экзамен в определенное время (в 9:30).
Он приходит в комнату экзамена в определенное время (например, 9:40).
Считается, что студент пришел вовремя, если он прибыл на экзамен за полчаса до экзамена или вовремя.
Если он приехал более чем на 30 минут раньше, он пришел зарано. Если он пришел после начала экзамена, он опоздал.
*/

public class Task02_3 {
    public static void main(String[] args) {
        int hstart=9;
        int mstart=00;
        int harrival=9;
        int marrival=00;
        if (hstart==harrival&&mstart==marrival)
        {
            System.out.println("Ученик пришёл вовремя");
        }
        else if (hstart>harrival||mstart>marrival)
        {
            int ns=((hstart*60)+mstart);
            int na=((harrival*60)+marrival);
            int ndif=Math.abs(ns-na);
            if (ndif>=60)
                {int minearly=ndif%60;
                int hourearly=ndif/60;
                System.out.println("Ученик пришел заранее на "+hourearly+" часов "+minearly+" минут.");}
            else
                {
                System.out.println("Ученик пришел заранее на "+"0 часов "+ndif+" минут.");
                }
        }
        else if (hstart<harrival||mstart<marrival)
        {
            int ns=((hstart*60)+mstart);
            int na=((harrival*60)+marrival);
            int ndif=Math.abs(na-ns);
            if (ndif>=60)
                {int minlate=ndif%60;
                 int hourlate=ndif/60;
                 System.out.println("Ученик опоздал на "+hourlate+" часов "+minlate+" минут.");}
            else
                {
                System.out.println("Ученик опоздал на "+"0 часов "+ndif+" минут.");}
                }
    }
}
