package cl.eme.a3kkingcapital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.BuildConfig
import cl.eme.a3kkingcapital.view.TrekkingSantiagoListingFragment
import timber.log.Timber

/*
 1. [ ] Fun Update
 2. [ ] Detail Fragment
 3. [ ] Layouts
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.mc, TrekkingSantiagoListingFragment()).commit()

        initLog()
    }
    private fun initLog(){
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}