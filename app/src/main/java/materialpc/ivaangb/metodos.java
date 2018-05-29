package materialpc.ivaangb;


import android.graphics.Color;

import android.widget.Spinner;
import android.widget.TextView;


/**
 * Created by ivang on 29/5/2018.
 */

public class metodos {

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
