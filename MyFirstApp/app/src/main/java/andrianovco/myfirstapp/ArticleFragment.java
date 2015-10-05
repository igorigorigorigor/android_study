package andrianovco.myfirstapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {
    public static final String ARG_STRING = "position";
    int mCurrentPosition = -1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState!=null){
            mCurrentPosition = savedInstanceState.getInt(ARG_STRING);
        }
        return inflater.inflate(R.layout.article_view, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();

        Bundle args = getArguments();
        if (args !=null){
            updateArticleView(args.getString(ARG_STRING));
        } else {
            updateArticleView("NO TEXT RETRIEVED");
        }
    }

    public void updateArticleView(String text) {
        TextView article = (TextView) getActivity().findViewById(R.id.article);
        article.setText(text);
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt(ARG_STRING, mCurrentPosition);
    }
}