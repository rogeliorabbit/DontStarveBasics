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

public class MagicFragment extends ListFragment{
    private String[] magic = { "Meat Effigy", "Pan Flute", "Ice Staff", "Amulet", "One-man Band", "Night Light", "Dark Sword", "Night Armour", "Fire Staff", "Bat Bat" };
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.magic, container, false);
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.item_list, magic));
    }
 
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        //Toast.makeText(getActivity(), "Ha pulsado " + tools[position], Toast.LENGTH_SHORT).show();
        //ListView lv = getListView();
        Intent i = new Intent(getActivity(), SingleListItem.class);
        i.putExtra("title", magic[position]);
        startActivity(i);
    }
}
