package myNews.view.activitiesAndFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.data.repositories.model.Articles;
import myNews.myNews.R;
import myNews.view.adaptater.ArticlesAdapter;
import myNews.viewmodel.ViewModelMyNews;

public class FragmentArticles extends Fragment {
	// FOR DESIGN
	@BindView(R.id.fragment_main_recycler_view) public RecyclerView recyclerView;
	
	//FOR DATA
	private List<Articles>  articles;
	private ArticlesAdapter adapter;
	private int             position;
	
	public static FragmentArticles newInstance(int position) {
		FragmentArticles fragment = new FragmentArticles();
		Bundle           bundle   = new Bundle();
		bundle.putInt("position", position);
		fragment.setArguments(bundle);
		return fragment;
	}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater,
	                         @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {
		assert getArguments() != null;
		this.position = getArguments().getInt("position");
		View view = inflater.inflate(R.layout.fragment_articles_content, container, false);
		ButterKnife.bind(this, view);
		this.configureRecyclerView();
		return view;
	}
	
	@Override
	public void onViewCreated(@NonNull View view,
	                          @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ViewModelMyNews localViewModelMyNews = new ViewModelMyNews(position);
		localViewModelMyNews
				.getNews()
				.observe(this, this::updateList);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
	// UPDATE UI
	//updateListOfArticles still in Fragments cause I must call the adapter and I cannot do it in viewmodel
	
	public void updateList(List<Articles> articlesList) {
		articles.clear();
		if (articlesList != null) {
			articles.addAll(articlesList);
			adapter.notifyDataSetChanged();
		}
	}
	
	// CONFIGURATION
	// 3 - Configure RecyclerView, Adapter, LayoutManager & glue it together
	private void configureRecyclerView() {
		// 3.1 - Reset list
		this.articles = new ArrayList<>();
		
		// 3.2 - Create adapter passing the list of articles
		this.adapter = new ArticlesAdapter(this.articles);
		// 3.3 - Attach the adapter to the recyclerview to populate items
		this.recyclerView.setAdapter(this.adapter);
		// 3.4 - Set layout manager to position the items
		this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
	}
}

