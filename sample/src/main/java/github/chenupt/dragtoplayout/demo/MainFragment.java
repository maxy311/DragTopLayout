package github.chenupt.dragtoplayout.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import github.chenupt.dragtoplayout.demo.Test.MyDragTopLayout;
import github.chenupt.dragtoplayout.demo.Test.MyRecyclerView;
import github.chenupt.multiplemodel.ItemEntity;
import github.chenupt.multiplemodel.recycler.ModelRecyclerAdapter;

public class MainFragment extends Fragment {

    private LinearLayoutManager mLayoutManager;
    private MyRecyclerView mRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {


        mRecyclerView = (MyRecyclerView) getView().findViewById(R.id.recycler_view);
        // init recycler view
        ModelRecyclerAdapter adapter = new ModelRecyclerAdapter(getActivity(), DataService.getInstance().getModelManager());
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);
        // set data source
        List<ItemEntity> list = DataService.getInstance().getList();
        adapter.setList(list);
        adapter.notifyDataSetChanged();

        // attach top listener
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                EventBus.getDefault().post(AttachUtil.isRecyclerViewAttach(recyclerView));
                MyDragTopLayout myDragTopLayout = ((Main2Activity) getActivity()).getMyDragTopLayout();
                if (myDragTopLayout != null) {
                    int computeVerticalScrollOffset = mRecyclerView.getComputeVerticalScrollOffset();
                    myDragTopLayout.setTouchMode(computeVerticalScrollOffset == 0);
                }
            }
        });


    }
}


