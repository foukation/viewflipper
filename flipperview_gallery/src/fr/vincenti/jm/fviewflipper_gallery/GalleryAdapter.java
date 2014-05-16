package fr.vincenti.jm.fviewflipper_gallery;

import java.util.List;

import fr.vincenti.jm.viewflipper_gallery.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GalleryAdapter extends BaseAdapter {
	private List<Item> items;
	private LayoutInflater layoutInflater = null;

	public GalleryAdapter(Context context, List<Item> items) {
		this.items = items;
		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return items.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = (View) layoutInflater.inflate(R.layout.gallery_item, null);
		TextView txt = ((TextView) view.findViewById(R.id.textView));
		if (items.get(position).isClicked()) {
			txt.setText(items.get(position).getValue() + " clicked");
			txt.setClickable(false);
			txt.setTag(items.get(position).getId());
		} else {
			txt.setText(items.get(position).getValue());
			txt.setTag(items.get(position).getId());
			txt.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Item item = items.get(items.indexOf(new Item((Integer) v.getTag())));
					item.setClicked(true);
					((TextView) v).setText(item.getValue() + " clicked");
					v.setClickable(false);
				}
			});

		}

		return view;
	}
}
