package com.stewhouse.itemprogressbarexample

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.stewhouse.itemprogressbar.ItemProgressBar
import org.junit.Test

import org.junit.runner.RunWith
import java.util.ArrayList

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {

    @Test
    fun initTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().context

        val itemProgressBar = ItemProgressBar(appContext)
        val data: ArrayList<Any> = ArrayList()
        val stringData = "test data"
        data.add(stringData)

        itemProgressBar.constructProgressBar(data, null)
    }
}
