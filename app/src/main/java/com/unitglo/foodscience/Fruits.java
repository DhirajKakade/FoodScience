package com.unitglo.foodscience;
import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


public class Fruits extends Fragment {
	ViewPager viewPager;
	MyPagerAdapter myPagerAdapter;
	public static final String[] titles = new String[] { "Apple", "Apricot",
			"Avocado", "Banana", "Cherry", "Chiku", "Clementine", "Coconut",
			"Cuatard Apple", "Date", "Elderberry", "Fig", "Grapes", "Guava",
			"Lemon", "Kiwi", "Mango", "Orange", "Pear", "Pineapple", "Quince",
			"Strawberry",  "Papaya", "Peach",
			"Plum", "Pomegranate", "Jamun", "Watermelon" };
	public static final String[] descriptions = new String[] { "Malus pumila",
			"Prunus armeniaca", "Persea americana", "Musa � paradisiaca",
			"Prunus serrulata.", "Manilkara zapota", "Citrus � clementina",
			"Cocos nucifera", "Annona reticulata", "Phoenix dactylifera",
			"Sambucus", "Ficus carica", "Vitis", "Psidium guajava", "Apteryx",
			"Citrus � limon", "Mangifera indica", "Citrus � sinensis", "Pyrus",
			"Ananas comosus", "Cydonia oblonga", "Fragaria ananassa",
			 "Carica papaya", "Prunus persica",
			"Prunus domestica", "Punica granatum", "Syzygium cumini",
			"Citrullus lanatus" };
	public static final String[] info = new String[] { "Apple", "Apricot",
			"Avocado", "Banana", "Cherry", "Chiku", "Clementine", "Coconut",
			"Cuatard Apple", "Date", "Elderberry", "Fig", "Grapes", "Guava",
			"Lemon", "Kiwi", "Mango", "Orange", "Pear", "Pineapple", "Quince",
			"Strawberry",  "Papaya", "Peach",
			"Plum", "Pomegranate", "Jamun", "Watermelon" };
	// pictures
	public static final Integer[] images = { R.drawable.apple,
			R.drawable.apricot, R.drawable.avocado, R.drawable.banana,
			R.drawable.cherry, R.drawable.chiku, R.drawable.clementine,
			R.drawable.coconut, R.drawable.cuatard_apple, R.drawable.date,
			R.drawable.elderberry, R.drawable.fig, R.drawable.grapes,
			R.drawable.guava, R.drawable.lemon, R.drawable.kiwi,
			R.drawable.mango, R.drawable.orange, R.drawable.pear,
			R.drawable.pineapple, R.drawable.quince, R.drawable.strawberry,
			
			R.drawable.papaya, R.drawable.peach, R.drawable.victoria_plum,R.drawable.pomegranate,R.drawable.jamun,
			R.drawable.watermelon };
	ListView listView;
	List<RowItem> rowItems;

	@Override
	public View onCreateView(final LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		View logo = inflater.inflate(R.layout.fruits, container, false);
		((TextView) logo.findViewById(R.id.textView)).setText("Fruits");
		rowItems = new ArrayList<RowItem>();
		for (int i = 0; i < titles.length; i++) {
			RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
			rowItems.add(item);
		}
		listView = (ListView) logo.findViewById(R.id.list);
		CustomList adapter = new CustomList(getActivity(), rowItems);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				View myCustomView = inflater.inflate(R.layout.info, null);
				viewPager = (ViewPager) myCustomView
						.findViewById(R.id.myviewpager);
				myPagerAdapter = new MyPagerAdapter(getActivity(), arg2,
						StaticLists.baseFruitsaArrayList);
				viewPager.setAdapter(myPagerAdapter);
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(
						getActivity());
				alertDialog.setView(myCustomView);
				ImageView img = (ImageView) myCustomView
						.findViewById(R.id.imageView1);
				img.setImageResource(rowItems.get(arg2).getImageId());
				TextView editText = (TextView) myCustomView
						.findViewById(R.id.textView1);
				editText.setText(info[arg2]);

				alertDialog.setPositiveButton("Close",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.cancel();

							}
						});
				alertDialog.show();
			}
		});
		return logo;

	}

	ViewPager Tab;
	TabPagerAdapter TabAdapter;
	ActionBar actionBar;
}