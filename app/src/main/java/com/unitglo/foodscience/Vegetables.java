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


public class Vegetables extends Fragment {
	ViewPager viewPager;
	MyPagerAdapter myPagerAdapter;
	public static final String[] titles = new String[] { "Artichoke",
			"Arugula", "Asparagus", "Basil", "Beans", "Beetroot", "Bok Choy",
			"Broccoli", "Broccoli Raab", "Cabbage", "Carrot", "Cauliflower",
			"Celery", "Chile peppers", "Chives", "Collards green", "Corn",
			"Cucumber", "Dill", "Egg Plant", "Peas", "Escarole", "Sorrel",
			"Garlic", "Kale", "Kohlrabi", "Leeks", "Lettuce", "Okra", "Onion",
			"Parsnip", "Peppers", "Potatoes", "Pumpkin", "Radicchio", "Radish",
			"Rhubarb", "Rutabaga", "Spinach", "Butternut Squash",
			"Sweet Potato", "Tomatoes", "Turnips", "Cardamom", "Coriander",
			"Ginger", "Cinnamon", "Tamarind", "Mint", "Saffron" };
	public static final String[] descriptions = new String[] {
			"Cynara scolymus", "Eruca sativa", "Asparagus officinalis",
			"Ocimum basilicum", "Phaseolus vulgaris", "Beta vulgaris",
			"Brassica rapa", "Brassica oleracea var. italica", "Brassica ruvo",
			"Brassica oleracea var. capitata", "Daucus carota subsp. sativus",
			"Brassica oleracea var. botrytis", "Apium graveolens var. dulce",
			"Capsicum annum", "Allium schoenoprasum",
			"Brassica Oleracea Hardiness", "Zea mays", "Cucumis sativus",
			"Anethum graveolens", "Solanum melongena", "Pisum sativum",
			"Cichorium endivia", "Rumex scutatus", "Allium sativum",
			"Brassica oleracea var. sabellica",
			"Brassica oleracea var. gongylodes", "Allium porrum",
			"Lactuca sativa", "Abelmoschus esculentus", "Allium cepa",
			"Pastinaca sativa", "Capsicum", "Solanum tuberosum",
			"Cucurbita spp.", "Cichorium intybus var. foliosum",
			"Raphanus sativus", "Rheum rhabarbarum", "Brassica napobrassica",
			"Spinacia oleracea", "Cucurbita moschata", "Ipomoea batatas",
			"Solanum lycopersicum", "Brassica rapa rapa",
			"Elettaria cardamomum", "Coriandrum sativum",
			"Zingiber officinale", "Cinnamomum verum J.S. Presl",
			"Tamarindus indica", "Mentha", "Crocus Sativus" };
	public static final String[] info = new String[] { "Artichoke", "Arugula",
			"Asparagus", "Basil", "Beans", "Beetroot", "Bok Choy", "Broccoli",
			"Broccoli Raab", "Cabbage", "Carrot", "Cauliflower", "Celery",
			"Chile peppers", "Chives", "Collards", "Corn", "Cucumber", "Dill",
			"Egg Plant", "Peas", "Escarole", "Sorrel", "Garlic", "Kale",
			"Kohlrabi", "Leeks", "Lettuce", "Okra", "Onion", "Parsnip",
			"Peppers", "Potatoes", "Pumpkin", "Radicchio", "Radish", "Rhubarb",
			"Rutabaga", "Spinach", "Butternut Squash", "Sweet Potato",
			"Tomatoes", "Turnips", "Cardamom", "Coriander", "Ginger",
			"Cinnamon", "Tamarind", "Mint", "Saffron" };
	public static final Integer[] images = { R.drawable.artichoke,
			R.drawable.arugula, R.drawable.asparagus, R.drawable.basil,
			R.drawable.beans, R.drawable.beets, R.drawable.bok_choy,
			R.drawable.broccoli, R.drawable.broccoli_raab, R.drawable.cabbage,
			R.drawable.carrot, R.drawable.cauliflower, R.drawable.celery,
			R.drawable.chile_peppers, R.drawable.chives, R.drawable.collards,
			R.drawable.corn, R.drawable.cucumber, R.drawable.dill,
			R.drawable.egg_plant, R.drawable.english_peas, R.drawable.escarole,
			R.drawable.french_sorrel, R.drawable.garlic, R.drawable.kale,
			R.drawable.kohlrabi, R.drawable.leeks, R.drawable.lettuce,
			R.drawable.ocra, R.drawable.onions, R.drawable.parsnip,
			R.drawable.peppers, R.drawable.potatoes, R.drawable.pumpkin,
			R.drawable.radicchio, R.drawable.radish, R.drawable.rhubarb,
			R.drawable.rutabaga, R.drawable.spinach, R.drawable.winter_squash,
			R.drawable.sweet_potato, R.drawable.tomatoes, R.drawable.turnips,
			R.drawable.cardamom, R.drawable.coriander, R.drawable.ginger,
			R.drawable.cinnamon, R.drawable.tamarind, R.drawable.mint,
			R.drawable.saffron };
	ListView listView;
	List<RowItem> rowItems;

	@Override
	public View onCreateView(final LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		View logo = inflater.inflate(R.layout.vegetables, container, false);
		((TextView) logo.findViewById(R.id.textView)).setText("Vegetables");
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
						StaticLists.baseVegetablesArrayList);
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