package com.example.retrofit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;


import com.example.retrofit.Models.Bilgi;
import com.example.retrofit.R;

import java.util.List;

public class bilgiadapter extends BaseAdapter {

    List<Bilgi> bilgiList;
    Context context;

    public bilgiadapter(List<Bilgi> bilgiList, Context context) {
        this.bilgiList = bilgiList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bilgiList.size();
    }

    @Override
    public Object getItem(int position) {
        return  bilgiList.get(position) ;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        TextView userId=(TextView) convertView.findViewById(R.id.UserId);
        TextView id=(TextView) convertView.findViewById(R.id.id);
        TextView title=(TextView) convertView.findViewById(R.id.title);
        CheckBox completed=(CheckBox)convertView.findViewById(R.id.completed);
        userId.setText(userId.getText()+""+bilgiList.get(position).getUserId());
        id.setText(id.getText()+""+bilgiList.get(position).getId());
        title.setText(title.getText()+""+bilgiList.get(position).getTitle());
        Boolean deger=bilgiList.get(position).getCompleted();
        if(deger==true){
            completed.setChecked(true);
        }else{

            completed.setChecked(false);
        }



        return convertView;
    }
}
