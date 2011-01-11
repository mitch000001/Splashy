package org.mitchwork.splashy;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainMenu extends Activity {

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		super.onKeyDown(keyCode, event);
		switch (keyCode)
        {
        case KeyEvent.KEYCODE_BACK:
           finish();
           return true;
        default:
           return true;
      }
	}
		
	@Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
    }
}
