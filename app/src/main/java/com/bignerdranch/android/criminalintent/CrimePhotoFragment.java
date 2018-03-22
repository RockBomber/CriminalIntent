package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;

public class CrimePhotoFragment extends DialogFragment {

    private static final String ARG_PHOTO_FILE = "photoFile";

    private ImageView mBigCrimePhoto;
    private File mPhotoFile;

    public static CrimePhotoFragment newInstance(File photoFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO_FILE, photoFile);

        CrimePhotoFragment fragment = new CrimePhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPhotoFile = (File) getArguments().getSerializable(ARG_PHOTO_FILE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_photo, container, false);

        mBigCrimePhoto = (ImageView) v.findViewById(R.id.big_crime_photo);
        Bitmap bitmap = PictureUtils.getScaledBitmap(mPhotoFile.getPath(), getActivity());
        mBigCrimePhoto.setImageBitmap(bitmap);

        return v;
    }

    /*@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        File photoFile = (File) getArguments().getSerializable(ARG_PHOTO_FILE);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo, null);

        mBigCrimePhoto = (ImageView) v.findViewById(R.id.big_crime_photo);
        Bitmap bitmap = PictureUtils.getScaledBitmap(photoFile.getPath(), getActivity());
        mBigCrimePhoto.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.big_crime_photo)
                .create();
    }*/
}
