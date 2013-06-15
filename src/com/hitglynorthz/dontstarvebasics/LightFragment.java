package com.hitglynorthz.dontstarvebasics;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LightFragment extends ListFragment{
	
	// Array de String que contiene nuestros queridos Sistemas Operativos
    private String[] light = { "Fire Pit", "Campfire", "Torch", "Miner Hat",
            "Pumpkin Lantern", "Night Light", "Lantern" };
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.light, container, false);
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
 
        // Establecemos el Adapter a la Lista del Fragment
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.item_list, light));
    }
 
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        //Toast.makeText(getActivity(), "Ha pulsado " + tools[position], Toast.LENGTH_SHORT).show();
        //ListView lv = getListView();
        Intent i = new Intent(getActivity(), SingleListItem.class);
        i.putExtra("title", light[position]);
        startActivity(i);
    }
}

