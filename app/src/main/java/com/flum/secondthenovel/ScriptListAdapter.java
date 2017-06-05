package com.flum.secondthenovel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ScriptListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<String> script = new ArrayList<>();

    @Override
    public int getCount() {
        return script.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.script_line_layout, null);
        if(view instanceof TextView) {
            ((TextView) view).setText(script.get(i));
        }
        return view;
    }

    public ScriptListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public ArrayList<String> getScriptData(){
        return script;
    }
}
