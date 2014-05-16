package fr.vincenti.jm.fviewflipper_gallery;

import java.util.ArrayList;
import java.util.List;

import fr.vincenti.jm.viewflipper_gallery.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	FlipperGallery gallery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gallery = new FlipperGallery(this,
				(ViewFlipper) findViewById(R.id.viewflipper), generateData());
	}

	private List<Item> generateData() {
		List<Item> result = new ArrayList<Item>();
		for (int i = 0; i < 22; i++) {
			result.add(new Item(false, "Text" + String.valueOf(i), i));
		}
		return result;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
