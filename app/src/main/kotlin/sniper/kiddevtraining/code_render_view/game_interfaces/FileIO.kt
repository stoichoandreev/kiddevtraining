package sniper.kiddevtraining.code_render_view.game_interfaces

import android.content.SharedPreferences

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

/**
 * Created by sniper on 7/10/14.
 */
interface FileIO {
    @Throws(IOException::class)
    fun readFile(file: String): InputStream

    @Throws(IOException::class)
    fun writeFile(file: String): OutputStream

    @Throws(IOException::class)
    fun readAsset(file: String): InputStream

    fun getSharedPref(): SharedPreferences
}
