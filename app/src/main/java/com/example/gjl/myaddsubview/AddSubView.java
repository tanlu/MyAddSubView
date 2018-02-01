package com.example.gjl.myaddsubview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class AddSubView extends LinearLayout implements View.OnClickListener {

    private EditText child_count;
    private TextView add;
    private static final String TAG = "AddSubView";

    public AddSubView(Context context) {
        this(context, null);
    }

    public AddSubView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddSubView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.add_sub_layout, this);
        TextView add = view.findViewById(R.id.add);
        TextView sub = view.findViewById(R.id.sub);
        child_count = view.findViewById(R.id.child_count);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        child_count.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                child_count.setFocusable(false);
                String num = child_count.getText().toString().trim();
                Log.d(TAG, "onClick() returned: " + num + "---");
                if (num.equals("")) {
                    return;
                }
                int i = Integer.parseInt(num);
                child_count.setText(++i + "");
                break;

            case R.id.sub:
                child_count.setFocusable(false);
                String num1 = child_count.getText().toString();
                int i1 = Integer.parseInt(num1);
                if (i1 == 0) {
                    return;
                }
                child_count.setText(--i1 + "");
                break;

            case R.id.child_count:
                child_count.setFocusable(true);
                break;
        }
    }

    //
    public void setCount(int count) {
        child_count.setText(count);
    }

    public int getCount() {
        return Integer.parseInt(child_count.getText().toString());
    }

}
