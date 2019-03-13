package com.gallery.coverflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.gallery.R;
import com.gallery.coverflow.recyclerview.Adapter;

public class JustCoverFlowActivity extends AppCompatActivity implements Adapter.onItemClick {

    private RecyclerCoverFlow mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_coverflow);
        initList();
    }

    private void initList() {
        mList = (RecyclerCoverFlow) findViewById(R.id.list);
//        mList.setFlatFlow(true); //平面滚动
        mList.setGreyItem(true); //设置灰度渐变
        //mList.setAlphaItem(true); //设置半透渐变
	    mList.setIntervalRatio(0.4f);
        mList.setAdapter(new Adapter(this, this));
        mList.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                ((TextView)findViewById(R.id.index)).setText((position+1)+"/"+mList.getLayoutManager().getItemCount());
            }
        });
	    mList.scrollToPosition(2);
    }

    @Override
    public void clickItem(int pos) {
        mList.smoothScrollToPosition(pos);
    }
}
