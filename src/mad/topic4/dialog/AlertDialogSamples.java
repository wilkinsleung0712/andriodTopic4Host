package mad.topic4.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.topic4_test.R;

public class AlertDialogSamples extends Activity{
	private static final int DIALOG_YES_NO_MESSAGE = 1;
	private static final int DIALOG_YES_NO_LONG_MESSAGE = 2;
	private static final int DIALOG_LIST = 3;
	private static final int DIALOG_PROGRESS = 4;
	private static final int DIALOG_SINGLE_CHOICE = 5;
	private static final int DIALOG_MULTIPLE_CHOICE = 6;
	private static final int DIALOG_TEXT_ENTRY = 7;
	private static final int DIALOG_MULTIPLE_CHOICE_CURSOR = 8;
	private static final int MAX_PROGRESS = 100;
	 private ProgressDialog mProgressDialog;
	 private int mProgress;
	 private Handler mProgressHandler;
	protected Dialog onCreateDialog(int id){
		switch(id){
		case DIALOG_YES_NO_MESSAGE:
			return new AlertDialog.Builder(this)
					.setIcon(R.drawable.alert_dialog_icon)
					.setTitle(R.string.alert_dialog_two_buttons_title)
					.setPositiveButton(R.string.alert_dialog_ok, 
							new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int whichButton) {
									// TODO Auto-generated method stub
									
								}
							})
					.setNegativeButton(R.string.alert_dialog_cancel, 
							new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							/* User clicked Cancel so do some stuff */
						}
						
					}).create();
		case DIALOG_YES_NO_LONG_MESSAGE:
			return new AlertDialog.Builder(this)
					.setIcon(R.drawable.alert_dialog_icon)
					.setTitle(R.string.alert_dialog_two_buttons_msg)
					.setMessage(R.string.alert_dialog_two_buttons2_msg)
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
		case DIALOG_LIST:
			return new AlertDialog.Builder(this)
					.setTitle(R.string.select_dialog)
					.setItems(R.array.select_dialog_items, 
							new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									/* User clicked so do some stuff */
			                           String[] items = getResources().getStringArray(
			                                 R.array.select_dialog_items);
			                           new AlertDialog.Builder(AlertDialogSamples.this)
			                                 .setMessage(
			                                       "You selected: " + which + " , "
			                                             + items[which]).show();
								}
							})
					.create();	
		case DIALOG_PROGRESS:
			mProgressDialog = new ProgressDialog(this);
			mProgressDialog.setIcon(R.drawable.alert_dialog_icon);
			mProgressDialog.setTitle(R.string.select_dialog);
			mProgressDialog.setProgressStyle(mProgressDialog.STYLE_HORIZONTAL);
			//mProgressDialog.setProgressStyle(mProgressDialog.STYLE_SPINNER);
			mProgressDialog.setMax(MAX_PROGRESS);
			mProgressDialog.setButton(DialogInterface.BUTTON_POSITIVE, 
										this.getText(R.string.alert_dialog_hide),
											new DialogInterface.OnClickListener() {
												
												@Override
												public void onClick(DialogInterface dialog, int which) {
													// TODO Auto-generated method stub
													
												}
											});
			mProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, 
										this.getText(R.string.alert_dialog_cancel),
											new DialogInterface.OnClickListener() {
												
												@Override
												public void onClick(DialogInterface dialog, int which) {
													// TODO Auto-generated method stub
													
												}
											});

			return mProgressDialog;		
		case DIALOG_SINGLE_CHOICE:
			return new AlertDialog.Builder(AlertDialogSamples.this)
						.setIcon(R.drawable.alert_dialog_icon)
						.setTitle(R.string.alert_dialog_single_choice)
						.setSingleChoiceItems(R.array.select_dialog_items2,
											0,
											new DialogInterface.OnClickListener() {
												
												@Override
												public void onClick(DialogInterface dialog, int whichButton) {
													// TODO Auto-generated method stub
													
												}
											})
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
								})		.create();
		case DIALOG_MULTIPLE_CHOICE:
			return new AlertDialog.Builder(this)
					.setIcon(R.drawable.alert_dialog_icon)
					.setTitle(R.string.alert_dialog_multi_choice)
					.setMultiChoiceItems(R.array.select_dialog_items3, 
							new boolean[]{false,true,false,true,false,false,false},
							new DialogInterface.OnMultiChoiceClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which, boolean isChecked) {
									// TODO Auto-generated method stub
									
								}
							})
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
		case DIALOG_MULTIPLE_CHOICE_CURSOR:
			String[] projection = new String[]{
					ContactsContract.Contacts._ID,
		               ContactsContract.Contacts.DISPLAY_NAME,
		               ContactsContract.Contacts.SEND_TO_VOICEMAIL
			};
			Cursor cursor =managedQuery(ContactsContract.Contacts.CONTENT_URI,
		               projection, null, null, null);
			return new AlertDialog.Builder(AlertDialogSamples.this)
            .setIcon(R.drawable.ic_popup_reminder)
            .setTitle(R.string.alert_dialog_multi_choice_cursor)
            .setMultiChoiceItems(cursor,
                  ContactsContract.Contacts.SEND_TO_VOICEMAIL,
                  ContactsContract.Contacts.DISPLAY_NAME,
                  new DialogInterface.OnMultiChoiceClickListener() {
                     public void onClick(DialogInterface dialog,
                           int whichButton, boolean isChecked)
                     {
                        Toast.makeText(
                              AlertDialogSamples.this,
                              "Readonly Demo Only - Data will not be updated",
                              Toast.LENGTH_SHORT).show();
                     }
                  }).create();
   case DIALOG_TEXT_ENTRY:
      // This example shows how to add a custom layout to an AlertDialog
      LayoutInflater factory = LayoutInflater.from(this);
      final View textEntryView = factory.inflate(
            R.layout.alert_dialog_text_entry, null);
      return new AlertDialog.Builder(AlertDialogSamples.this)
            .setIcon(R.drawable.alert_dialog_icon)
            .setTitle(R.string.alert_dialog_text_entry)
            .setView(textEntryView)
            .setPositiveButton(R.string.alert_dialog_ok,
                  new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog,
                           int whichButton)
                     {

                        /* User clicked OK so do some stuff */
                     }
                  })
            .setNegativeButton(R.string.alert_dialog_cancel,
                  new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog,
                           int whichButton)
                     {

                        /* User clicked cancel so do some stuff */
                     }
                  }).create();
		}
		return null;
		
	}

	 /**
	    * Initialization of the Activity after it is first created. Must at least
	    * call {@link android.app.Activity#setContentView(int)} to describe what is
	    * to be displayed in the screen.
	    */
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.alert_dialog);
		/*
	       * Display a text message with yes/no buttons and handle each message as
	       * well as the cancel action
	       */
		Button twoButtonsTitle = (Button)this.findViewById(R.id.two_buttons);
		twoButtonsTitle.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DIALOG_YES_NO_MESSAGE);
			}
			
		});
		
		/*make the button listen to the action */
		Button twoButtons2Title = (Button) this.findViewById(R.id.two_buttons2);
		twoButtons2Title.setOnClickListener(new OnClickListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DIALOG_YES_NO_LONG_MESSAGE);
			}
			
		});
		
		Button selectButton = (Button) this.findViewById(R.id.select_button);
		selectButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DIALOG_LIST);
			}
			
		});
		/*progress button with progress bar*/
		Button progressButton = (Button) this.findViewById(R.id.progress_button);
		progressButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DIALOG_PROGRESS);
				//before we start the progress button , we need to set the value to default
				mProgress=0;
				mProgressDialog.setProgress(0);
				mProgressHandler.sendEmptyMessage(0);
			}
			
		});
		/*single choice dialog, on radio button*/
		/* Display a radio button group */
		Button radioButton = (Button) this.findViewById(R.id.radio_button);
		radioButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DIALOG_SINGLE_CHOICE);
			}
			
		});
		 /* Display a list of checkboxes */
		Button checkBox = (Button) this.findViewById(R.id.checkbox_button);
		checkBox.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DIALOG_MULTIPLE_CHOICE);
			}
			
		});
		
		/*
		 * the handler is specify how does the progress bar response to the GUI
		 */
		 mProgressHandler = new Handler(){
			 @Override
	         public void handleMessage(Message msg)
	         {
	            super.handleMessage(msg);
	            if (mProgress >= MAX_PROGRESS)
	            {
	               mProgressDialog.dismiss();
	            }
	            else
	            {
	               mProgress++;
	               mProgressDialog.incrementProgressBy(1);
	               mProgressHandler.sendEmptyMessageDelayed(0, 100);
	            }
	         }
		 };
		 
		 /* Display a list of checkboxes, backed by a cursor */
	      Button checkBox2 = (Button) findViewById(R.id.checkbox_button2);
	      checkBox2.setOnClickListener(new OnClickListener() {
	         public void onClick(View v)
	         {
	            showDialog(DIALOG_MULTIPLE_CHOICE_CURSOR);
	         }
	      });

	      
		 /* Display a text entry dialog */
		 Button textEntry = (Button) findViewById(R.id.text_entry_button);
	      textEntry.setOnClickListener(new OnClickListener() {
	         public void onClick(View v)
	         {
	            showDialog(DIALOG_TEXT_ENTRY);
	         }
	      });
		
	}
}
