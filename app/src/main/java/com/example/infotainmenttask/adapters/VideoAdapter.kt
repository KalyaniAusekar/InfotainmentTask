package com.example.infotainmenttask.adapters

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.infotainmenttask.R
import com.example.infotainmenttask.models.VideoModel
import kotlinx.android.synthetic.main.video_view_exoplayer.view.*

class VideoAdapter(arrvideo:ArrayList<VideoModel>) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder> (){

    var arrVideoModel : ArrayList<VideoModel> = arrvideo

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {

        return VideoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.video_view_exoplayer,parent,false))

    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {

        holder.videoSetData(arrVideoModel[position])
    }

    override fun getItemCount(): Int {

        return arrVideoModel.size
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun videoSetData(videoModel: VideoModel) {

            itemView.exo_txt_user_profile_name.text = videoModel.videousername
            itemView.videoView.setVideoPath(videoModel.videoUrl)
            itemView.videoView.setOnPreparedListener(object : MediaPlayer.OnPreparedListener {

                override fun onPrepared(mp: MediaPlayer) {

                    itemView.video_progressbar.visibility = View.GONE
                    mp.start()

                    val videoRatio = mp.videoWidth.toFloat() / mp.videoHeight.toFloat()
                    val screeRatio = itemView.videoView.width.toFloat() / itemView.videoView.height.toFloat()

                    val scale = videoRatio / screeRatio
                    if (scale > 1f) {

                        itemView.videoView.scaleX = scale
                    }
                    else {

                        itemView.videoView.scaleY = (1f / scale)
                    }
                }
            })

            itemView.videoView.setOnCompletionListener { object : MediaPlayer.OnCompletionListener {

                override fun onCompletion(mp: MediaPlayer) {
                    mp.start()
                }
            }}
        }

    }

}