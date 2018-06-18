package github.chenupt.dragtoplayout.demo;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import de.greenrobot.event.EventBus;
import github.chenupt.dragtoplayout.AttachUtil;
import github.chenupt.dragtoplayout.demo.Test.MyDragTopLayout;
import github.chenupt.multiplemodel.recycler.ModelRecyclerAdapter;

public class Main2Activity extends FragmentActivity {
    private MyDragTopLayout myDragTopLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();

        myDragTopLayout = (MyDragTopLayout) findViewById(R.id.drag_layout);
        findViewById(R.id.top_view).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                Main2Activity.this.startActivity(intent);
            }
        });
    }

    private void initViews() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragment fragment = new MainFragment();
        fragmentManager.beginTransaction().add(R.id.drag_content_view, fragment).commit();
    }

    public MyDragTopLayout getMyDragTopLayout() {
        return myDragTopLayout;
    }
}
