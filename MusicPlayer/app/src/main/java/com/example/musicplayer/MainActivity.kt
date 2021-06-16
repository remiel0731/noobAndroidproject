package com.example.musicplayer

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var playbtn: ImageButton
    lateinit var skipprev: ImageButton
    lateinit var skipnext: ImageButton
    lateinit var seekBar: SeekBar
    lateinit var runnable: Runnable
    lateinit var mediaplayer:MediaPlayer
    private var TotalTime: Int = 0
    private var currentIndex : Int = 0
    lateinit var elaspedTimeLabel: TextView
    lateinit var remainingTimeLabel : TextView
    //private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val songs : ArrayList<Int> = ArrayList()
        songs.add(0,R.raw.test1)
        songs.add(1,R.raw.test2)
        mediaplayer = MediaPlayer.create(applicationContext, songs[currentIndex])
        playbtn=findViewById(R.id.play_btn)
        seekBar=findViewById(R.id.seekbar)
        skipprev=findViewById(R.id.skip_previous)
        skipnext=findViewById(R.id.skip_next)
        elaspedTimeLabel = findViewById(R.id.elapsedTimeLabel)
        remainingTimeLabel = findViewById(R.id.remainingTimeLabel)
        TotalTime = mediaplayer.duration
        seekBar.progress = 0
        seekBar.max = TotalTime


        playbtn.setOnClickListener{
            TotalTime = mediaplayer.duration
            seekBar.max = mediaplayer.duration
            if(!mediaplayer.isPlaying){
                mediaplayer.start()
                playbtn.setImageResource(R.drawable.ic_pause)
            }
            else{
                mediaplayer.pause()
                playbtn.setImageResource(R.drawable.ic_play)
            }
        }

        skipnext.setOnClickListener {
            if(currentIndex < songs.size - 1){
                currentIndex++
            }
            else{
                currentIndex = 0
            }
            if(mediaplayer.isPlaying){
                mediaplayer.stop()
            }

            mediaplayer = MediaPlayer.create(applicationContext, songs[currentIndex])
            mediaplayer.start()
        }

        skipprev.setOnClickListener {
            if(currentIndex > 0){
                currentIndex--
            }
            else{
                currentIndex = songs.size - 1
            }
            if(mediaplayer.isPlaying){
                mediaplayer.stop()
            }

            mediaplayer = MediaPlayer.create(applicationContext, songs[currentIndex])
            mediaplayer.start()
        }

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if(changed){
                    mediaplayer.seekTo(pos)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        @SuppressLint("HandlerLeak")
        val handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                val currentPosition = msg.what
                seekBar.progress = currentPosition

                val elaspedTime = createTimeLabel(currentPosition)
                elaspedTimeLabel.text = elaspedTime

                val remainingTime = createTimeLabel(TotalTime - currentPosition)
                remainingTimeLabel.text = "-$remainingTime"

                mediaplayer.setOnCompletionListener {
                    playbtn.setImageResource(R.drawable.ic_play)
                    seekBar.progress = 0
                }
            }
        }
        Thread(Runnable {
            while(true){
                try{
                    val msg =  Message()
                    msg.what = mediaplayer.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                } catch (e: InterruptedException){
                }
            }
        }).start()
    }

    fun createTimeLabel(time : Int): String {
        var timelabel = ""
        val min = time / 1000 / 60
        val sec = time / 1000 % 60

        timelabel = "$min:"
        if(sec < 10 ) timelabel += "0"
        timelabel += sec

        return timelabel
    }
}