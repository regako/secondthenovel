package com.flum.secondthenovel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity implements View.OnClickListener {
    ListView list;
    ScriptListAdapter listAdapter;

    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        list = (ListView)findViewById(R.id.script_list);
        listAdapter = new ScriptListAdapter(this);
        list.setAdapter(listAdapter);
        listAdapter.getScriptData().add(Contents.getScript().get(i));

        findViewById(R.id.next).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        listAdapter.getScriptData().add(parseScriptLine(Contents.getScript().get(++i)));
        listAdapter.notifyDataSetChanged();
        list.setSelection(i);
    }

    private String parseScriptLine(String fullScript) {
        String[] sepScript = fullScript.split("\\|");
        return sepScript[1];
    }
}
