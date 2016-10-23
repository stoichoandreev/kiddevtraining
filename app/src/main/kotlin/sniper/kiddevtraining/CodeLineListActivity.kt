package sniper.kiddevtraining

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.os.PowerManager
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatEditText
import android.view.KeyEvent
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import sniper.kiddevtraining.code_render_view.*
import sniper.kiddevtraining.code_render_view.game_interfaces.*

class CodeLineListActivity : AppCompatActivity(), Game {

    @BindView(R.id.code_input_field) lateinit var codeInput: AppCompatEditText
    @BindView(R.id.code_apply_button) lateinit var applyCode: FloatingActionButton

    private lateinit var codeEditorFragment: CodeEditorFragment
    private lateinit var codeSceneFragment: CodeSceneFragment

    lateinit var renderView: AndroidFastRenderView
    lateinit var myGraphics: Graphics
    lateinit var myAudio: Audio
    lateinit var myInput: Input
    lateinit var myFileIO: FileIO
    lateinit var myScreen: Screen
    lateinit var myGameDimensions: GameDimensions
    lateinit var wakeLock: PowerManager.WakeLock

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val frameBufferWidth = 1280
        val frameBufferHeight = 800
        val frameBuffer = Bitmap.createBitmap(frameBufferWidth,
                frameBufferHeight, Bitmap.Config.RGB_565)

        val scaleX = frameBufferWidth.toFloat() / windowManager.defaultDisplay.width
        val scaleY = frameBufferHeight.toFloat() / windowManager.defaultDisplay.height


        myGameDimensions = AndroidGameDimensions(this)
        renderView = AndroidFastRenderView(this, frameBuffer)
        myInput = AndroidInput(this, renderView, scaleX, scaleY)
        myGraphics = AndroidGraphics(assets, frameBuffer)
        myFileIO = AndroidFileIO(this)
        myAudio = AndroidAudio(this)

        initAllStaticResources()

        myScreen = getInitScreen()

        setContentView(R.layout.activity_codeline_list)
        ButterKnife.bind(this)

        codeEditorFragment = fragmentManager.findFragmentById(R.id.code_editor_fragment) as CodeEditorFragment
        codeSceneFragment = fragmentManager.findFragmentById(R.id.code_scene_fragment) as CodeSceneFragment

        applyCode.setOnClickListener {
            renderView.resume()
            applyCode.postDelayed({ renderView.pause() }, 5000)
            //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //                        .setAction("Action", null).show();
//
        }
        codeInput?.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            //only if action is up
            if (event.action == KeyEvent.ACTION_DOWN) {
                when (event.keyCode) {
                    KeyEvent.KEYCODE_ENTER -> {
                        val codeLine = v.text.toString()
                        val code = CodeDataModel(codeLine, R.drawable.confirm_icon)
                        codeEditorFragment.setAdapterCodeItem(code)
                        v.text = null
                        return@OnEditorActionListener true
                    }
                }
            }
            false
        })
        val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "KidCodeDevGame")
    }

    private fun initAllStaticResources() {

        Assets.background = myGraphics.newImage("background.png", Graphics.ImageFormat.RGB565)
        Assets.heroState = myGraphics.newImage("character.png", Graphics.ImageFormat.ARGB4444)
        Assets.heroStateOne = myGraphics.newImage("character1.png", Graphics.ImageFormat.ARGB4444)
        Assets.heroStateTwo = myGraphics.newImage("character2.png", Graphics.ImageFormat.ARGB4444)
        Assets.heroStateThree = myGraphics.newImage("character3.png", Graphics.ImageFormat.ARGB4444)
        Assets.heroJump = myGraphics.newImage("jumped.png", Graphics.ImageFormat.ARGB4444)
        Assets.heroDown = myGraphics.newImage("down.png", Graphics.ImageFormat.ARGB4444)
        Assets.enemyStateOne = myGraphics.newImage("heliboy.png", Graphics.ImageFormat.ARGB4444)
        Assets.tiledirt = myGraphics.newImage("tiledirt.png", Graphics.ImageFormat.RGB565)
        Assets.button = myGraphics.newImage("buttons.png", Graphics.ImageFormat.RGB565)

        Assets.load(this)
    }

    public override fun onResume() {
        super.onResume()
        wakeLock.acquire()
        myScreen.resume()
        //        renderView.resume();
        myAudio.resumeMusic()
    }

    public override fun onPause() {
        super.onPause()
        wakeLock.release()
        renderView.pause()
        myScreen.pause()
        myAudio.pauseMusic()

        if (isFinishing)
            myScreen.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
        myAudio.stopMusic()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        myScreen.backButton()
    }

    override fun getInput(): Input {
        return myInput
    }

    override fun getFileIO(): FileIO {
        return myFileIO
    }

    override fun getGraphics(): Graphics {
        return myGraphics
    }

    override fun getAudio(): Audio {
        return myAudio
    }

    override fun setScreen(screen: Screen) {
        if (screen == null)
            throw IllegalArgumentException("Screen must not be null")

        this.myScreen.pause()
        this.myScreen.dispose()
        screen.resume()
        screen.update(0f)
        this.myScreen = screen
    }

    override fun getCurrentScreen(): Screen {
        return myScreen
    }

    override fun getInitScreen(): Screen {
        return CodeApplyScreen(this)
    }

    override fun getGameDimensions(): GameDimensions {
        return myGameDimensions
    }
}
