package com.example.therese.pfi3_theresebrandstrom_a4;


import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.R

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentList extends Fragment {
    public static ArrayList<Planets> planets = new ArrayList<Planets>();

    //This method comes first so lets create the books here
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        planets.clear();
        Drawable d = getResources().getDrawable(R.drawable.img1);
        planets.add(new Planets("In the process","44535345",d));
        d = getResources().getDrawable(R.drawable.img2);
        planets.add(new Planets("In the doing","44535346",d));
        d = getResources().getDrawable(R.drawable.img3);
        planets.add(new Planets ("In the adding","44535348",d));
        d = getResources().getDrawable(R.drawable.img4);
        planets.add(new Planets("In the moving","44535349",d));
        d = getResources().getDrawable(R.drawable.img5);
        planets.add(new Planets("In the storing","44535350",d));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2, container, false);
        Log.i("FragmentWithList","NumberOfPlanets: " + planets.size());
        MyListAdapter la = new MyListAdapter(getActivity(),planets);
        ListView lv = (ListView) v.findViewById(R.id.listView);
        lv.setAdapter(la);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("FragmentWithList", "Clicked on position: " + position);
                FragmentManager fm = getFragmentManager();
                FragmentDialog fd = new FragmentDialog();
                Bundle b = new Bundle();
                b.putSerializable("book",planets.get(position));
                fd.setArguments(b);
                fd.show(fm,"Dialog");
            }
        });
        return v;
    }


}
