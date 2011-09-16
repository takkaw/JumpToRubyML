package net.takkaw.jump_ruby_ml;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

public class JumpRubyMLActivity extends Activity {

	/** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//    	Log.v("test",getTweet());
//    }
	@Override
	public void onStart(){
		super.onStart();
		Toast.makeText(this, getTweet(), Toast.LENGTH_SHORT).show();
	}
    
	private String getTweet(){
		Intent i = getIntent();
		String tweet = i.getStringExtra(Intent.EXTRA_TEXT);
		return tweet;
	}
}