package hva.nl.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_portal.*

const val CREATE_PORTAL_ACTIVITY = 104

class CreatePortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_portal)
        initViews()
    }

    private fun initViews() {
        btnAddPortal.setOnClickListener { submitPortal() }
    }

    private fun submitPortal() {
        val portal = Portal(
            inputTitle.text.toString(),
            inputUri.text.toString()
        )
        val portalActivityIntent = Intent(this, StudentPortalActivity::class.java)
        setResult(Activity.RESULT_OK, portalActivityIntent)
        portalActivityIntent.putExtra(PORTAL_EXTRA, portal)
        finish()
    }
}
