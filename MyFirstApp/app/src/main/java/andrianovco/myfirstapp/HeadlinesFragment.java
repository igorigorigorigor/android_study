package andrianovco.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

    public class HeadlinesFragment extends ListFragment {
        OnHeadlineSeletedListener mCallback;

        public interface OnHeadlineSeletedListener {
            public void onArticleSelected(int position);
        }

        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            int layout = android.R.layout.simple_list_item_activated_1;

            setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Ipsum.Headlines));
        }

        @Override
        public  void onStart(){
            super.onStart();

            if (getFragmentManager().findFragmentById(R.id.article_fragment)!=null){
                getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            }
        }

        @Override
        public void onAttach(Activity activity){
            super.onAttach(activity);

            try {
                mCallback = (OnHeadlineSeletedListener) activity;
            }
            catch (ClassCastException e) {
                throw new ClassCastException((activity.toString() + " must implement OnHeadlineSeletedListener"));
            }
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id){
            mCallback.onArticleSelected(position);

            getListView().setItemChecked(position, true);
        }
    }