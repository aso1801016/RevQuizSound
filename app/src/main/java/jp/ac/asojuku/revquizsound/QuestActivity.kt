package jp.ac.asojuku.revquizsound

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quest.*
import java.util.concurrent.ForkJoinPool

class QuestActivity : AppCompatActivity() {

    private lateinit var soundPool: SoundPool;
    private var soundOneId = 0;
    private var soundSecId = 0;
    private var soundThrId = 0;
    private var soundFouId = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)
    }

    override fun onResume(){
        super.onResume();
        soundPool = SoundPool(500, AudioManager.STREAM_ALARM , 0);
        soundOneId = soundPool.load(this, R.raw.not, 1);
        soundSecId = soundPool.load(this, R.raw.light, 1);
        soundThrId = soundPool.load(this, R.raw.question, 1);
        soundFouId = soundPool.load(this, R.raw.cool, 1);

        //間違いボタン処理
        btn1.setOnClickListener {
            soundPool.play(soundOneId, 1.0f, 100f, 0, 0, 1.0f);
        }
        //正解ボタン処理
        btn2.setOnClickListener {
            soundPool.play(soundSecId, 1.0f, 100f, 0, 0, 1.0f);
        }
        //出題ボタン処理
        btn3.setOnClickListener {
            soundPool.play(soundThrId, 1.0f, 100f, 0, 0, 1.0f);
        }
        //拍手ボタン処理
        btn4.setOnClickListener {
            soundPool.play(soundFouId, 1.0f, 100f, 0, 0, 1.0f);
        }
    }

    override fun onPause() {
        super.onPause();
        soundPool.release();
    }
}
