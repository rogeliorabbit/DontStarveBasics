package com.hitglynorthz.dontstarvebasics;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NewsFragment extends ListFragment{
	
	// Array de String que contiene nuestros queridos Sistemas Operativos
    private String[] news = { "New Item 1", "New Item 2", "New Item 3", "New Item 4", "New Item 5", "New ITem 6", "New Item 7", "New Item 8", "New Item 9", "New Item 10" };
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.news, container, false);
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
 
        // Establecemos el Adapter a la Lista del Fragment
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.item_list, news));
    }
 
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
 
        // Mostramos un mensaje con el elemento pulsado
        Toast.makeText(getActivity(), "Ha pulsado " + news[position], Toast.LENGTH_SHORT).show();
    }
}
