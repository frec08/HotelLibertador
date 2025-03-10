package empresa.android.apphotel

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity :AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer:DrawerLayout
    private lateinit var toogle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout)){ v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var toolbar:Toolbar=findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        drawer=findViewById(R.id.drawer_layout)
        toogle= ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toogle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        var navigationView:NavigationView=findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        // Botones
        val btnSqlite = findViewById<ImageButton>(R.id.btnSqlite)
        btnSqlite.setOnClickListener {
            val intent = Intent(this, SQLiteActivity::class.java)
            startActivity(intent)
        }

        val btnCotiza = findViewById<ImageButton>(R.id.btnCotiza)
        btnCotiza.setOnClickListener {
            val intent = Intent(this, CotizaActivity::class.java)
            startActivity(intent)
        }

        val btnArchivos = findViewById<ImageButton>(R.id.btnArchivos)
        btnArchivos.setOnClickListener {
            val intent = Intent(this, ArchivoActivity::class.java)
            startActivity(intent)
        }



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.nosotros_item ->{
                var intent=Intent(this,NosotrosActivity::class.java)
                startActivity(intent)
            }
            R.id.terminos_item ->{
                var intent=Intent(this,TerminosActivity::class.java)
                startActivity(intent)
            }
        }

        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toogle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}