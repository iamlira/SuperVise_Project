package com.juanliu.captain.activity;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

public class BaseActivity extends Activity{

	  private Context mContext;
	  private AlertDialog mAlertDialog;
	  private ProgressDialog mProgressDialog;
	  public SharedPreferences spSettting;
	  protected Dialog dialogsupport;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	 /**
	   * Show a alert dialog with the given title and message, if a dialog is
	   * already exist, update the display.
	   * 
	   * @param title
	   *          The title to show in the dialog
	   * @param msg
	   *          The message to show in the dialog.
	   */
	  public void showAlertDialog(String title, String msg) {
	    if (mAlertDialog == null) {
	      mAlertDialog = new AlertDialog.Builder(this).create();
	    }
	    mAlertDialog.setTitle(title);
	    mAlertDialog.setMessage(msg);
	    // mAlertDialog.setIcon(R.drawable.icon);
	    mAlertDialog.setCancelable(true);
	    mAlertDialog.setCanceledOnTouchOutside(true);
	    mAlertDialog.show();
	  }

	  @SuppressLint("NewApi")
	  public void showAlertDialog(int title, int msg) {
	    if (mAlertDialog == null) {
	      mAlertDialog = new AlertDialog.Builder(mContext, AlertDialog.THEME_HOLO_LIGHT).create();
	    }
	    mAlertDialog.setTitle(getString(title));
	    mAlertDialog.setMessage(getString(msg));
	    // mAlertDialog.setIcon(R.drawable.icon);
	    mAlertDialog.setCancelable(true);
	    mAlertDialog.setCanceledOnTouchOutside(true);
	    mAlertDialog.show();
	  }

	  /**
	   * Check if their is a dialog on the screen.
	   * 
	   * @return true if there is a dialog on the screen
	   */
	  public boolean isAlertShowing() {
	    if (mAlertDialog == null)
	      return false;
	    return mAlertDialog.isShowing();
	  }

	  /**
	   * Dismiss the dialog
	   */
	  public void dismissAlertDialog() {
	    if (mAlertDialog != null && mAlertDialog.isShowing()) {
	      mAlertDialog.dismiss();
	    }
	  }

	  /**
	   * Show a progress dialog with the given title and message, if a progress is
	   * already exist, update the display.
	   * 
	   * @param title
	   *          The title to show in the progress dialog
	   * @param msg
	   *          The message to show in the progress dialog
	   */
	  public void showProgressDialog(String title, String msg) {
	    if (mProgressDialog == null) {
	      mProgressDialog = new ProgressDialog(mContext, ProgressDialog.THEME_HOLO_LIGHT);
	    }
	    mProgressDialog.setTitle(title);
	    mProgressDialog.setMessage(msg);
	    mProgressDialog.setCanceledOnTouchOutside(false);
	    mProgressDialog.setCancelable(false);
	    mProgressDialog.show();
	  }

	  /**
	   * Show a progress dialog with the given title and message, if a progress is
	   * already exist, update the display.
	   * 
	   * @param titleResId
	   *          The title string recourse id to show in the progress dialog
	   * @param msgResId
	   *          The message string recourse id to show in the progress dialog
	   */
	  public void showProgressDialog(int titleResId, int msgResId) {
	    showProgressDialog(getString(titleResId), getString(msgResId));
	  }

	  /**
	   * Dismiss the progress dialog
	   */
	  public void dismissProgressDialog() {
	    if (mProgressDialog != null && mProgressDialog.isShowing()) {
	      mProgressDialog.dismiss();
	    }
	  }

	  public boolean validateInternet() {
		    ConnectivityManager manager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
		    if (manager == null) {
		      openWirelessSet();
		      return false;
		    } else {
		      NetworkInfo[] info = manager.getAllNetworkInfo();
		      if (info != null) {
		        for (int i = 0; i < info.length; i++) {
		          if (info[i].getState() == NetworkInfo.State.CONNECTED) {
		            return true;
		          }
		        }
		      }
		    }
		    openWirelessSet();
		    return false;
		  }
	  public void openWirelessSet() {
		    if (null != dialogsupport && dialogsupport.isShowing()) {
		      dialogsupport.cancel();
		    }
//		    dialogsupport = new AlertDialog.Builder(mContext).setTitle(R.string.str_prompt)
//		        .setMessage(mContext.getString(R.string.str_no_connection))
//		        .setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
//		          @Override
//		          public void onClick(DialogInterface dialog, int which) {
//		            dialog.cancel();
//		            Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
//		            mContext.startActivity(intent);
//		          }
//		        }).setNegativeButton(R.string.str_no, new DialogInterface.OnClickListener() {
//		          @Override
//		          public void onClick(DialogInterface dialog, int whichButton) {
//		            dialog.cancel();
//		          }
//		        }).create();
		    dialogsupport.setCanceledOnTouchOutside(false);
		    dialogsupport.show();
		  }
	  public void showAlertDialog(String title, String msg, String negativeText, OnClickListener negativeListener,
		      String positiveText, OnClickListener positiveListener) {
		    if (mAlertDialog == null) {
		      mAlertDialog = new AlertDialog.Builder(this).setNegativeButton(negativeText, negativeListener)
		          .setPositiveButton(positiveText, positiveListener).create();
		    }
		    mAlertDialog.setTitle(title);
		    mAlertDialog.setMessage(msg);
		    // mAlertDialog.setIcon(R.drawable.icon);
		    mAlertDialog.setCancelable(true);
		    mAlertDialog.setCanceledOnTouchOutside(true);
		    mAlertDialog.show();
	  }

}
