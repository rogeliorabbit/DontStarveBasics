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
    private String[] tools = { "Axe", "Pickaxe", "Shovel", "Pitchfork",
            "Hammer", "Razor", "Luxury Axe", "Regal Shovel",
            "Opulent Pickaxe" };
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tools, container, false);
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.item_list, tools));
    }
 
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        //Toast.makeText(getActivity(), "Ha pulsado " + tools[position], Toast.LENGTH_SHORT).show();
        ListView lv = getListView();
        l.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               
              Intent i = new Intent(getActivity(), SingleListItem.class);
              i.putExtra("title", tools[position]);
              startActivity(i);
             
          }
        });
    }
}
