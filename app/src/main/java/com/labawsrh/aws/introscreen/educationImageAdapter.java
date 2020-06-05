package com.labawsrh.aws.introscreen;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class educationImageAdapter extends RecyclerView.Adapter<educationImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Education> mEdcation;

    public educationImageAdapter(Context context, List<Education> educations)
    {
        mContext=context;
        mEdcation=educations;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(mContext).inflate(R.layout.education_image_item, viewGroup,false);
        return  new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {


        Education uploadCur=mEdcation.get(i);
        imageViewHolder.img_description.setText(uploadCur.getImgName());
        Picasso.get()
                .load(uploadCur.getImgUrl())
                .placeholder(R.drawable.imagepreview)
                .fit()
                .centerCrop()
                .into(imageViewHolder.image_view);

final String imageUri = uploadCur.getImgUrl();
        final String imageName = uploadCur.getImgName();
        final String imgsecondDesc = uploadCur.getSeconddesc();
        final String imgthirdDesc = uploadCur.getContact();
        final String imgfourDesc = uploadCur.getAddress();

        imageViewHolder.image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newInent = new Intent(mContext,educationAfterRecy.class);

                newInent.putExtra("imageName",imageName);
                newInent.putExtra("imageUri",imageUri);
                newInent.putExtra("imageSeconddesc",imgsecondDesc);
            newInent.putExtra("imageThirddesc",imgthirdDesc);
               newInent.putExtra("imageFourdesc",imgfourDesc);

              mContext.startActivity(newInent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mEdcation.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView img_description;
        public ImageView image_view;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img_description=itemView.findViewById(R.id.img_description);
            image_view=itemView.findViewById(R.id.image_view);
        }
    }
}
