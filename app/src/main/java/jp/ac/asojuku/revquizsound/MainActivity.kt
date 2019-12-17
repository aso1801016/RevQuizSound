package jp.ac.asojuku.revquizsound

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var soundPool: SoundPool;
    private var soundZerId = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume(){
        super.onResume();
        soundPool = SoundPool(5, AudioManager.STREAM_ALARM , 0);
        soundZerId = soundPool.load(this, R.raw.fastbtn, 1);

        //答えるボタン処理
        btn0.setOnClickListener {
            soundPool.play(soundZerId, 1.0f, 100f, 0, 0, 1.0f);
            //インデント生成( どこからどこまで情報 )
            Handler().postDelayed(Runnable {
                val intent = Intent(this, QuestActivity::class.java)
                startActivity(intent)
            }, 1000)
        }
    }

    override fun onPause() {
        super.onPause();
        soundPool.release();
    }
}