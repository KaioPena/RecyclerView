package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Orientation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }
        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailsActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)

            startActivity(intent)
            Log.d("Kaio", contact.toString())

        }
    }
}

private val contacts = listOf(
    Contact(
        "Roque",
        "(55) 11 98747-9834",
        R.drawable.sample12
    ),
    Contact(
        name = "Bruna",
        phone = "(55) 11 92356-7384",
        icon = R.drawable.sample1
    ),
    Contact(
        name = "Lucas",
        phone = "55 (11) 98765-4321",
        R.drawable.sample2
    ),
    Contact(
        name = "Mariana",
        phone = "55 (21) 98234-5678",
        R.drawable.sample3
    ),
    Contact(
        name = "Milena",
        phone = "55 (31) 98876-5432",
        R.drawable.sample4
    ),
    Contact(
        name = "Amanda",
        phone = "55 (41) 98123-4567",
        R.drawable.sample5
    ),
    Contact(
        name = "Geovana",
        phone = "55 (51) 98765-1234",
        R.drawable.sample6
    ),
    Contact(
        name = "Gabriela",
        phone = "55 (51) 98738-4419",
        R.drawable.sample7
    ),
    Contact(
        name = "Bruno",
        phone = "55 (71) 98876-4321",
        R.drawable.sample8
    ),
    Contact(
        name = "Joseph",
        phone = "55 (81) 98123-5678",
        R.drawable.sample9
    ),
    Contact(
        name = "Pedro",
        phone = "55 (91) 98765-6789",
        R.drawable.sample10
    ),
    Contact(
        name = "Larissa",
        phone = "55 (85) 98234-7890",
        R.drawable.sample11
    ),
    Contact(
        name = "Yara",
        phone = "55 (62) 98876-1234",
        R.drawable.sample13
    ),
    Contact(
        name = "Julio",
        phone = "55 (19) 98123-6789",
        R.drawable.sample14
    ),
    Contact(
        name = "Andreia",
        phone = "55 (31) 98765-7890",
        R.drawable.sample15
    ),
    Contact(
        name = "Vanessa",
        phone = "55 (47) 98234-8901",
        R.drawable.sample16
    ),

    )