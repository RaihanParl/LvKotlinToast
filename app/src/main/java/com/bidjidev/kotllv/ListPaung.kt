package com.bidjidev.kotllv

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_list_paung.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class ListPaung : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_paung)
        val lvPaung = (findViewById(R.id.lvPaung)) as ListView
//        memberikan adapter untuk listView
        lvPaung.adapter = ContohAdapter(this)
//        memberi kondisi saat di touch akan memberi toast sesuai dengan nama yang di klik
        lvPaung.setOnItemClickListener { parent, view, position, id ->
//            membuat variable untuk contohAdapterho
            val adapter: ContohAdapter
//            menginisialisasikan ContohAdapter
            adapter = ContohAdapter(this)
//            memberikan toast dan toast ini otomatis lenght short
            toast("anda memilih = "+adapter.list[position])
        }
    }


    private class ContohAdapter(context: Context) : BaseAdapter(), ListAdapter {
        //    internal adalah access modifier yang bisa di akses keseluruhan asalkan masih dalam 1 modul yang sama
//    kita akan membuat array baru yaitu dengan method arrayListof()
        public var list = arrayListOf("Paung", "Faqih", "Dapull", "Jamet", "Sultan", "Panjul")
        //    buat variable dengan deklarasi propertinya adalah val yang berarti variable final atau tidak akan berubah
//    variable "inflater" ini akan di jadikan sebagai LayoutInflater
       private val inflater: LayoutInflater

        //    kemudian inisialisasikan layout inflater
        init {
            this.inflater = LayoutInflater.from(context)
        }

        // mereturn index dari array "list"
        override fun getItem(position: Int): Any {
            return list[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // mereturn data yang ada di array "list"
        override fun getCount(): Int {
            return list.size

        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
//        membuat variable untuk View
            val view: View?
//        membuat variable untuk class yang akan mengenalkan widget yang ada di layout list_row
            val holder: HolderListRow
            if (convertView == null) {
                view = this.inflater.inflate(R.layout.list_row, parent, false)
                holder = HolderListRow(view)
                view.tag = holder
            } else {
                view = convertView
                holder = view.tag as HolderListRow
            }
            holder.nama.text = list[position]
            return view
        }
    }
        private class HolderListRow(v: View?) {
            val nama: TextView

            init {
                this.nama = v?.findViewById(R.id.tvList) as TextView
            }
        }


}


