package myNews.view.adaptater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.myNews.R;


/**
 * Created by Remy Pouzet on 21/11/2019.
 */
public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesViewHolder> {

    // FOR DATA
    private List<Articles> articles;

    // CONSTRUCTOR
    public ArticlesAdapter(List<Articles> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // CREATE VIEW HOLDER AND INFLATING ITS XML LAYOUT
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_articles_content_item, parent, false);
        return new ArticlesViewHolder(view);
    }

    // UPDATE VIEW HOLDER WITH A ARTICLES
    @Override
    public void onBindViewHolder(ArticlesViewHolder viewHolder, int position) {
        viewHolder.updateWithArticles(this.articles.get(position));
    }

    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    @Override
    public int getItemCount() {
        return this.articles.size();
    }
}