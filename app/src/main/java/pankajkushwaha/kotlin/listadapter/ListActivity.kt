/**
 * Copyright 2018 Pankaj Kushwaha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package pankajkushwaha.kotlin.listadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_activity.*
import kotlinx.android.synthetic.main.content_list_activity.*
import pankajkushwaha.kotlin.listadapter.adapter.ListAdapterCustom
import pankajkushwaha.kotlin.listadapter.interfaces.ListCallbackInterface

class ListActivity : AppCompatActivity(), ListCallbackInterface {
    var lists = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_activity)
        setSupportActionBar(toolbar)

        list.layoutManager = LinearLayoutManager(this)
        list.hasFixedSize()
        lists.add("Item 1")
        lists.add("Item 2")
        lists.add("Item 3")
        lists.add("Item 4")
        lists.add("Item 5")
        list.adapter = ListAdapterCustom(this, this, lists)
    }

    override fun itemClicked(pos: Int) {
        Toast.makeText(this, lists.get(pos) + " clicked", Toast.LENGTH_SHORT)
                .show();
    }
}
