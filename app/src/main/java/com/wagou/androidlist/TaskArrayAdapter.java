package com.wagou.androidlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class TaskArrayAdapter extends ArrayAdapter<Task> {
    private final Context context;
    private ArrayList<Task> taskList;

    public TaskArrayAdapter(Context c, int resource, ArrayList<Task> l) {
        super(c, resource, l);
        context = c;
        taskList = l;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_view_item, parent, false);
        }

        TextView viewLibelle = convertView.findViewById(R.id.libelle);
        viewLibelle.setText(taskList.get(position).getLibelle());

        ImageView viewStatut = convertView.findViewById(R.id.statut);
        viewStatut.setImageResource(taskList.get(position).getImageDrawable());

        TextView viewPriorite = convertView.findViewById(R.id.priorite);
        viewPriorite.setText(taskList.get(position).getPriorite());

        TextView viewDate = convertView.findViewById(R.id.date);
        viewDate.setText(taskList.get(position).getDate());

        return convertView;
    }
}
