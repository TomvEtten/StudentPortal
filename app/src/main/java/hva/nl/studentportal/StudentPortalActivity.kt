package hva.nl.studentportal

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_student_portal.*
import androidx.browser.customtabs.CustomTabsIntent



const val PORTAL_EXTRA = "PORTAL_EXTRA"

class StudentPortalActivity : AppCompatActivity() {
    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals, this::portalItemClicked)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_portal)
        initViews()
    }


    private fun portalItemClicked(portalItem : Portal) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(portalItem.uri))
    }

    private fun initViews() {
        rvPortals.layoutManager = StaggeredGridLayoutManager(2 , LinearLayoutManager.VERTICAL)
        rvPortals.adapter = portalAdapter
        fabAddPortal.setOnClickListener { addPortal() }
    }

    private fun addPortal() {
        val intent = Intent(this , CreatePortalActivity::class.java)
        startActivityForResult(intent, CREATE_PORTAL_ACTIVITY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK || requestCode != CREATE_PORTAL_ACTIVITY ) {
            return
        }
        portals.add(data!!.getParcelableExtra(PORTAL_EXTRA))
        portalAdapter.notifyDataSetChanged()
    }


}