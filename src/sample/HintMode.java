package sample;

import java.util.*;

import static sample.Main.hint;

public class HintMode {

    private ArrayList<String> hints = new ArrayList<>();
    //private Panel1 panel1;
    private ArrayList<Object> activated = new ArrayList<>();

    public boolean isActivated(Object o){
        return activated.contains(o);
    }

    public void setActivated(Object o){
        activated.add(o);
    }

    public void getHint(Object o){
        if(!hints.isEmpty() && !activated.contains(o) ) {
            activated.add(o);
            Panel1.hint.setText(hints.get(0));
            hints.remove(0);
        }
    }

    HintMode(boolean on){
        if (on){
            hints.add("Включите пульт на ПТСП и проверьте контроль ламп");
            hints.add("Включите питание управления И проверьте контроль сигнала ламп");
            hints.add("Откройте люки и переведите контр напр в ГАП");
            hints.add("Проведите холодную прокрутку");
            hints.add("Запустите гап. Убедитесь, что все показатели в норме");
            hints.add("Нажмите кнопку ГАП");
            hints.add("Конец");
        }
        else{
            hints.add("Отключите нагревание(нижняя красная кнопка)");
            hints.add("Нажмите Стоп ГАП");
            hints.add("Закройте люки");
            hints.add("Выключите питание управления");
            hints.add("Конец");
        }
    }


}
