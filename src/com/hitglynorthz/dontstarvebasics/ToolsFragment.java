package com.hitglynorthz.dontstarvebasics;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ToolsFragment extends ListFragment{
	
	// Array de String que contiene nuestros queridos
    private String[] tools = { "Axe", "Pickaxe", "Shovel", "Pitchfork",
            "Hammer", "Razor", "Luxury Axe", "Regal Shovel",
            "Opulent Pickaxe" };
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.tools, container, false);
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
 
        // Establecemos el Adapter a la Lista del Fragment
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.item_list, tools));
    }
 
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
 
        // Mostramos un mensaje con el elemento pulsado
        //Toast.makeText(getActivity(), "Ha pulsado " + tools[position], Toast.LENGTH_SHORT).show();
        ListView lv = getListView();
        
        // listening to single list item on click
        l.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               
              // Launching new Activity on selecting single List Item
              Intent i = new Intent(getActivity(), SingleListItem.class);
              // sending data to new activity
              i.putExtra("title", tools[position]);
              startActivity(i);
             
          }
        });
    }
}
