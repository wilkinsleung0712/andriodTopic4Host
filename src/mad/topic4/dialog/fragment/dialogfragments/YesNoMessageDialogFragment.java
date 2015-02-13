package mad.topic4.dialog.fragment.dialogfragments;

import com.example.topic4_test.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class YesNoMessageDialogFragment extends DialogFragment{
	public Dialog onCreateDialog(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		return new AlertDialog.Builder(this.getActivity())
					.setIcon(R.drawable.alert_dialog_icon)
					.setTitle(R.string.alert_dialog_two_buttons_title)
					.setPositiveButton(R.string.alert_dialog_ok, 
							new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									
								}
							})
					.setNegativeButton(R.string.alert_dialog_cancel,  
							new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									
								}
							})
							.create();
	}
}
