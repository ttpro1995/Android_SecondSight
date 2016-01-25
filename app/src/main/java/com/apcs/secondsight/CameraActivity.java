package com.apcs.secondsight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.core.Mat;

public class CameraActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {

    private static final String TAG = CameraActivity.class.getSimpleName();

    //a key store index of active camera
    private static final String STATE_CAMERA_INDEX = "cameraIndex";

    //index of active camera
    private int mCameraIndex;

    //if camera is front-facing
    //it should be mirrored
    private boolean mIsCameraFrontFacing;

    //number of camera
    private int mNumCameras;

    //The camera view
    private CameraBridgeViewBase mCameraView;

    //whether the next camera frame should be saved as a photo
    private boolean mIsPhotoPending;

    // A matrix that is used when saving photos
    private Mat mBgr;

    // Whether an asynchronous menu action is in progress
    private boolean mIsMenuLocked;

    // the OpenCV loader callback
    private BaseLoaderCallback mLoaderCallback =
            new BaseLoaderCallback(this) {
                @Override
                public void onManagerConnected(int status) {
                    if (status == LoaderCallbackInterface.SUCCESS){
                        Log.d(TAG,"OpenCV loaded successfully");
                        mCameraView.enableView();
                        mBgr = new Mat();
                    }else {
                        super.onManagerConnected(status);
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        //TODO: page 45
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_camera, menu);
        return true;
    }

}
