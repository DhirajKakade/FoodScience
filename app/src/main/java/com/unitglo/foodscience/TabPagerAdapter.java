package com.unitglo.foodscience;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
	public TabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		switch (i) {

		case 0:
			return new Fruits();
		case 1:
			return new Vegetables();

		}
		return null;
	}

	@Override
	public int getCount() {
		return 2;
	}
}
