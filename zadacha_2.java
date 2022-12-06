//2.Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.


import java.util.logging.*;

public class zadacha_2 {
    public static void logger(int[] arr) {
        Logger logger_n = Logger.getLogger(zadacha_2.class.getName());
        ConsoleHandler ch = new ConsoleHandler();
        logger_n.addHandler(ch);

        SimpleFormatter sFormat = new SimpleFormatter();
        ch.setFormatter(sFormat);

        StringBuilder msg_arr = new StringBuilder();
        for (int i : arr) {
            msg_arr.append(i).append(" ");
        }

        logger_n.info(String.valueOf(msg_arr));
    }


    public static void main (String[]args){
        int[] array = new int[]{2, 4, 56, 3, 8, 78, 65};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    logger(array);
                }
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}
