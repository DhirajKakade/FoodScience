package com.unitglo.foodscience;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class MyPagerAdapter extends PagerAdapter {

	int NumberOfPages = 3;
	Activity activity;
	int PositionOfListItem = 0;
	public ArrayList<BaseFruits> templist;

	public MyPagerAdapter(Activity activity, int PositionOfListItem,
			ArrayList<BaseFruits> temp) {
		this.activity = activity;
		this.PositionOfListItem = PositionOfListItem;
		templist = temp;
	}

	@Override
	public int getCount() {
		return NumberOfPages;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		ScrollView scrollView = new ScrollView(activity);
		TableLayout tableLayout = new TableLayout(activity);
		LinearLayout linearLay = new LinearLayout(activity);
		tableLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		if (position == 0) {
			TextView textViewtmp = new TextView(activity);
			textViewtmp.setTextColor(Color.DKGRAY);
			textViewtmp.setTextSize(14);
			textViewtmp.setTypeface(Typeface.DEFAULT_BOLD);
			textViewtmp.setText("Amount Per 100 grams");
			textViewtmp.requestLayout();
			textViewtmp.setGravity(Gravity.RIGHT);

			TableRow tableRow1 = new TableRow(activity);
			tableRow1.addView(textViewtmp);
			tableLayout.addView(tableRow1);

			for (int i = 0; templist.get(PositionOfListItem)
					.getNutritionFactsLeft().length > i; i++) {

				TextView textView2 = new TextView(activity);
				textView2.setTextColor(Color.DKGRAY);
				textView2.setTextSize(16);
				textView2.setText(""
						+ templist.get(PositionOfListItem)
								.getNutritionFactsLeft()[i]);
				textView2.setTypeface(Typeface.DEFAULT_BOLD);
				TextView textViews = new TextView(activity);
				textViews.setTextColor(Color.DKGRAY);
				textViews.setTextSize(14);

				textViews.setText(""
						+ templist.get(PositionOfListItem)
								.getNutritionFactsRight()[i]);
				// textViews.setPadding(-10, 0, 10, 0);
				textViews.setTypeface(Typeface.SANS_SERIF);
				TableRow tableRow = new TableRow(activity);
				tableRow.addView(textView2);
				tableRow.addView(textViews);
				tableLayout.addView(tableRow);
				tableLayout.requestLayout();
			}

			linearLay.addView(tableLayout);
			linearLay.setGravity(Gravity.CENTER_HORIZONTAL);

		} else if (position == 1) {

			for (int i = 0; i < templist.get(

			PositionOfListItem).getVarieties().length; i++) {
				TextView textView1 = new TextView(activity);
				textView1.setTextColor(Color.DKGRAY);
				textView1.setTextSize(16);
				textView1.setTypeface(Typeface.DEFAULT_BOLD);
				textView1.setText(""
						+ templist.get(PositionOfListItem).getVarieties()[i]);
				textView1.setGravity(Gravity.CENTER_HORIZONTAL);

				TableRow tableRow = new TableRow(activity);
				tableRow.addView(textView1);

				tableLayout.addView(tableRow);
			}

			linearLay.addView(tableLayout);
			linearLay.setGravity(Gravity.CENTER_HORIZONTAL);
		} else if (position == 2) {
			for (int i = 0; i < templist.get(PositionOfListItem)
					.getHealthBenefits().length; i++) {
				TextView textView1 = new TextView(activity);
				textView1.setTextColor(Color.DKGRAY);
				textView1.setTextSize(16);
				textView1.setTypeface(Typeface.DEFAULT_BOLD);
				textView1
						.setText(""
								+ templist.get(PositionOfListItem)
										.getHealthBenefits()[i]);
				textView1.setGravity(Gravity.CENTER_HORIZONTAL);
				TableRow tableRow = new TableRow(activity);
				tableRow.addView(textView1);

				tableLayout.addView(tableRow);
			}
			linearLay.addView(tableLayout);
			linearLay.setGravity(Gravity.CENTER_HORIZONTAL);
		}
		scrollView.addView(linearLay, new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

		container.addView(scrollView);

		return scrollView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((ScrollView) object);
	}

	@Override
	public CharSequence getPageTitle(int position) {

		return templist.get(PositionOfListItem).getTitle()[position];
	}

}
