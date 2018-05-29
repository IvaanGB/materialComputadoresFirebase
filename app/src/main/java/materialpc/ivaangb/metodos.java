package materialpc.ivaangb;


import android.content.res.Resources;
import android.graphics.Color;

import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by ivang on 29/5/2018.
 */

public class metodos {
    private static Computador computador;


    public static TextView errorSpinner(Spinner spinner, String error) {
        TextView errorText = (TextView) spinner.getSelectedView();
        errorText.setError("");
        errorText.setTextColor(Color.RED);
        errorText.setText(error);
        return errorText;
    }

    public static boolean validarSpinner(Spinner spinner, String error){
        if (spinner.getSelectedItemPosition() == 0) {
            spinner.requestFocus();
            errorSpinner(spinner, error);
            return false;
        }
        return true;
    }


}
