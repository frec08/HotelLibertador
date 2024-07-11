package empresa.android.apphotel.utils

import android.app.Application
import android.content.Context
import empresa.android.apphotel.data.InitBD

class appConfig:Application() {
    companion object {
        lateinit var CONTEXT:Context
        lateinit var BD:InitBD
        var BD_NAME="hotel.bd"
        var VERSION=2
    }
    override fun onCreate() {
        super.onCreate()
        CONTEXT =applicationContext
        BD=InitBD()
    }
}