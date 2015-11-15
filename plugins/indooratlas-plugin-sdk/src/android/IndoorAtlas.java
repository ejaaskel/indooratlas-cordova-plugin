package com.indooratlas.sdk;

import org.apache.cordova.*;
import org.json.*;
import java.util.*;
import android.content.*;
import android.util.*;
import android.os.Bundle;

import com.indooratlas.android.sdk.*;


public class IndoorAtlas extends CordovaPlugin {
    //private PebbleKit.PebbleDataLogReceiver mDataLogReceiver = null;

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext cb) throws JSONException {
    	
    	System.out.println("AAAAAA");
    	Log.d("IndoorAtlas","message ");
        if (action.equals("createIALocationManager")){
        	try{
            	//mIALocationManager = IALocationManager.create(this);
            	System.out.println("Starting functrion call");
            	//webView.loadUrl("javascript:console.log('hello');");
            	
            	final Context mContext = this.cordova.getActivity().getApplicationContext();
            	
            	webView.getView().post(new Runnable() {
                    public void run() {
                    	
                    	
                    	IALocationManager mialocationmanager = IALocationManager.create( mContext );
                    	/*if(mialocationmanager == null)
                    		cb.success(0);
                    	else
                    		cb.success(1);*/
                    	
                    	IALocationListener mIALocationListener = new IALocationListener() {

                    		// Called when the location has changed.
                    		@Override
                    		public void onLocationChanged(IALocation location) {

                    		    Log.d("IndoorAtlas", "Latitude: " + location.getLatitude());
                    		    Log.d("IndoorAtlas", "Longitude: " + location.getLongitude());
                    		}
                    		
                    		@Override
                    		public void onStatusChanged(String provider,int status,Bundle extras) {

                    		}
                    		
                    	};
                    	
                    	mialocationmanager.requestLocationUpdates(IALocationRequest.create(), mIALocationListener);

                   }
               });
            	

                //cb.success(IALocationManager.create( this.cordova.getActivity().getApplicationContext() ) ? 1 : 0);   		
        	}
        	catch(Exception e){
        		Log.d("IndoorAtlas",e.toString());
        	}
            
            return true;
        }

        /*if (action.equals("isDataLoggingSupported")){
            cb.success(PebbleKit.isDataLoggingSupported( this.cordova.getActivity().getApplicationContext() ) ? 1 : 0);
            return true;
        }*/

        

        return false;
    }
}