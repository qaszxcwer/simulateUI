package personal.simulateui.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import personal.simulateui.R
import personal.simulateui.adapter.RecyclerViewAdapter

class ListKotlinActivity : AppCompatActivity() {
    private val title: TextView by lazy { findViewById<TextView>(R.id.title) }
    private val list: RecyclerView by lazy { findViewById<RecyclerView>(R.id.list) }
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_kotlin)
        initView()
    }

    private fun initView() {
        list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter = RecyclerViewAdapter(getListData())
        list.adapter = adapter
    }

    private fun getListData() : ArrayList<String> {
        val list = ArrayList<String>()
        list.add("文字1")
        list.add("文字2")
        list.add("文字3")
        list.add("文字4")
        list.add("文字5")
        list.add("文字6")
        list.add("文字7")
        list.add("文字8")
        list.add("文字9")
        list.add("文字10")
        list.add("文字11")
        list.add("文字12")
        list.add("文字13")
        list.add("文字14")
        list.add("文字15")
        list.add("文字16")
        return list
    }
}