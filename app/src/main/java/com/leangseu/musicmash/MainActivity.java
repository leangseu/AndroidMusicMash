package com.leangseu.musicmash;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager mViewPager;
        SectionsPagerAdapter mSectionsPagerAdapter;

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            GridView gridView = rootView.findViewById(R.id.grid_layout);
            gridView.setNumColumns(2);

            ArrayList<Song> songs = new ArrayList<>();
            Resources res = getResources();

            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    for (int i = 1; i < 7; i++) {
                        String cad = "gym_song_" + i;
                        songs.add(new Song(res.getStringArray(
                                res.getIdentifier(cad, "array", getContext().getPackageName())
                        )));
                    }
                    break;
                case 2:
                    for (int i = 1; i < 7; i++) {
                        String cad = "study_song_" + i;
                        songs.add(new Song(res.getStringArray(
                                res.getIdentifier(cad, "array", getContext().getPackageName())
                        )));
                    }
                    break;
                case 3:
                    for (int i = 1; i < 7; i++) {
                        String cad = "relax_song_" + i;
                        songs.add(new Song(res.getStringArray(
                                res.getIdentifier(cad, "array", getContext().getPackageName())
                        )));
                    }
                    break;
                default:
                    break;
            }

            SongAdapter adapter = new SongAdapter(getContext(), R.layout.song_layout, songs);
            gridView.setAdapter(adapter);


            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final int COUNT = 4;
        private String[] categories = new String[COUNT];

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            categories = getResources().getStringArray(R.array.categories);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return categories[position];
        }
    }
}
