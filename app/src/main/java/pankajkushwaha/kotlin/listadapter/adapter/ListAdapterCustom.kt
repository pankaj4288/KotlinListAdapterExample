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

package pankajkushwaha.kotlin.listadapter.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_layout.view.*
import pankajkushwaha.kotlin.listadapter.R
import pankajkushwaha.kotlin.listadapter.interfaces.ListCallbackInterface

class ListAdapterCustom(var context: Context, var callback: ListCallbackInterface, var lists:
ArrayList<String>) : RecyclerView
.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        var v = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return Item(v)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        holder!!.itemView.textView.text = lists[position]
        holder!!.itemView.card_view.setOnClickListener { callback.itemClicked(position) }
    }

    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView = itemView.textView
        var cardView = itemView.card_view
    }
}