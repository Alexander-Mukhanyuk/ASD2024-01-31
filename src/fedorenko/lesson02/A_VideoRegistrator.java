package fedorenko.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Даны события events
реализуйте метод calcStartTimes, так, чтобы число включений регистратора на
заданный период времени (1) было минимальным, а все события events
были зарегистрированы.
Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class A_VideoRegistrator {

    public static void main(String[] args) {
        A_VideoRegistrator instance=new A_VideoRegistrator();
        double[] events=new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
        List<Double> starts=instance.calcStartTimes(events,1); //рассчитаем моменты старта, с длинной сеанса 1
        System.out.println(starts);                            //покажем моменты старта
    }
    //модификаторы доступа опущены для возможности тестирования
    List<Double> calcStartTimes(double[] events, double workDuration){
       Arrays.sort(events); //сортировка массива events
        List<Double> result;
        result = new ArrayList<>();
        int i=0;                              //i - это индекс события events[i]
       while(i<events.length){
           double start=events[i]; //получение первого незаргестр события
           result.add(start); //старт регистратора
           double end=start+workDuration; //конец работы регистратора
           //пропуск всех зарегистрированных событий во время работы регистратора
           while(i<events.length && events[i]<=end){
               i++;
           }
       }
        return result;                        //вернем итог
    }
}
