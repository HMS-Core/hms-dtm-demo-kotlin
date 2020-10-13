/*
* Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

* Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/

package com.huawei.dtmdemoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsInstance
import com.huawei.hms.analytics.HiAnalyticsTools

class DynamicTagManager : AppCompatActivity() {

     companion object
     {
         var TAG = "DTM:MainActivity"
     }

    private lateinit var instance: HiAnalyticsInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_tag_manager)
       // test_button.setOnClickListener { sendEvent() }

        instance = HiAnalytics.getInstance(this)
        HiAnalyticsTools.enableLog()

        Log.e(TAG,"SendEvent")
        // developers can report custom event
        // event name is "Purchase"
        val eventName = "Purchase"
        // three fields in Bundle
        val bundle = Bundle()
        bundle.apply {
            putDouble("price", 999.0)
            putLong("quantity", 100L)
            putString("currency", "CNY")
        }
        // report
        //let operator
        instance.let {
            instance.onEvent(eventName, bundle)
            Log.d(TAG, "log event.")

        }
    }

    /* Method to use for Send Event */
    private fun sendEvent() {
        Log.e(TAG,"SendEvent")
        // developers can report custom event
        // event name is "Purchase"
        val eventName = "Purchase"
        // three fields in Bundle
        val bundle = Bundle()
        bundle.apply {
            putDouble("price", 999.0)
            putLong("quantity", 100L)
            putString("currency", "CNY")
        }
        // report
        //let operator
        instance.let {
            instance.onEvent(eventName, bundle)
            Log.d(TAG, "log event.")

        }
    }
}
