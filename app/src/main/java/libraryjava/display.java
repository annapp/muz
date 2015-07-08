package libraryjava;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;

/**
 * Created by Professor on 08.07.2015.
 */
public class display{

    Activity activity = new Activity();

    private Boolean getScreenOrientation(){
        if(activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return true;
        else if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return false;
        else
            return true;
    }
}
