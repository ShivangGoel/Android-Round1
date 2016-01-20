package com.demo.hqinterviewdemo.utils;

/**
 * @author Shivang Goel
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Alert {

	/**
	 * Method to show Alert Dialog with Positive Button Listener 
	 * @param context
	 * @param title
	 * @param message
	 * @param positive_button_dialog_ClickListener
	 */

	public void pop_Alert(Context context, String title, String message, DialogInterface.OnClickListener positive_button_dialog_ClickListener){
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setButton(Dialog.BUTTON_POSITIVE, "Yes",/* new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				System.exit(0);
				dialog.cancel();

			}
		}*/positive_button_dialog_ClickListener);
		alertDialog.setButton(Dialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		//		alertDialog.setIcon(R.drawable.validation_icon);
		alertDialog.show();
	}

	/**
	 * Method to show Alert Dialog for Network Connection
	 * @param context
	 * @param msg
	 */

	public static void pop_Alert(final Context context, String msg) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle("");
		alertDialog.setMessage(msg);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				//				System.exit(0);
				dialog.cancel();
				((Activity)context).finish();
			}
		});
		//		alertDialog.setIcon(R.drawable.validation_icon);
		alertDialog.show();
	}

	/**
	 * Method to show Network Alert Dialog that further exit from application
	 * @param context
	 */

}

/**
 * @author Shivang Goel
 */