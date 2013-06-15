package com.hitglynorthz.dontstarvebasics;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class StructFragment extends ListFragment{
    private String[] struct = { "Chest", "Sign", "Hay Wall", "Wood Wall", "Stone Wall", "Pig House", "Rabbit Hutch", "Birdcage", "Cobblestones", "Wooden Flooring", "Checkerboard Flooring", "Carpeted Flooring" };
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.structures, container, false);
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.item_list, struct));
    }
 
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        //Toast.makeText(getActivity(), "Ha pulsado " + tools[position], Toast.LENGTH_SHORT).show();
        //ListView lv = getListView();
        Intent i = new Intent(getActivity(), SingleListItem.class);
        i.putExtra("title", struct[position]);
        startActivity(i);
    }
}
