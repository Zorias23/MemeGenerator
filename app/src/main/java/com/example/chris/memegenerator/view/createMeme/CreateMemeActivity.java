package com.example.chris.memegenerator.view.createMeme;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.chris.memegenerator.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class CreateMemeActivity extends AppCompatActivity
{
    public static final int PICK_PHOTO_FOR_MEME = 8;
    private ImageView ivMeme;
    private EditText etBottom;
    private EditText etTop;
    private Bitmap meme;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_meme);
    }
    
    private void bindViews()
    {
        ivMeme = findViewById(R.id.ivCreateMeme);
        etTop = findViewById(R.id.etTop);
        etBottom = findViewById(R.id.etBottom);
    }
    
    public void pickImage()
    {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("outputX", 256);
        intent.putExtra("outputY", 256);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PICK_PHOTO_FOR_MEME);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode != RESULT_OK)
        {
            return;
        }
        if (requestCode == PICK_PHOTO_FOR_MEME)
        {
            final Bundle extras = data.getExtras();
            if (extras != null)
            {
                //Get image
                meme = extras.getParcelable("data");
                
                ivMeme.setImageBitmap(meme);
    
                
            }
        }
    }
    
    private void saveMeme(Bitmap meme)
    {
        etTop.setDrawingCacheEnabled(true);
        etBottom.setDrawingCacheEnabled(true);
        
        Bitmap bmp = Bitmap.createBitmap(etTop.getDrawingCache());
        
        Bitmap combined = combineImages(meme,bmp, true);
        etTop.setText("");
        bmp = Bitmap.createBitmap(etBottom.getDrawingCache());
        combined = combineImages(combined, bmp, false);
//        ivMeme.setScaleType(ImageView.ScaleType.CENTER);
        ivMeme.setImageBitmap(combined);
        etTop.setVisibility(View.INVISIBLE);
        etBottom.setVisibility(View.INVISIBLE);
    }
    
    public Bitmap combineImages(Bitmap background, Bitmap foreground, boolean top)
    {
        
        int width = 0, height = 0;
        Bitmap cs;
        
        width = getWindowManager().getDefaultDisplay().getWidth();
        height = getWindowManager().getDefaultDisplay().getHeight();
        
        cs = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas comboImage = new Canvas(cs);
        background = Bitmap.createScaledBitmap(background, width, height, true);
        comboImage.drawBitmap(background, 0, 0, null);
        if (top)
            comboImage.drawBitmap(foreground, 0,400, null);
        else
            comboImage.drawBitmap(foreground, 0, 1500, null);
        
        return cs;
    }
    
    public void onSaveMeme(View view)
    {
        saveMeme(meme);
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Created Meme");
        builder.setMessage("Which action would you like to perform?");
        builder.setPositiveButton("Share", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //share on fb or ig
            }
        });
        builder.setNegativeButton("Save to Device", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //save to device
            }
        });
        builder.show();
    }
    
    public void searchForPicture(View view)
    {
        //search for pic
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(CreateMemeActivity.this);
        alertDialog.setTitle("Search For Meme");
        alertDialog.setMessage("Meme Keywords:");
    
        final EditText input = new EditText(CreateMemeActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
    
        alertDialog.setPositiveButton("Search",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String keyword = input.getText().toString();
                        
                        //perform search
                    }
                });
    
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
    
        alertDialog.show();
    }
    
    public void chooseFromGallery(View view)
    {
        setContentView(R.layout.activity_create_meme);
        bindViews();
    
        pickImage();
    }
}
