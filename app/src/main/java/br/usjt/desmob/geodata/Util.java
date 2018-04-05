package br.usjt.desmob.geodata;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

/*
    Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class Util {
    public static Drawable getDrawable(Context context, String name){

        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getDeclaredField(name);
            int id = idField.getInt(idField);
            return context.getResources().getDrawable(id, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
