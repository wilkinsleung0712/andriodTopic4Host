package mad.topic4.dialog.fragment;

import mad.topic4.dialog.fragment.dialogfragments.YesNoMessageDialogFragment;

import com.example.topic4_test.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class AlertDialogSamplesFragment extends Fragment{

	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
		View view=inflater.inflate(R.layout.alert_dialog, container, false);
		/*
	       * Display a text message with yes/no buttons and handle each message as
	       * well as the cancel action
	       */
		Button twoButtonsTitle = (Button) view.findViewById(R.id.two_buttons);
		twoButtonsTitle.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new YesNoMessageDialogFragment().show(getFragmentManager(), "yn");
			}
			
		});
		return view;
	}
}
