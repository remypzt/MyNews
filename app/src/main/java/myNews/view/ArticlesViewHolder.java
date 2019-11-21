package myNews.view;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.devexchanges.myNews.R;
import myNews.service.repositories.model.Articles;

/**
 * Created by Remy Pouzet on 21/11/2019.
 */
public class ArticlesViewHolder extends RecyclerView.ViewHolder {

@BindView(R.id.fragment_main_item_title)
TextView textView;

public ArticlesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        }

public void updateWithArticles(Articles articles){
        this.textView.setText(articles.getTitle());
        }
        }