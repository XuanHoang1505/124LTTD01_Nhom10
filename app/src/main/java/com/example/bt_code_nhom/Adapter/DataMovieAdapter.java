package com.example.bt_code_nhom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bt_code_nhom.Model.Movie;
import com.example.bt_code_nhom.Model.Movie;
import com.example.bt_code_nhom.R;

import java.util.List;

public class DataMovieAdapter extends RecyclerView.Adapter<DataMovieAdapter.MovieViewHolder> {
    private Context mContext;
    private List<Movie> mListMovie;
    private OnItemClickListener mListener; // Thay thế AdapterView.OnItemClickListener

    // Constructor nhận danh sách và listener
    public DataMovieAdapter(Context mContext, List<Movie> mListMovie, OnItemClickListener listener) {
        this.mContext = mContext;
        this.mListMovie = mListMovie;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate view và tạo MovieViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = mListMovie.get(position);

        // Gắn dữ liệu vào các thành phần trong ViewHolder
        holder.imgMovie.setImageResource(movie.getResourceImage());
        holder.tvName.setText(movie.getName());

        // Set OnClickListener cho mỗi item
        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onItemClick(movie); // Truyền đối tượng movie khi click
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListMovie != null ? mListMovie.size() : 0; // Bảo vệ null cho danh sách mListMovie
    }

    // MovieViewHolder
    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMovie;
        private TextView tvName;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.img_movie);
            tvName = itemView.findViewById(R.id.tv_movieName);
        }
    }

    // Interface để xử lý sự kiện click
    public interface OnItemClickListener {
        void onItemClick(Movie movie); // Truyền đối tượng movie khi item được click
    }
}
