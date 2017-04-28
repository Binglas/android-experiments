package com.tryus.snaporguess.ui.main;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.CompositePermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;
import com.karumi.dexter.listener.single.SnackbarOnDeniedPermissionListener;
import com.tryus.snaporguess.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        validateCameraPermission();
    }

    private void validateCameraPermission() {
        PermissionListener snackbarPermissionListener =
                SnackbarOnDeniedPermissionListener.Builder
                        .with((ViewGroup) findViewById(R.id.container), R.string.snackbar_permission_camera)
                        .withOpenSettingsButton(R.string.snackbar_permission_button_settings)
                        .withDuration(Snackbar.LENGTH_INDEFINITE)
                        .withCallback(new Snackbar.Callback() {
                            @Override
                            public void onShown(Snackbar snackbar) {
                                // Event handler for when the given Snackbar is visible
                            }

                            @Override
                            public void onDismissed(Snackbar snackbar, int event) {
                                // Event handler for when the given Snackbar has been dismissed
                            }
                        }).build();

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {

            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                token.continuePermissionRequest();
            }
        };


        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new CompositePermissionListener(permissionListener, snackbarPermissionListener))
                .check();
    }

}
