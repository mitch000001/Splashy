package org.mitchwork.splashy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class Splash extends Activity {
	long m_dwSplashTime = 3000;
	boolean m_bPaused = false;
	boolean m_bSplashActive = true;
	
	protected void onPause() {
		super.onPause();
		m_bPaused = true;
	}
	
	protected void onResume() {
		super.onResume();
		m_bPaused = false;
	}
	
	protected void onStop() {
		super.onStop();
	}
	
	protected void onDestroy() {
		super.onDestroy();
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		super.onKeyDown(keyCode, event);
		switch (keyCode)
        {
        case KeyEvent.KEYCODE_BACK:
           finish();
           return true;
        case KeyEvent.KEYCODE_DPAD_CENTER:
           m_bSplashActive = false;
           return true;
        case KeyEvent.KEYCODE_ENTER:
           m_bSplashActive = false;
           return true;
        default:
           return true;
      }
	}
	
	/** Allgemeiner Abbruch vom Splash
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// if we get any key, clear the splash screen
		super.onKeyDown(keyCode, event);
		m_bSplashActive = false;
		return true;
	}
	*/
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
     // Draw the splash screen
        setContentView(R.layout.splash);
        // Very simple timer thread
        Thread splashTimer = new Thread() {
        	public void run() {
        		try {
        			// Wait loop
        			long ms = 0;
        			while(m_bSplashActive && ms < m_dwSplashTime) {
        				sleep(100);
        				// Advance the timer only if we're running.
        				if(!m_bPaused)
        					ms += 100;
        			}
        			// Advance to the next screen.
        			startActivity(new Intent("org.mitchwork.splashy.CLEARSPLASH"));
        		}
        		catch(Exception e)
        		{
        			Log.e("Splash", e.toString());
        		}
        		finally {
        			finish();
        		}
        	}
        };
        splashTimer.start();
    }
}