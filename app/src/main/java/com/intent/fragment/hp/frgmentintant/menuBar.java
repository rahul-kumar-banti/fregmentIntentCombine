package com.intent.fragment.hp.frgmentintant;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class menuBar extends ListFragment {

listItemClicked actiivityclick;
    public menuBar() {
        // Required empty public constructor
    }

public interface listItemClicked{
void onlistclicked(int i);
}


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        actiivityclick=(listItemClicked)context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String menu[]=getResources().getStringArray(R.array.menu_item);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,menu));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    actiivityclick.onlistclicked(position);
    }
}
