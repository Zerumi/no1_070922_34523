import java.util.concurrent.ThreadLocalRandom;

/* Лабораторная работа #1
 * (no1_070922_34523) от 07.09.2022, вариант #34523
 * Работу выполнил: Афанасьев Кирилл Александрович
 * Университет ИТМО, СУиР -- 24.03.02 СУДиН
 * ИТМО ВТ
 *
 * Скриншот задания (формулу) см. в корневой папке
 */
public class Program {
    public static void main (String[] args)
    {
        // step 1
        short[] c = new short[] {6,8,10,12,14,16,18,20,22};

        //step 2
        double[] x = new double[17];
        for (int i = 0; i < x.length; i++) {
            x[i] = ThreadLocalRandom.current().nextDouble(-4.0,6.0);
        }

        // step 3
        double[][] arr = new double[9][17];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                double X = x[j];
                double result;
                switch (c[i])
                {
                    case 12:
                    {
                        // a - числитель, b - знаменатель
                        double sa1 = (4-X)/X; // 1
                        double sa = Math.pow(X, sa1); // 2
                        double sb = (1.0 / 2.0) - Math.tan(X); // 3
                        double s = sa/sb; // 4
                        // степень основного числителя подсчитана
                        double a1 = Math.pow((2.0 / 3.0)*X,3); // 5
                        double a = Math.pow(a1, s); // 6
                        // основной числитель подсчитан

                        double b1a = Math.asin((((X + 1) / 1) * Math.E) + 1); // 7 // IDE: '(X + 1) / 1' can be replaced with '(X + 1)'
                        double b1b = 3 + b1a; // 8
                        // дробь в знаменателе подсчитана
                        double b1 = Math.pow(b1a / b1b,2); // 9
                        double b = 1 - b1; // 10
                        // основной знаменатель подсчитан

                        result = Math.pow(a / b,2); // 11
                        // результат для c[i] == 12 подсчитан (спойлер, там скорее всего везде NaN, см. вероятность)
                        break;
                    }
                    case 8:
                    case 18:
                    case 20:
                    case 22:
                        result = Math.sin(Math.cbrt(Math.sin(X)));
                        // результат для c[i] = {8, 18, 20, 22}
                        break;
                    default:
                    {
                        // аналогично case 12
                        double a = 3.0;
                        // числитель здесь постоянный
                        double bs1 = Math.atan((((X + 1) / 1) * Math.E) + 1); // IDE: '(X + 1) / 1' can be replaced with '(X + 1)'
                        double bs = Math.cbrt(bs1);
                        // степень экспоненты в знаменателе подсчитана
                        double b = Math.pow(Math.E, bs);
                        // основной знаменатель подсчитан

                        // считаем степень, в которую надо возвести дробь (s - искомое)
                        double s1 = Math.sin(Math.pow(X + 1.0 / 3.0, 3)) - 1;
                        double s = (s1 / 2) / 3;

                        result = Math.pow(a / b, s);
                        // результат для иных значений c[i]
                        break;
                    }
                }
                arr[i][j] = result;
            }
        }

        // step 4
        for (double[] doubles : arr) {
            for (double aDouble : doubles) {
                System.out.printf("%.4g  ", aDouble);
            }
            System.out.println();
        }
    }
}