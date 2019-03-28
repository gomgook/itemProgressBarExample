package com.stewhouse.itemprogressbar

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class UnitTest {

    @Test
    fun initTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().context

        val itemProgressBar = ItemProgressBar(appContext)

        itemProgressBar.constructProgressBar(ArrayList(), null)
    }
}