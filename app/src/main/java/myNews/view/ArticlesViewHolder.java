package myNews.view;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.data.repositories.model.Articles;
import myNews.devexchanges.myNews.R;

/**
 * Created by Remy Pouzet on 21/11/2019.
 */
public class ArticlesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.Article_title)
TextView textView;

public ArticlesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        }

public void updateWithArticles(Articles articles){

        this.textView.setText(articles.getTitle());
        }
        }