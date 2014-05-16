package fr.vincenti.jm.fviewflipper_gallery;

import java.util.List;

import fr.vincenti.jm.viewflipper_gallery.R;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class FlipperGallery {
	private ViewFlipper vf;
	private float fromXPosition;
	private Context context;
	private int count;
	private GalleryAdapter adapter;
	private List<Item> items;

	public FlipperGallery(Context context, ViewFlipper vf, List<Item> items) {
		this.items = items;
		adapter = new GalleryAdapter(context, items);
		this.vf = vf;
		this.context = context;
		count = 0;
		vf.addView(adapter.getView(count, null, null));
		initOnTouch();
	}

	private void initOnTouch() {
		this.vf.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					fromXPosition = event.getX();
					break;
				case MotionEvent.ACTION_UP:
					float toPosition = event.getX();
					if (fromXPosition > toPosition + Constants.TOUCH_MOVING) {
						next();
						return true;
					} else if (fromXPosition < toPosition
							- Constants.TOUCH_MOVING) {
						previous();
						return true;
					}
				default:
					break;
				}
				return true;
			}
		});
	}

	protected void previous() {
		if (count > 0) {
			count--;
			this.vf.setInAnimation(AnimationUtils.loadAnimation(context,
					R.anim.in_from_left));
			this.vf.setOutAnimation(AnimationUtils.loadAnimation(context,
					R.anim.out_to_right));
			vf.addView(adapter.getView(count, null, null), 0);
			vf.showPrevious();
			vf.removeViewAt(vf.getChildCount() - 1);
		}

	}

	protected void next() {
		if (count < items.size() - 1) {
			count++;
			this.vf.setInAnimation(AnimationUtils.loadAnimation(context,
					R.anim.in_from_right));
			this.vf.setOutAnimation(AnimationUtils.loadAnimation(context,
					R.anim.out_to_left));
			vf.addView(adapter.getView(count, null, null));
			vf.showNext();
			vf.removeViewAt(0);
		}
	}
}
