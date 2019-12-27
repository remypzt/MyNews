package myNews.view.activitiesAndFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import myNews.myNews.R;

/**
 * Created by Remy Pouzet on 25/12/2019.
 */
public class FragmentSearchAndSettings extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        assert getArguments() != null;
        this.position = getArguments().getInt("position");
        View view = inflater.inflate(R.layout., container, false); ButterKnife.bind(this, view);

        this.showDatePickerDialog();

        this.showTimePickerDialog();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}
