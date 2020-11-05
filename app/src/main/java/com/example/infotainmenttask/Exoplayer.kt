package com.example.infotainmenttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.view.GestureDetector
import com.example.infotainmenttask.adapters.VideoAdapter
import com.example.infotainmenttask.models.VideoModel
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.PlayerView
import kotlinx.android.synthetic.main.activity_exoplayer.*

class Exoplayer : AppCompatActivity() {

    var arrviewModel = ArrayList<VideoModel>()
    var videoAdapter:VideoAdapter? = null

   /* lateinit var gestureDetector: GestureDetector
    var x2:Float = 0.0f
    var x1:Float = 0.0f
    var y2:Float = 0.0f
    var y1:Float = 0.0f


    companion object {
        const val MIN_DISTANCE = 150
    }*/

    private var exoplayerView : PlayerView? = null
    private var exoplayer : SimpleExoPlayer? = null
    private var playbackStateBuilder : PlaybackStateCompat.Builder? = null
    private var mediaSession: MediaSessionCompat? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_exoplayer)


        arrviewModel.add(VideoModel("https://assets.mixkit.co/videos/preview/mixkit-tree-with-yellow-flowers-1173-large.mp4","first"))
        arrviewModel.add(VideoModel("https://assets.mixkit.co/videos/preview/mixkit-man-under-multicolored-lights-1237-large.mp4","second"))
        arrviewModel.add(VideoModel("https://assets.mixkit.co/videos/preview/mixkit-man-holding-neon-light-1238-large.mp4","third"))
        arrviewModel.add(VideoModel("https://assets.mixkit.co/videos/preview/mixkit-sun-over-hills-1183-large.mp4","fourth"))

        videoAdapter = VideoAdapter(arrviewModel)
        video_view_pager.adapter = videoAdapter


       // gestureDetector = GestureDetector(this,this)

      //  exoplayerView = findViewById(R.id.simpleExoPlayerView)
      //  val viewPager2 = findViewById<ViewPager2>(R.id.video_view_pager)
        //initializePlayer()
    }
/*
   override fun onTouchEvent(event: MotionEvent?): Boolean {

        gestureDetector.onTouchEvent(event)

        when(event?.action) {

            //when we satrt to swipe

            0-> {

                x1 = event.x
                y1 = event.y
            }

            //when we end the swipe
            1-> {

                x2 = event.x
                y2 = event.y

                val valueX:Float = x2-x1
                val valueY:Float = y2-y1

                if (abs(valueX) > MIN_DISTANCE) {
                    // detect right to left swipe
                    if(x2 > x1) {

                        Toast.makeText(this,"Right swipe" , Toast.LENGTH_SHORT).show()
                    }
                    else {

                        Toast.makeText(this,"Left swipe" , Toast.LENGTH_SHORT).show()
                    }
                }

                else if(abs(valueY) > MIN_DISTANCE) {

                    // detect top to bottom swipe
                    if(y2 > y1) {

                        Toast.makeText(this,"bottom swipe" , Toast.LENGTH_SHORT).show()
                    }
                    else{

                        Toast.makeText(this,"Top swipe" , Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }*/

   /* private fun initializePlayer() {
        val trackSelector = DefaultTrackSelector()
        exoplayer = ExoPlayerFactory.newSimpleInstance(baseContext, trackSelector)
        exoplayerView?.player = exoplayer

        val userAgent = Util.getUserAgent(baseContext, "Exo")
        val mediaUri = Uri.parse("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
        val mediaSource = ExtractorMediaSource(mediaUri, DefaultDataSourceFactory(baseContext, userAgent), DefaultExtractorsFactory(), null, null)

        exoplayer?.prepare(mediaSource)

        val componentName = ComponentName(baseContext, "Exo")
        mediaSession = MediaSessionCompat(baseContext, "ExoPlayer", componentName, null)

        playbackStateBuilder = PlaybackStateCompat.Builder()

        playbackStateBuilder?.setActions(PlaybackStateCompat.ACTION_PLAY or PlaybackStateCompat.ACTION_PAUSE or
                PlaybackStateCompat.ACTION_FAST_FORWARD)

        mediaSession?.setPlaybackState(playbackStateBuilder?.build())
        mediaSession?.isActive = true
    }*/

   /* override fun onDestroy() {
        super.onDestroy()
        releasePlayer()
    }

    private fun releasePlayer() {
        if (exoplayer != null) {
            exoplayer?.stop()
            exoplayer?.release()
            exoplayer = null
        }
    }*/

    /*override fun onDown(p0: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onShowPress(p0: MotionEvent?) {
        TODO("Not yet implemented")
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onLongPress(p0: MotionEvent?) {
        //TODO("Not yet implemented")
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        //TODO("Not yet implemented")
        return false
    }*/
}