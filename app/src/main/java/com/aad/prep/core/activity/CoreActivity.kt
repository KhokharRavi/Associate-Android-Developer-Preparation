package com.aad.prep.core.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aad.prep.R
import com.aad.prep.core.adapter.CoreAdapter
import com.aad.prep.core.adapter.CoreAdapter.ConceptItemClickListener
import com.aad.prep.util.Constant.TITLE

class CoreActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_core)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerViewConcept)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val conceptList: List<String> = resources.getStringArray(R.array.core_concept).toList();

        // This will pass the ArrayList to our Adapter
        val adapter =
            CoreAdapter(conceptList, itemClickListener = object : ConceptItemClickListener {
                override fun itemClick(position: Int) {

                    when (position) {
                        // Activity Lifecycle
                        0 -> {
                            navigateScreen(
                                ActivityLifecycleActivity::class.java,
                                conceptList[position]
                            )
                        }

                        // Fragment Lifecycle
                        1 -> {
                            navigateScreen(
                                FragmentLifecycleActivity::class.java,
                                conceptList[position]
                            )
                        }

                        // Android Intents
                        2 -> {
                            navigateScreen(
                                AndroidIntentActivity::class.java,
                                conceptList[position]
                            )
                        }

                        // Toasts
                        3 -> {
                            navigateScreen(
                                ToastActivity::class.java,
                                conceptList[position]
                            )
                        }

                        // Snackbar
                        4 -> {
                            navigateScreen(
                                SnackbarActivity::class.java,
                                conceptList[position]
                            )
                        }

                        // Android Notification
                        5 -> {
                            navigateScreen(
                                AndroidNotificationActivity::class.java,
                                conceptList[position]
                            )
                        }

                        // Android Services
                        6 -> {
                            navigateScreen(
                                AndroidServicesActivity::class.java,
                                conceptList[position]
                            )
                        }

                        // Broadcast Receivers
                        7 -> {
                            navigateScreen(
                                BroadcastReceiverActivity::class.java,
                                conceptList[position]
                            )
                        }

                        // Content Provider
                        8 -> {
                            navigateScreen(
                                ContentProviderActivity::class.java,
                                conceptList[position]
                            )
                        }

                        // App Localize
                        9 -> {
                            navigateScreen(
                                AppLocalizeActivity::class.java,
                                conceptList[position]
                            )
                        }

                        // WorkManager
                        10 -> {
                            navigateScreen(
                                WorkManagerActivity::class.java,
                                conceptList[position]
                            )
                        }
                    }
                }
            })

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }

    /**
     * Redirect to next screen
     */
    private fun navigateScreen(cls: Class<*>, value: String) {
        val intent: Intent = Intent(this@CoreActivity, cls)
        intent.putExtra(TITLE, value)
        startActivity(intent)
    }

}