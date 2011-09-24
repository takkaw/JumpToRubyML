package net.takkaw.jump_to_ruby_ml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class JumpToRubyMLActivity extends Activity {
	final String  url_base = "http://blade.nagaokaut.ac.jp/cgi-bin/scat.rb/ruby/ruby-";
	final String[] ml = {"list","dev","ext","math","talk","core"};
		
	@Override
	protected void onStart(){
		super.onStart();
		String tweet = getIntent().getStringExtra(Intent.EXTRA_TEXT);
		Matcher m;
		for(int i = 0; i < 6 ; i++ ){
			m = Pattern.compile("ruby-" + ml[i] + ":(\\d+)").matcher(tweet);
			if(m.find()){
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url_base + ml[i] + "/" + m.group(1))));
				finish();
				return;
			}
		}

		Toast.makeText(this, "ML pattern not found.", Toast.LENGTH_SHORT).show();
		finish();

		return;
	}
    
}