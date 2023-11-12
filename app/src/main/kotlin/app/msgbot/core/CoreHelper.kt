package app.msgbot.core

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

object CoreHelper {

    init {
        Logger.addLogAdapter(AndroidLogAdapter())
    }

}